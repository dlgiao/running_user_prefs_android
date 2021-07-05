package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.ActivityMasBinding
import com.kmmania.runninguserpreferences.viewmodels.MasViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MasActivity : AppCompatActivity() {
    private lateinit var masBinding: ActivityMasBinding
    private val masViewModel: MasViewModel by viewModels()
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        masBinding = ActivityMasBinding.inflate(layoutInflater)
        setContentView(masBinding.root)

        msViewModel.msValue.observe(this, { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> masBinding.tvUnitMas.text = getString(R.string.kmh)
                    "IMPERIAL" -> masBinding.tvUnitMas.text = getString(R.string.mph)
                }
            }
        })

        masViewModel.masValue.observe(this, { mas ->
            mas?.let {
                masBinding.etMasValue.editText?.setText(it.masValue.toString())
            }
        })

        masBinding.btnSaveMas.setOnClickListener {
            val masValue = masBinding.etMasValue.editText?.text.toString()
            val masUnit = masBinding.tvUnitMas.text.toString()
            val masArray = arrayOf(masValue, masUnit)
            replyIntentArray(masArray)
        }
    }

    private fun replyIntentArray(value: Array<String>) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY1, value)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }

    // TODO: Create CONSTANTS file
    companion object {
        const val EXTRA_REPLY1 = "com.example.android.wordlistsql.REPLY1"
    }
}
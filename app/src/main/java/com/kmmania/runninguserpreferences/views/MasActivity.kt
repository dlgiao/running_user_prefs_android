package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
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
                    "METRIC" -> {
                        masBinding.rbKmh.isEnabled = false
                        masBinding.rbMph.isEnabled = false
                        masBinding.rbKmh.isChecked = true
                    }
                    "IMPERIAL" -> {
                        masBinding.rbKmh.isEnabled = false
                        masBinding.rbMph.isEnabled = false
                        masBinding.rbMph.isChecked = true
                    }
                }
            }
        })

        masViewModel.masValue.observe(this, { mas ->
            mas?.let {
                masBinding.etMasValue.editText?.setText(it.masValue.toString())
                when(it.masUnit.toString()) {
                    "KMH" -> masBinding.rbKmh.isChecked = true
                    "MPH" -> masBinding.rbMph.isChecked = true
                }
            }
        })

        masBinding.btnSave.setOnClickListener {
            val masValue = masBinding.etMasValue.editText?.text.toString()
            var masUnit = ""
            if (masBinding.rbKmh.isChecked) {
                masUnit = getString(R.string.kmh)
            } else if (masBinding.rbMph.isChecked) {
                masUnit = getString(R.string.mph)
            }
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
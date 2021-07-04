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

class MasActivity : AppCompatActivity() {
    private lateinit var masBinding: ActivityMasBinding
    private val masViewModel: MasViewModel by viewModels()
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        masBinding = ActivityMasBinding.inflate(layoutInflater)
        setContentView(masBinding.root)

        masViewModel.masValue.observe(this, { mas ->
            mas?.let {
                masBinding.etMasValue.editText?.text
                when(it.masUnit.toString()) {
                    "KMH" -> masBinding.rbKmh.isChecked = true
                    "MPH" -> masBinding.rbMph.isChecked = true
                }
            }
        })

        masBinding.btnSave.setOnClickListener {
            val mas1 = masBinding.etMasValue.editText?.text.toString()
            var mas2 = ""
            if (masBinding.rbKmh.isChecked) {
                mas2 = getString(R.string.kmh)
            } else if (masBinding.rbMph.isChecked) {
                mas2 = getString(R.string.mph)
            }
            val masArray = arrayOf(mas1, mas2)
            replyIntent(masArray)
        }
    }

    private fun replyIntent(value: Array<String>) {
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
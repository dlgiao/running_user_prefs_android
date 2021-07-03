package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
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
    }

    private fun replyIntent(value: String) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY, value)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }

    // TODO: Create CONSTANTS file
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
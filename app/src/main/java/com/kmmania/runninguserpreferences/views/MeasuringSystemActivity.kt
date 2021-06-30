package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMeasuringSystemBinding
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory

class MeasuringSystemActivity : AppCompatActivity() {
    private val msViewModel: MeasuringSystemViewModel by viewModels {
        MeasuringSystemViewModelFactory((application as RunningUserPrefApplication).msRepository)
    }
    private lateinit var msBinding: ActivityMeasuringSystemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        msBinding = ActivityMeasuringSystemBinding.inflate(layoutInflater)
        setContentView(msBinding.root)

        msViewModel.lastMeasuringSystem.observe(this, { last ->
            last?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> msBinding.rbMetric.isChecked = true
                    "IMPERIAL" -> msBinding.rbImperial.isChecked = true
                }
            }
        })

        msBinding.rbMetric.setOnClickListener {
            replyIntent("metric")
        }
        msBinding.rbImperial.setOnClickListener {
            replyIntent("imperial")
        }
    }

    private fun replyIntent(msValue: String) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY, msValue)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
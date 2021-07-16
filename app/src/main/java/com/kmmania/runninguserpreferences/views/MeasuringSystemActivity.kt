package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
//import com.kmmania.runninguserpreferences.application.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMeasuringSystemBinding
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.EXTRA_REPLY_STRING
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import dagger.hilt.android.AndroidEntryPoint
//import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
//import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory

@AndroidEntryPoint
class MeasuringSystemActivity : AppCompatActivity() {
    private lateinit var msBinding: ActivityMeasuringSystemBinding
    private val msViewModel: MeasuringSystemViewModel by viewModels()
//    private val msViewModel: MeasuringSystemViewModel by viewModels {
//        MeasuringSystemViewModelFactory((application as RunningUserPrefApplication).msRepository)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        msBinding = ActivityMeasuringSystemBinding.inflate(layoutInflater)
        setContentView(msBinding.root)

        msViewModel.msValue.observe(this, { ms ->
            ms?.let {
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

    private fun replyIntent(value: String) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY_STRING, value)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }
}
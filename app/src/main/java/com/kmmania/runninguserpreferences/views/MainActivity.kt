package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMainBinding
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory

class MainActivity : AppCompatActivity() {
    private val msViewModel: MeasuringSystemViewModel by viewModels {
        MeasuringSystemViewModelFactory((application as RunningUserPrefApplication).msRepository)
    }
    private lateinit var mainBinding: ActivityMainBinding
    private val msActivityRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.tvMsTitle.setOnClickListener {
            val intent = Intent(this@MainActivity, MeasuringSystemActivity::class.java)
            startActivityForResult(intent, msActivityRequestCode)
        }

        msViewModel.lastMeasuringSystem.observe(this, { last ->
            last?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> mainBinding.tvMsValue.text = getString(R.string.metric)
                    "IMPERIAL" -> mainBinding.tvMsValue.text = getString(R.string.imperial)
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == msActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(MeasuringSystemActivity.EXTRA_REPLY)?.let {
                when(it) {
                    "metric" -> {
                        val metricMS = MeasuringSystem(MeasuringSystemUnit.METRIC)
                        msViewModel.insert(metricMS)
                        mainBinding.tvMsTitle.text = it
                    }
                    "imperial" -> {
                        val imperialMS = MeasuringSystem(MeasuringSystemUnit.IMPERIAL)
                        msViewModel.insert(imperialMS)
                        mainBinding.tvMsTitle.text = it
                    }
                    else -> ""
                }
            }
        }

    }
}
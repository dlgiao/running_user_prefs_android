package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMeasuringSystemBinding
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory

class MeasuringSystemActivity : AppCompatActivity() {
    private val msViewModel: MeasuringSystemViewModel by viewModels {
        MeasuringSystemViewModelFactory(
            (application as RunningUserPrefApplication).measuringSystemRepository
        )
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

        msBinding.rgMS.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                R.id.rb_metric -> msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.METRIC))
                R.id.rb_imperial -> msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.IMPERIAL))
            }
        }
    }
}
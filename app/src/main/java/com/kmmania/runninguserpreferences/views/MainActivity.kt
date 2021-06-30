package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.getStringExtra(MeasuringSystemActivity.EXTRA_REPLY)?.let {
                when(it) {
                    "metric" -> msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.METRIC))
                    "imperial" -> msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.IMPERIAL))
                    // TODO replace code
                    else -> ""
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.tvMsTitle.setOnClickListener {
            startForResult.launch(Intent(this, MeasuringSystemActivity::class.java))
        }

        msViewModel.lastMS.observe(this, { last ->
            last?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> mainBinding.tvMsValue.text = getString(R.string.metric)
                    "IMPERIAL" -> mainBinding.tvMsValue.text = getString(R.string.imperial)
                }
            }
        })
    }
}
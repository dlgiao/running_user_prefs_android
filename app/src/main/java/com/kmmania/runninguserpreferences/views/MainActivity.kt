package com.kmmania.runninguserpreferences.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMainBinding
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory

class MainActivity : AppCompatActivity() {
    private val msViewModel: MeasuringSystemViewModel by viewModels {
        MeasuringSystemViewModelFactory(
            (application as RunningUserPrefApplication).measuringSystemRepository
        )
    }
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.tvMsTitle.setOnClickListener {
            val intent = Intent(this, MeasuringSystemActivity::class.java)
            startActivity(intent)
        }

        msViewModel.lastMeasuringSystem.observe(this, { last ->
            last?.let {
                mainBinding.tvMsValue.text = it.toString()
            }
        })
    }
}
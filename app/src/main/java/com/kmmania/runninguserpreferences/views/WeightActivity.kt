package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.databinding.ActivityWeightBinding
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.WeightViewModel

class WeightActivity : AppCompatActivity() {
    private lateinit var weightBinding: ActivityWeightBinding
    private val weightViewModel: WeightViewModel by viewModels()
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weightBinding = ActivityWeightBinding.inflate(layoutInflater)
        setContentView(weightBinding.root)
    }
}
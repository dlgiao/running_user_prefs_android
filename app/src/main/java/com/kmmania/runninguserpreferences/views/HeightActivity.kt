package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.databinding.ActivityHeightBinding
import com.kmmania.runninguserpreferences.viewmodels.HeightViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel

class HeightActivity : AppCompatActivity() {
    private lateinit var heightBinding: ActivityHeightBinding
    private val heightViewModel: HeightViewModel by viewModels()
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        heightBinding = ActivityHeightBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(heightBinding.root)
    }
}
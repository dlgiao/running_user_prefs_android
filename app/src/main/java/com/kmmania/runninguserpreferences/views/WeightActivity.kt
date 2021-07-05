package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmmania.runninguserpreferences.databinding.ActivityWeightBinding

class WeightActivity : AppCompatActivity() {
    private lateinit var weightBinding: ActivityWeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weightBinding = ActivityWeightBinding.inflate(layoutInflater)
        setContentView(weightBinding.root)
    }
}
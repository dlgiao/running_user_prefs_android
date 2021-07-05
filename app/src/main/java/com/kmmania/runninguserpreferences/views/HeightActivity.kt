package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmmania.runninguserpreferences.databinding.ActivityHeightBinding

class HeightActivity : AppCompatActivity() {
    private lateinit var heightBinding: ActivityHeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        heightBinding = ActivityHeightBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(heightBinding.root)
    }
}
package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.databinding.ActivityGenderBinding
import com.kmmania.runninguserpreferences.viewmodels.GenderViewModel

class GenderActivity : AppCompatActivity() {
    private val genderViewModel: GenderViewModel by viewModels()
    private lateinit var genderBinding: ActivityGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        genderBinding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(genderBinding.root)
    }
}
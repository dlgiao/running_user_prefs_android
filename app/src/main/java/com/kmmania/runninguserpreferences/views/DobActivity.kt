package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.databinding.ActivityDobBinding
import com.kmmania.runninguserpreferences.viewmodels.DobViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DobActivity : AppCompatActivity() {
    private lateinit var dobBinding: ActivityDobBinding
    private val dobViewModel: DobViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dobBinding = ActivityDobBinding.inflate(layoutInflater)
        setContentView(dobBinding.root)

        dobViewModel.dobValue.observe(this, { value ->
            //
        })

        dobBinding.btnDatepicker.setOnClickListener {
            //
        }
    }
}
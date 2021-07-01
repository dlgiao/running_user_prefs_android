package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmmania.runninguserpreferences.databinding.ActivityDobBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DobActivity : AppCompatActivity() {
    private lateinit var dobBinding: ActivityDobBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dobBinding = ActivityDobBinding.inflate(layoutInflater)
        setContentView(dobBinding.root)
    }
}
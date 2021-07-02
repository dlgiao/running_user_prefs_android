package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kmmania.runninguserpreferences.databinding.ActivityMasBinding

class MasActivity : AppCompatActivity() {
    private lateinit var masBinding: ActivityMasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        masBinding = ActivityMasBinding.inflate(layoutInflater)
        setContentView(masBinding.root)
    }
}
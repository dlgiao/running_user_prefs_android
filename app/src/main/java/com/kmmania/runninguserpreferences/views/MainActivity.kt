package com.kmmania.runninguserpreferences.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMainBinding
import com.kmmania.runninguserpreferences.viewmodels.UserPrefViewModel
import com.kmmania.runninguserpreferences.viewmodels.UserPrefViewModelFactory

class MainActivity : AppCompatActivity() {
    private val userPrefViewModel: UserPrefViewModel by viewModels {
        UserPrefViewModelFactory((application as RunningUserPrefApplication).repository)
    }
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        //setContentView(R.layout.activity_main)

//        userPrefViewModel.allUserPref.observe(this, { userPrefs ->
//            //
//        })

        mainBinding.tvMeasuringSystem.setOnClickListener {
            val intent = Intent(this, MeasuringSystemActivity::class.java)
            startActivity(intent)
        }
    }
}
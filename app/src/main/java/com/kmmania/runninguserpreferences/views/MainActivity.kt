package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.UserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMainBinding
import com.kmmania.runninguserpreferences.viewmodels.UserPrefViewModel
import com.kmmania.runninguserpreferences.viewmodels.UserPrefViewModelFactory

class MainActivity : AppCompatActivity() {
//    private val userPrefViewModel: UserPrefViewModel by viewModels {
//        UserPrefViewModelFactory((application as RunningUserPrefApplication).repository)
//    }
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        //setContentView(R.layout.activity_main)

//        userPrefViewModel.allUserPref.observe(this, { userPrefs ->
//            //
//        })
    }
}
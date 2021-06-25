package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.UserPrefApplication
import com.kmmania.runninguserpreferences.viewmodels.UserPrefViewModel
import com.kmmania.runninguserpreferences.viewmodels.UserPrefViewModelFactory

class MainActivity : AppCompatActivity() {
    private val userPrefViewModel: UserPrefViewModel by viewModels {
        UserPrefViewModelFactory((application as UserPrefApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userPrefViewModel.allUserPref.observe(this, { userPrefs ->
            //
        })
    }
}
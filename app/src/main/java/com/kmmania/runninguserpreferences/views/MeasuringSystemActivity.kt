package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMeasuringSystemBinding
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory

class MeasuringSystemActivity : AppCompatActivity() {
    private val msViewModel: MeasuringSystemViewModel by viewModels {
        MeasuringSystemViewModelFactory((application as RunningUserPrefApplication)
            .measuringSystemRepository
        )
    }
    private lateinit var msBinding: ActivityMeasuringSystemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        msBinding = ActivityMeasuringSystemBinding.inflate(layoutInflater)
        setContentView(msBinding.root)
        //setContentView(R.layout.activity_measuring_system)

        val checkedRadioButtonId = msBinding.rgMS.checkedRadioButtonId
        msBinding.rgMS.setOnCheckedChangeListener { group, checkedId ->
            //
        }

        // to listen for a radio button's checked, unchecked state changes
        msBinding.rgMS.setOnCheckedChangeListener { buttonView, isChecked ->
            //
        }
    }
}
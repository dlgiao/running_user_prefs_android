package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
//import com.kmmania.runninguserpreferences.application.RunningUserPrefApplication
import com.kmmania.runninguserpreferences.databinding.ActivityMainBinding
import com.kmmania.runninguserpreferences.model.Dob
import com.kmmania.runninguserpreferences.model.Gender
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.utils.units.GenderUnit
import com.kmmania.runninguserpreferences.utils.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.viewmodels.DobViewModel
import com.kmmania.runninguserpreferences.viewmodels.GenderViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
//import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    // ViewModel
    private val msViewModel: MeasuringSystemViewModel by viewModels()
    private val genderViewModel: GenderViewModel by viewModels()
    private val dobViewModel: DobViewModel by viewModels()

    // StartForResult
    private val msStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.getStringExtra(MeasuringSystemActivity.EXTRA_REPLY)?.let {
                when(it) {
                    "metric" -> msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.METRIC))
                    "imperial" -> msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.IMPERIAL))
                    // TODO replace code
                    else -> ""
                }
            }
        }
    }
    private val genderStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.getStringExtra(GenderActivity.EXTRA_REPLY)?.let {
                when(it) {
                    "male" -> genderViewModel.insert(Gender(GenderUnit.MALE))
                    "female" -> genderViewModel.insert(Gender(GenderUnit.FEMALE))
                    // TODO replace code
                    else -> ""
                }
            }
        }
    }
    private val dobStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        val data = result.data
        data?.getStringExtra(DobActivity.EXTRA_REPLY)?.let {
            dobViewModel.insert(Dob(it))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        // Measuring system
        mainBinding.tvMsTitle.setOnClickListener {
            msStartForResult.launch(Intent(this, MeasuringSystemActivity::class.java))
        }
        msViewModel.msValue.observe(this, { value ->
            value?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> mainBinding.tvMsValue.text = getString(R.string.metric)
                    "IMPERIAL" -> mainBinding.tvMsValue.text = getString(R.string.imperial)
                    else -> mainBinding.tvMsValue.text = getString(R.string.unknown)
                }
            }
        })

        // Gender
        mainBinding.tvGenderTitle.setOnClickListener {
            genderStartForResult.launch(Intent(this, GenderActivity::class.java))
        }
        genderViewModel.genderValue.observe(this, { value ->
            value?.let {
                when(it.gender.toString()) {
                    "MALE" -> mainBinding.tvGenderValue.text = getString(R.string.male)
                    "FEMALE" -> mainBinding.tvGenderValue.text = getString(R.string.female)
                    else -> mainBinding.tvGenderValue.text = getString(R.string.unknown)
                }
            }
        })

        //Dob
        mainBinding.tvDobTitle.setOnClickListener {
            dobStartForResult.launch(Intent(this, DobActivity::class.java))
        }
        dobViewModel.dobValue.observe(this, { value ->
            value?.let {
                mainBinding.tvDobValue.text = it.dob
            }
        })
    }
}
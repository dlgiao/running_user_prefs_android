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
import com.kmmania.runninguserpreferences.model.*
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.EXTRA_REPLY_ARRAY
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.EXTRA_REPLY_STRING
import com.kmmania.runninguserpreferences.utils.units.*
import com.kmmania.runninguserpreferences.viewmodels.*
//import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    // ViewModel
    private val msViewModel: MeasuringSystemViewModel by viewModels()
    private val genderViewModel: GenderViewModel by viewModels()
    private val dobViewModel: DobViewModel by viewModels()
    private val masViewModel: MasViewModel by viewModels()
    private val heightViewModel: HeightViewModel by viewModels()
    private val weightViewModel: WeightViewModel by viewModels()

    // StartForResult
    private val msStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.getStringExtra(EXTRA_REPLY_STRING)?.let {
                // TODO: Convert data to the new unit
                // mas
//                val masValue = masViewModel.masValue.value!!.masValue
                // height
//                val heightValue = heightViewModel.heightValue.value!!.heightValue
                // weight
//                val weightValue = weightViewModel.weightValue.value!!.weightValue
                when(it) {
                    "metric" -> {
                        msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.METRIC))
//                        masViewModel.insert(Mas(masValue, SpeedUnit.KMH))
//                        heightViewModel.insert(Height(heightValue, LengthUnit.CM))
//                        weightViewModel.insert(Weight(weightValue, WeightUnit.KG))
                    }
                    "imperial" -> {
                        msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.IMPERIAL))
//                        masViewModel.insert(Mas(masValue, SpeedUnit.MPH))
//                        heightViewModel.insert(Height(heightValue, LengthUnit.IN))
//                        weightViewModel.insert(Weight(weightValue, WeightUnit.LB))
                    }
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
            data?.getStringExtra(EXTRA_REPLY_STRING)?.let {
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
        data?.getStringExtra(EXTRA_REPLY_STRING)?.let {
            dobViewModel.insert(Dob(it))
        }
    }
    private val masStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        val data = result.data
        data?.getStringArrayExtra(EXTRA_REPLY_ARRAY)?.let {
            val masValue = it[0].toDouble()
            var masUnit: SpeedUnit = SpeedUnit.KMH
            when(it[1]) {
                "km/h" -> masUnit = SpeedUnit.KMH
                "mph" -> masUnit = SpeedUnit.MPH
            }
            masViewModel.insert(Mas(masValue, masUnit))
        }
    }
    private val heightStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        val data = result.data
        data?.getStringArrayExtra(EXTRA_REPLY_ARRAY)?.let {
            val heightValue = it[0].toInt()
            var heightUnit = LengthUnit.CM
            when(it[1].toString()) {
                "cm" -> heightUnit = LengthUnit.CM
                "in" -> heightUnit = LengthUnit.IN
            }
            heightViewModel.insert(Height(heightValue, heightUnit))
        }
    }
    private val weightStartForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        val data = result.data
        data?.getStringArrayExtra(EXTRA_REPLY_ARRAY)?.let {
            val weightValue = it[0].toDouble()
            var weightUnit: WeightUnit = WeightUnit.KG
            when(it[1].toString()) {
                "kg" -> weightUnit = WeightUnit.KG
                "lb" -> weightUnit = WeightUnit.LB
            }
            weightViewModel.insert(Weight(weightValue, weightUnit))
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
        msViewModel.msValue.observe(this, { ms ->
            ms?.let {
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
        genderViewModel.genderValue.observe(this, { gender ->
            gender?.let {
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
        dobViewModel.dobValue.observe(this, { dob ->
            dob?.let {
                mainBinding.tvDobValue.text = it.dob
            }
        })

        // Mas
        mainBinding.tvMasTitle.setOnClickListener {
            masStartForResult.launch(Intent(this, MasActivity::class.java))
        }
        masViewModel.masValue.observe(this, { mas ->
            mas?.let {
                var unitMas = ""
                when(it.masUnit.toString()) {
                    "KMH" -> unitMas = getString(R.string.kmh)
                    "MPH" -> unitMas = getString(R.string.mph)
                }
                val masComplete = "${it.masValue} $unitMas"
                mainBinding.tvMasValue.text = masComplete
            }
        })

        // Height
        mainBinding.tvHeightTitle.setOnClickListener {
            heightStartForResult.launch(Intent(this, HeightActivity::class.java))
        }
        heightViewModel.heightValue.observe(this, { height ->
            height?.let {
                var unitHeight = ""
                when(it.heightUnit.toString()) {
                    "CM" -> unitHeight = getString(R.string.cm)
                    "IN" -> unitHeight = getString(R.string.inch)
                }
                val heightComplete = "${it.heightValue} $unitHeight"
                mainBinding.tvHeightValue.text = heightComplete
            }
        })

        // Weight
        mainBinding.tvWeightTitle.setOnClickListener {
            weightStartForResult.launch(Intent(this, WeightActivity::class.java))
        }
        weightViewModel.weightValue.observe(this, { weight ->
            weight?.let {
                var unitWeight = ""
                when(it.weightUnit.toString()) {
                    "KG" -> unitWeight = getString(R.string.kg)
                    "LB" -> unitWeight = getString(R.string.lb)
                }
                val weightComplete = "${it.weightValue} $unitWeight"
                mainBinding.tvWeightValue.text = weightComplete
            }
        })
    }
}
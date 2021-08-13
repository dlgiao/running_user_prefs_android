package com.kmmania.runninguserpreferences.ui.user_prefs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.datepicker.MaterialDatePicker
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentUserPrefsBinding
import com.kmmania.runninguserpreferences.model.*
import com.kmmania.runninguserpreferences.model.units.GenderUnit
import com.kmmania.runninguserpreferences.model.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.ui.measuringsystem.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class UserPrefsFragment : Fragment() {
    private var _userPrefsBinding: FragmentUserPrefsBinding? = null
    private val userPrefsBinding get() = _userPrefsBinding!!

    // ViewModel
    private val msViewModel: MeasuringSystemViewModel by viewModels()
    private val genderViewModel: GenderViewModel by viewModels()
    private val dobViewModel: DobViewModel by viewModels()
    private val masViewModel: MasViewModel by viewModels()
    private val heightViewModel: HeightViewModel by viewModels()
    private val weightViewModel: WeightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _userPrefsBinding = FragmentUserPrefsBinding.inflate(inflater, container, false)
        val rootView = userPrefsBinding.root

        // Measuring system
        // The observer which updates the UI
        val msObserver = Observer<MeasuringSystem> { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> {
                        userPrefsBinding.rbMetric.isChecked = true
                        userPrefsBinding.tvUnitMas.text = getString(R.string.kmh)
                        userPrefsBinding.tvUnitHeight.text = getString(R.string.cm)
                        userPrefsBinding.tvUnitWeight.text = getString(R.string.kg)
                    }
                    "IMPERIAL" -> {
                        userPrefsBinding.rbImperial.isChecked = true
                        userPrefsBinding.tvUnitMas.text = getString(R.string.mph)
                        userPrefsBinding.tvUnitHeight.text = getString(R.string.inch)
                        userPrefsBinding.tvUnitWeight.text = getString(R.string.lb)
                    }
                }
            }
        }
        // Observe the LiveData
        msViewModel.msValue.observe(viewLifecycleOwner, msObserver)
        // insert MS data
        userPrefsBinding.rbMetric.setOnClickListener {
            msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.METRIC))
        }
        userPrefsBinding.rbImperial.setOnClickListener {
            msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.IMPERIAL))
        }

        // Gender
        // The observer which updates the UI
        val genderObserver = Observer<Gender> { gender ->
            gender?.let {
                when(it.gender.toString()) {
                    "MALE" -> userPrefsBinding.rbMale.isChecked = true
                    "FEMALE" -> userPrefsBinding.rbFemale.isChecked = true
                }
            }
        }
        // Observe the LiveData
        genderViewModel.genderValue.observe(viewLifecycleOwner, genderObserver)
        // Insert gender data
        userPrefsBinding.rbMale.setOnClickListener {
            genderViewModel.insert(Gender(GenderUnit.MALE))
        }
        userPrefsBinding.rbFemale.setOnClickListener {
            genderViewModel.insert(Gender(GenderUnit.FEMALE))
        }

        // DOB
        // The observer which updates the UI
        val dobObserver = Observer<Dob> { dob ->
            userPrefsBinding.tvDobValue.text = dob.dob.toString()
        }
        // Observe the LiveData
        dobViewModel.dobValue.observe(viewLifecycleOwner, dobObserver)

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(getString(R.string.select_date))
            .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
            .build()
        userPrefsBinding.btnSelectDate.setOnClickListener {
            //datePicker.show(supportFragmentManager, "SELECT_DATE")
        }
        datePicker.addOnPositiveButtonClickListener {
//            val dobValue = datePicker.selection
//            val dob = Dob(Date(dobValue))
//            dobViewModel.insert(dob)
        }

        // MAS
        val masObserver = Observer<Mas> { mas ->
            mas?.let {
                userPrefsBinding.etMasValue.editText?.setText(it.masValue.toString())
            }
        }
        masViewModel.masValue.observe(viewLifecycleOwner, masObserver)

        // Height
        val heightObserver = Observer<Height> { height ->
            height?.let {
                userPrefsBinding.etHeightValue.editText?.setText(it.heightValue.toString())
            }
        }
        heightViewModel.heightValue.observe(viewLifecycleOwner, heightObserver)

        // Weight
        val weightObserver = Observer<Weight> { weight ->
            weight?.let {
                userPrefsBinding.etWeightValue.editText?.setText(it.weightValue.toString())
            }
        }
        weightViewModel.weightValue.observe(viewLifecycleOwner, weightObserver)



        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _userPrefsBinding = null
    }
}
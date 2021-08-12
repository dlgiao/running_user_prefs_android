package com.kmmania.runninguserpreferences.ui.user_prefs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kmmania.runninguserpreferences.databinding.FragmentUserPrefsBinding
import com.kmmania.runninguserpreferences.model.Gender
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.model.units.GenderUnit
import com.kmmania.runninguserpreferences.model.units.MeasuringSystemUnit
import com.kmmania.runninguserpreferences.ui.measuringsystem.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.GenderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserPrefsFragment : Fragment() {
    private var _userPrefsBinding: FragmentUserPrefsBinding? = null
    private val userPrefsBinding get() = _userPrefsBinding!!

    // ViewModel
    private val msViewModel: MeasuringSystemViewModel by viewModels()
    private val genderViewModel: GenderViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _userPrefsBinding = FragmentUserPrefsBinding.inflate(inflater, container, false)
        val rootView = userPrefsBinding.root

        // Measuring system
        // The observer which updates the UI
        val msObserver = Observer<MeasuringSystem> { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> userPrefsBinding.rbMetric.isChecked = true
                    "IMPERIAL" -> userPrefsBinding.rbImperial.isChecked = true
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

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _userPrefsBinding = null
    }
}
package com.kmmania.runninguserpreferences.ui.user_prefs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.datepicker.MaterialDatePicker
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentUserPrefsBinding
import com.kmmania.runninguserpreferences.model.*
import com.kmmania.runninguserpreferences.model.units.*
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class UserPrefsFragment : Fragment() {
    private var _userPrefsBinding: FragmentUserPrefsBinding? = null
    private val userPrefsBinding get() = _userPrefsBinding!!

    // ViewModel
    private val userPrefsViewModel: UserPrefsViewModel by viewModels()

//    private val msViewModel: MeasuringSystemViewModel by viewModels()
//    private val genderViewModel: GenderViewModel by viewModels()
//    private val dobViewModel: DobViewModel by viewModels()
//    private val masViewModel: MasViewModel by viewModels()
//    private val heightViewModel: HeightViewModel by viewModels()
//    private val weightViewModel: WeightViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _userPrefsBinding = FragmentUserPrefsBinding.inflate(inflater, container, false)
        val rootView = userPrefsBinding.root

        val userPrefsObserver = Observer<UserPrefs> { userPrefs ->
            userPrefs?.let {
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

                when(it.gender.toString()) {
                    "MALE" -> userPrefsBinding.rbMale.isChecked = true
                    "FEMALE" -> userPrefsBinding.rbFemale.isChecked = true
                }

                userPrefsBinding.tvDobValue.text = it.dob.toString()
                userPrefsBinding.tiMasValue.editText?.setText(it.masValue.toString())
                userPrefsBinding.tiHeightValue.editText?.setText(it.heightValue.toString())
                userPrefsBinding.tiWeightValue.editText?.setText(it.weightValue.toString())
            }
        }
        userPrefsViewModel.userPrefsValue.observe(viewLifecycleOwner, userPrefsObserver)

        // Measuring system
        // The observer which updates the UI
//        val msObserver = Observer<MeasuringSystem> { ms ->
//            ms?.let {
//                when(it.measuringSystem.toString()) {
//                    "METRIC" -> {
//                        userPrefsBinding.rbMetric.isChecked = true
//                        userPrefsBinding.tvUnitMas.text = getString(R.string.kmh)
//                        userPrefsBinding.tvUnitHeight.text = getString(R.string.cm)
//                        userPrefsBinding.tvUnitWeight.text = getString(R.string.kg)
//                    }
//                    "IMPERIAL" -> {
//                        userPrefsBinding.rbImperial.isChecked = true
//                        userPrefsBinding.tvUnitMas.text = getString(R.string.mph)
//                        userPrefsBinding.tvUnitHeight.text = getString(R.string.inch)
//                        userPrefsBinding.tvUnitWeight.text = getString(R.string.lb)
//                    }
//                }
//            }
//        }
//        // Observe the LiveData
//        msViewModel.msValue.observe(viewLifecycleOwner, msObserver)
        // insert MS data
        userPrefsBinding.rbMetric.setOnClickListener {
            //msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.METRIC))
            userPrefsViewModel.insert(UserPrefs(
                MeasuringSystemUnit.METRIC,
                getGender(),
                null,
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }
        userPrefsBinding.rbImperial.setOnClickListener {
            //msViewModel.insert(MeasuringSystem(MeasuringSystemUnit.IMPERIAL))
            userPrefsViewModel.insert(UserPrefs(
                MeasuringSystemUnit.IMPERIAL,
                getGender(),
                null,
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }

        // Gender
        // The observer which updates the UI
//        val genderObserver = Observer<Gender> { gender ->
//            gender?.let {
//                when(it.gender.toString()) {
//                    "MALE" -> userPrefsBinding.rbMale.isChecked = true
//                    "FEMALE" -> userPrefsBinding.rbFemale.isChecked = true
//                }
//            }
//        }
//        // Observe the LiveData
//        genderViewModel.genderValue.observe(viewLifecycleOwner, genderObserver)
        // Insert gender data
        userPrefsBinding.rbMale.setOnClickListener {
            //genderViewModel.insert(Gender(GenderUnit.MALE))
            userPrefsViewModel.insert(UserPrefs(
                getMS(),
                GenderUnit.MALE,
                null,
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }
        userPrefsBinding.rbFemale.setOnClickListener {
            //genderViewModel.insert(Gender(GenderUnit.FEMALE))
            userPrefsViewModel.insert(UserPrefs(
                getMS(),
                GenderUnit.FEMALE,
                null,
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }

        // DOB
        // The observer which updates the UI
//        val dobObserver = Observer<Dob> { dob ->
//            dob?.let {
//                userPrefsBinding.tvDobValue.text = it.dob.toString()
//            }
//        }
//        // Observe the LiveData
//        dobViewModel.dobValue.observe(viewLifecycleOwner, dobObserver)

        val dobPicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(getString(R.string.dob))
            .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
            .build()
        userPrefsBinding.btnSelectDate.setOnClickListener {
            dobPicker.show(childFragmentManager, "DOB")
        }
        dobPicker.addOnPositiveButtonClickListener {
            //val dobValue = Date(dobPicker.selection!!)
            //dobViewModel.insert(Dob(dobValue))
            userPrefsViewModel.insert(UserPrefs(
                getMS(),
                getGender(),
                Date(dobPicker.selection!!),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }

        // MAS
//        val masObserver = Observer<Mas> { mas ->
//            mas?.let {
//                userPrefsBinding.tiMasValue.editText?.setText(it.masValue.toString())
//            }
//        }
//        masViewModel.masValue.observe(viewLifecycleOwner, masObserver)

        userPrefsBinding.etMasValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
//                val mas = userPrefsBinding.tiMasValue.editText?.text.toString().toDouble()
//                var unitMas = SpeedUnit.KMH
//                when(userPrefsBinding.tvUnitMas.text.toString()) {
//                    "km/h" -> unitMas = SpeedUnit.KMH
//                    "mph" -> unitMas =SpeedUnit.MPH
//                }
//                masViewModel.insert(Mas(mas, unitMas))
                userPrefsViewModel.insert(UserPrefs(
                    getMS(),
                    getGender(),
                    null,
                    getMasValue(), getMasUnit(),
                    getHeightValue(), getHeightUnit(),
                    getWeightValue(), getWeightUnit()
                ))
            }
        }

        // Height
//        val heightObserver = Observer<Height> { height ->
//            height?.let {
//                userPrefsBinding.tiHeightValue.editText?.setText(it.heightValue.toString())
//            }
//        }
//        heightViewModel.heightValue.observe(viewLifecycleOwner, heightObserver)

        userPrefsBinding.etHeightValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
//                val height = userPrefsBinding.tiHeightValue.editText?.text.toString().toInt()
//                var unitHeight = LengthUnit.CM
//                when(userPrefsBinding.tvUnitHeight.text.toString()) {
//                    "cm" -> unitHeight = LengthUnit.CM
//                    "in" -> unitHeight = LengthUnit.IN
//                }
//                heightViewModel.insert((Height(height, unitHeight)))
                userPrefsViewModel.insert(UserPrefs(
                    getMS(),
                    getGender(),
                    null,
                    getMasValue(), getMasUnit(),
                    getHeightValue(), getHeightUnit(),
                    getWeightValue(), getWeightUnit()
                ))
            }
        }

        // Weight
//        val weightObserver = Observer<Weight> { weight ->
//            weight?.let {
//                userPrefsBinding.tiWeightValue.editText?.setText(it.weightValue.toString())
//            }
//        }
//        weightViewModel.weightValue.observe(viewLifecycleOwner, weightObserver)

        userPrefsBinding.etWeightValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
//                val weight = userPrefsBinding.tiWeightValue.editText?.text.toString().toDouble()
//                var unitWeight = WeightUnit.KG
//                when(userPrefsBinding.tvUnitWeight.text.toString()) {
//                    "kg" -> unitWeight = WeightUnit.KG
//                    "lb" -> unitWeight = WeightUnit.LB
//                }
//                weightViewModel.insert(Weight(weight, unitWeight))
                userPrefsViewModel.insert(UserPrefs(
                    getMS(),
                    getGender(),
                    null,
                    getMasValue(), getMasUnit(),
                    getHeightValue(), getHeightUnit(),
                    getWeightValue(), getWeightUnit()
                ))
            }
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _userPrefsBinding = null
    }

    private fun getMS(): MeasuringSystemUnit {
        var ms = MeasuringSystemUnit.METRIC
        if (userPrefsBinding.rbMetric.isChecked) {
            ms = MeasuringSystemUnit.METRIC
        } else if (userPrefsBinding.rbImperial.isChecked) {
            ms = MeasuringSystemUnit.IMPERIAL
        }

        return ms
    }

    private fun getGender(): GenderUnit {
        var gender = GenderUnit.MALE
        if (userPrefsBinding.rbMale.isChecked) {
            gender = GenderUnit.MALE
        } else if (userPrefsBinding.rbFemale.isChecked) {
            gender = GenderUnit.FEMALE
        }

        return gender
    }

    private fun getDob(): Date {
        return Date(userPrefsBinding.tvDobValue.text.toString().toLong())
    }

    private fun getMasValue(): Double {
        return userPrefsBinding.tiMasValue.editText?.text.toString().toDouble()
    }

    private fun getMasUnit(): SpeedUnit {
        var masUnit = SpeedUnit.KMH
        when(userPrefsBinding.tvUnitMas.text.toString()) {
            "km/h" -> masUnit = SpeedUnit.KMH
            "mph" -> masUnit = SpeedUnit.MPH
        }

        return masUnit
    }

    private fun getHeightValue(): Int {
        return userPrefsBinding.tiHeightValue.editText?.text.toString().toInt()
    }

    private fun getHeightUnit(): LengthUnit {
        var heightUnit = LengthUnit.CM
        when(userPrefsBinding.tvUnitHeight.text.toString()) {
            "CM" -> heightUnit = LengthUnit.CM
            "IN" -> heightUnit = LengthUnit.IN
        }

        return heightUnit
    }

    private fun getWeightValue(): Double {
        return userPrefsBinding.tiWeightValue.editText?.text.toString().toDouble()
    }

    private fun getWeightUnit(): WeightUnit {
        var weightUnit = WeightUnit.KG
        when(userPrefsBinding.tvUnitWeight.text.toString()) {
            "KG" -> weightUnit = WeightUnit.KG
            "LB" -> weightUnit = WeightUnit.LB
        }

        return weightUnit
    }
}
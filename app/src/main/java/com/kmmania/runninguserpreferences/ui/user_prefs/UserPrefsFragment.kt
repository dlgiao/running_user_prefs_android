package com.kmmania.runninguserpreferences.ui.user_prefs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentUserPrefsBinding
import com.kmmania.runninguserpreferences.model.*
import com.kmmania.runninguserpreferences.model.units.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserPrefsFragment : Fragment() {
    private var _userPrefsBinding: FragmentUserPrefsBinding? = null
    private val userPrefsBinding get() = _userPrefsBinding!!
    private val userPrefsViewModel: UserPrefsViewModel by viewModels()

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

                userPrefsBinding.tiAgeValue.editText?.setText(it.age.toString())
                userPrefsBinding.tiMasValue.editText?.setText(it.masValue.toString())
                userPrefsBinding.tiHeightValue.editText?.setText(it.heightValue.toString())
                userPrefsBinding.tiWeightValue.editText?.setText(it.weightValue.toString())
            }
        }
        userPrefsViewModel.userPrefsValue.observe(viewLifecycleOwner, userPrefsObserver)

        userPrefsBinding.rbMetric.setOnClickListener {
            userPrefsViewModel.insert(UserPrefs(
                MeasuringSystemUnit.METRIC,
                getGender(),
                getAge(),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }
        userPrefsBinding.rbImperial.setOnClickListener {
            userPrefsViewModel.insert(UserPrefs(
                MeasuringSystemUnit.IMPERIAL,
                getGender(),
                getAge(),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }

        userPrefsBinding.rbMale.setOnClickListener {
            userPrefsViewModel.insert(UserPrefs(
                getMS(),
                GenderUnit.MALE,
                getAge(),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }
        userPrefsBinding.rbFemale.setOnClickListener {
            userPrefsViewModel.insert(UserPrefs(
                getMS(),
                GenderUnit.FEMALE,
                getAge(),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }

        userPrefsBinding.etAgeValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            hasFocus((hasFocus))
        }

        userPrefsBinding.etMasValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            hasFocus((hasFocus))
        }

        userPrefsBinding.etHeightValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            hasFocus((hasFocus))
        }

        userPrefsBinding.etWeightValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            hasFocus((hasFocus))
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

    private fun getAge(): Int {
        return userPrefsBinding.tiAgeValue.editText?.text.toString().toInt()
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

    private fun hasFocus(hasFocus: Boolean) {
        if (!hasFocus) {
            userPrefsViewModel.insert(UserPrefs(
                getMS(),
                getGender(),
                getAge(),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            ))
        }
    }
}
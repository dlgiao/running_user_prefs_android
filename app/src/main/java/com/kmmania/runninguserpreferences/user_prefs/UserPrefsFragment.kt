package com.kmmania.runninguserpreferences.user_prefs

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
import com.kmmania.runninguserpreferences.utils.units.*
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
    ): View {

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
            insert1(MeasuringSystemUnit.METRIC, getGender())
        }
        userPrefsBinding.rbImperial.setOnClickListener {
            insert1(MeasuringSystemUnit.IMPERIAL, getGender())
        }

        userPrefsBinding.rbMale.setOnClickListener {
            insert1(getMS(), GenderUnit.MALE)
        }
        userPrefsBinding.rbFemale.setOnClickListener {
            insert1(getMS(), GenderUnit.FEMALE)
        }

        userPrefsBinding.etAgeValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            insert2(hasFocus)
        }

        userPrefsBinding.etMasValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            insert2(hasFocus)
        }

        userPrefsBinding.etHeightValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            insert2(hasFocus)
        }

        userPrefsBinding.etWeightValue.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            insert2(hasFocus)
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _userPrefsBinding = null
    }

    private fun insert1(ms: MeasuringSystemUnit, gender: GenderUnit) {
        userPrefsViewModel.insert(
            UserPrefs(
                ms,
                gender,
                getAge(),
                getMasValue(), getMasUnit(),
                getHeightValue(), getHeightUnit(),
                getWeightValue(), getWeightUnit()
            )
        )
    }

    private fun getMS(): MeasuringSystemUnit {
        return if (userPrefsBinding.rbMetric.isChecked) {
            MeasuringSystemUnit.METRIC
        } else {
            MeasuringSystemUnit.IMPERIAL
        }
    }

    private fun getGender(): GenderUnit {
        return if (userPrefsBinding.rbMale.isChecked) {
            GenderUnit.MALE
        } else {
            GenderUnit.FEMALE
        }
    }

    // TODO: Null exception
    private fun getAge(): Int {
        return userPrefsBinding.tiAgeValue.editText?.text.toString().toInt()
    }

    // TODO: Null exception
    private fun getMasValue(): Double {
        return userPrefsBinding.tiMasValue.editText?.text.toString().toDouble()
    }

    private fun getMasUnit(): SpeedUnit {
        return when(userPrefsBinding.tvUnitMas.text.toString()) {
            "km/h" -> SpeedUnit.KMH
            "mph" -> SpeedUnit.MPH
            else -> SpeedUnit.KMH
        }
    }

    // TODO: Null exception
    private fun getHeightValue(): Int {
        return userPrefsBinding.tiHeightValue.editText?.text.toString().toInt()
    }

    private fun getHeightUnit(): LengthUnit {
        return when(userPrefsBinding.tvUnitHeight.text.toString()) {
            "CM" -> LengthUnit.CM
            "IN" -> LengthUnit.IN
            else -> LengthUnit.CM
        }
    }

    // TODO: Null exception
    private fun getWeightValue(): Double {
        return userPrefsBinding.tiWeightValue.editText?.text.toString().toDouble()
    }

    private fun getWeightUnit(): WeightUnit {
        return when(userPrefsBinding.tvUnitWeight.text.toString()) {
            "KG" -> WeightUnit.KG
            "LB" -> WeightUnit.LB
            else -> WeightUnit.KG
        }
    }

    private fun insert2(hasFocus: Boolean) {
        if (!hasFocus) {
            userPrefsViewModel.insert(
                    UserPrefs(
                    getMS(),
                    getGender(),
                    getAge(),
                    getMasValue(), getMasUnit(),
                    getHeightValue(), getHeightUnit(),
                    getWeightValue(), getWeightUnit()
                )
            )
        }
    }
}
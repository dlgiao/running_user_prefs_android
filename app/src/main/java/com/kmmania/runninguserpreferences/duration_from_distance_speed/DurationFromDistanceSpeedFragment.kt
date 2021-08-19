package com.kmmania.runninguserpreferences.duration_from_distance_speed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentDurationFromDistanceSpeedBinding
import com.kmmania.runninguserpreferences.user_prefs.UserPrefs
import com.kmmania.runninguserpreferences.user_prefs.UserPrefsViewModel
import androidx.lifecycle.Observer
import com.kmmania.runninguserpreferences.length.LengthViewModel
import com.kmmania.runninguserpreferences.speed.SpeedViewModel
import com.kmmania.runninguserpreferences.utils.units.LengthUnit
import com.kmmania.runninguserpreferences.utils.units.SpeedUnit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DurationFromDistanceSpeedFragment : Fragment() {
    private var _durationFromDistanceSpeedBinding: FragmentDurationFromDistanceSpeedBinding? =  null
    private val durationFromDistanceSpeedBinding get() = _durationFromDistanceSpeedBinding!!

    private val userPrefsViewModel: UserPrefsViewModel by viewModels()
    private val durationFromDistanceSpeedViewModel: DurationFromDistanceSpeedViewModel by viewModels()
    private val lengthViewModel: LengthViewModel by viewModels()
    private val speedViewModel: SpeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _durationFromDistanceSpeedBinding = FragmentDurationFromDistanceSpeedBinding
            .inflate(inflater, container, false)
        val rootView = durationFromDistanceSpeedBinding.root

        var distanceValue: Double? = 0.0
        var distanceUnit: LengthUnit = LengthUnit.KM
        var speedValue: Double? = 0.0
        var speedUnit: SpeedUnit = SpeedUnit.KMH

        val userPrefsObserver = Observer<UserPrefs> { userPrefs ->
            userPrefs?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> {
                        durationFromDistanceSpeedBinding.tvUnitDistance.text = getString(R.string.km)
                        durationFromDistanceSpeedBinding.tvUnitSpeed.text = getString(R.string.kmh)
                        distanceUnit = LengthUnit.KM
                        speedUnit = SpeedUnit.KMH
                    }
                    "IMPERIAL" -> {
                        durationFromDistanceSpeedBinding.tvUnitDistance.text = getString(R.string.mi)
                        durationFromDistanceSpeedBinding.tvUnitSpeed.text = getString(R.string.mph)
                        distanceUnit = LengthUnit.MI
                        speedUnit = SpeedUnit.MPH
                    }
                }
            }
        }
        userPrefsViewModel.userPrefsValue.observe(viewLifecycleOwner, userPrefsObserver)

        durationFromDistanceSpeedBinding.etDistanceValue.onFocusChangeListener =
            OnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    distanceValue = durationFromDistanceSpeedBinding
                        .tiDistanceValue
                        .editText
                        ?.text
                        .toString()
                        .toDouble()
                }
            }

        durationFromDistanceSpeedBinding.etSpeedValue.onFocusChangeListener =
            OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                speedValue = durationFromDistanceSpeedBinding
                    .tiSpeedValue
                    .editText
                    ?.text
                    .toString()
                    .toDouble()
            }
        }

        val distance = lengthViewModel.getLength(distanceValue, distanceUnit)
        val speed = speedViewModel.getSpeed(speedValue, speedUnit)
        val time2run = durationFromDistanceSpeedViewModel.getDurationFromDistanceSpeed(distance, speed)

        val hr = time2run.hr.toString()
        val min = time2run.min.toString()
        val sec = time2run.sec.toString()
        val ms = time2run.ms.toString()
        val time2runValue = "{$hr}:{$min}:{$sec}:{$ms}"

        durationFromDistanceSpeedBinding.tvDurationValue.text = time2runValue

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _durationFromDistanceSpeedBinding = null
    }
}
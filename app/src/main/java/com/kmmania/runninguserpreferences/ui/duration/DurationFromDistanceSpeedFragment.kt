package com.kmmania.runninguserpreferences.ui.duration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentDurationFromDistanceSpeedBinding
import com.kmmania.runninguserpreferences.model.UserPrefs
import com.kmmania.runninguserpreferences.ui.user_prefs.UserPrefsViewModel
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DurationFromDistanceSpeedFragment : Fragment() {
    private var _durationFromDistanceSpeedBinding: FragmentDurationFromDistanceSpeedBinding? =  null
    private val durationFromDistanceSpeedBinding get() = _durationFromDistanceSpeedBinding!!

    private val userPrefsViewModel: UserPrefsViewModel by viewModels()
    private val durationFromDistanceSpeedViewModel: DurationFromDistanceSpeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _durationFromDistanceSpeedBinding = FragmentDurationFromDistanceSpeedBinding
            .inflate(inflater, container, false)
        val rootView = durationFromDistanceSpeedBinding.root

        val userPrefsObserver = Observer<UserPrefs> { userPrefs ->
            userPrefs?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> {
                        durationFromDistanceSpeedBinding.tvUnitDistance.text =
                            getString(R.string.km)
                        durationFromDistanceSpeedBinding.tvUnitSpeed.text = getString(R.string.kmh)
                    }
                    "IMPERIAL" -> {
                        durationFromDistanceSpeedBinding.tvUnitDistance.text = getString(R.string.mi)
                        durationFromDistanceSpeedBinding.tvUnitSpeed.text = getString(R.string.mph)
                    }
                }
            }
        }
        userPrefsViewModel.userPrefsValue.observe(viewLifecycleOwner, userPrefsObserver)

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _durationFromDistanceSpeedBinding = null
    }
}
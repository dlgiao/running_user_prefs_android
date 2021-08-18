package com.kmmania.runninguserpreferences.ui.duration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentDurationFromDistanceSpeedBinding

class DurationFromDistanceSpeedFragment : Fragment() {
    private var _durationFromDistanceSpeedBinding: FragmentDurationFromDistanceSpeedBinding? =  null
    private val durationFromDistanceSpeedBinding get() = _durationFromDistanceSpeedBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _durationFromDistanceSpeedBinding = FragmentDurationFromDistanceSpeedBinding
            .inflate(inflater, container, false)
        val rootView = durationFromDistanceSpeedBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _durationFromDistanceSpeedBinding = null
    }
}
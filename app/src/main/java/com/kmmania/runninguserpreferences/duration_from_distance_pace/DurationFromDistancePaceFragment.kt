package com.kmmania.runninguserpreferences.duration_from_distance_pace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentDurationFromDistancePaceBinding

class DurationFromDistancePaceFragment : Fragment() {
    private var _durationFromDistancePaceBinding: FragmentDurationFromDistancePaceBinding? = null
    private val durationFromDistancePaceBinding get() = _durationFromDistancePaceBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _durationFromDistancePaceBinding = FragmentDurationFromDistancePaceBinding
            .inflate(inflater, container, false)
        val rootView = durationFromDistancePaceBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _durationFromDistancePaceBinding = null
    }
}
package com.kmmania.runninguserpreferences.ui.duration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentDurationBinding

class DurationFragment : Fragment() {
    private var _durationBinding: FragmentDurationBinding? = null
    private val durationBinding get() = _durationBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _durationBinding = FragmentDurationBinding.inflate(inflater, container, false)
        val rootView = durationBinding.root

        durationBinding.tvDurationFromDistanceMas.setOnClickListener {
            findNavController().navigate(R.id.action_durationFragment_to_durationFromDistanceMasFragment)
        }

        durationBinding.tvDurationFromDistanceSpeed.setOnClickListener {
            findNavController().navigate(R.id.action_durationFragment_to_durationFromDistanceSpeedFragment)
        }

        durationBinding.tvDurationFromDistancePace.setOnClickListener {
            findNavController().navigate(R.id.action_durationFragment_to_durationFromDistancePaceFragment)
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _durationBinding = null
    }
}
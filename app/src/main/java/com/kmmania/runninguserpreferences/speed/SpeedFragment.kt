package com.kmmania.runninguserpreferences.speed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentSpeedBinding

class SpeedFragment : Fragment() {
    private var _speedFragmentBinding: FragmentSpeedBinding? = null
    private val speedFragmentBinding get() = _speedFragmentBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _speedFragmentBinding = FragmentSpeedBinding.inflate(inflater, container, false)
        val rootView = speedFragmentBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _speedFragmentBinding = null
    }
}
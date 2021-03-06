package com.kmmania.runninguserpreferences.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _homeBinding: FragmentHomeBinding? = null
    private val homeBinding get() = _homeBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = homeBinding.root

        homeBinding.tvDuration.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_durationFragment)
        }
        homeBinding.tvDistance.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_lengthFragment)
        }
        homeBinding.tvSpeed.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_speedFragment)
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _homeBinding = null
    }
}
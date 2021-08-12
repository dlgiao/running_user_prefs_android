package com.kmmania.runninguserpreferences.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _homeBinding = null
    }
}
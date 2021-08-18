package com.kmmania.runninguserpreferences.ui.duration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentDurationFromDistanceMasBinding

class DurationFromDistanceMasFragment : Fragment() {
    private var _durationFromDistanceMasBinding: FragmentDurationFromDistanceMasBinding? = null
    private val durationFromDistanceMasBinding get() = _durationFromDistanceMasBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _durationFromDistanceMasBinding = FragmentDurationFromDistanceMasBinding.inflate(inflater, container, false)
        val rootView = durationFromDistanceMasBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _durationFromDistanceMasBinding = null
    }
}
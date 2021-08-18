package com.kmmania.runninguserpreferences.ui.duration

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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_duration_from_distance_pace, container, false)
    }
}
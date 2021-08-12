package com.kmmania.runninguserpreferences.ui.measuringsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.databinding.FragmentMSBinding

class MSFragment : Fragment() {
    private var _msBinding: FragmentMSBinding? = null
    private val msBinding get() = _msBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _msBinding = FragmentMSBinding.inflate(inflater, container, false)
        val rootView = msBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _msBinding = null
    }
}
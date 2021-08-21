package com.kmmania.runninguserpreferences.length

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentLengthBinding

class LengthFragment : Fragment() {
    private var _fragmentLengthBinding: FragmentLengthBinding? = null
    private val fragmentLengthBinding get() = _fragmentLengthBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentLengthBinding = FragmentLengthBinding.inflate(inflater, container, false)
        val rootView = fragmentLengthBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _fragmentLengthBinding = null
    }
}
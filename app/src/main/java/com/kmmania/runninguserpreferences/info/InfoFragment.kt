package com.kmmania.runninguserpreferences.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kmmania.runninguserpreferences.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
    private var _infoBinding: FragmentInfoBinding? = null
    private val infoBinding get() = _infoBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _infoBinding = FragmentInfoBinding.inflate(inflater, container, false)
        val rootView = infoBinding.root

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _infoBinding = null
    }
}
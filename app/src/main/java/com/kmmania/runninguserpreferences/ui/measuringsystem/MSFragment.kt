package com.kmmania.runninguserpreferences.ui.measuringsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kmmania.runninguserpreferences.databinding.FragmentMSBinding
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MSFragment : Fragment() {
    private var _msBinding: FragmentMSBinding? = null
    private val msBinding get() = _msBinding!!
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _msBinding = FragmentMSBinding.inflate(inflater, container, false)
        val rootView = msBinding.root

        // The observer which updates the UI
        val msObserver = Observer<MeasuringSystem> { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> msBinding.rbMetric.isChecked = true
                    "IMPERIAL" -> msBinding.rbImperial.isChecked = true
                }
            }
        }
        // Observe the LiveData
        msViewModel.msValue.observe(viewLifecycleOwner, msObserver)

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _msBinding = null
    }
}
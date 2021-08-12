package com.kmmania.runninguserpreferences.ui.user_prefs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.FragmentUserPrefsBinding
import com.kmmania.runninguserpreferences.model.MeasuringSystem
import com.kmmania.runninguserpreferences.ui.measuringsystem.MeasuringSystemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserPrefsFragment : Fragment() {
    private var _userPrefsBinding: FragmentUserPrefsBinding? = null
    private val userPrefsBinding get() = _userPrefsBinding!!

    // ViewModel
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _userPrefsBinding = FragmentUserPrefsBinding.inflate(inflater, container, false)
        val rootView = userPrefsBinding.root

        // Measuring system
        userPrefsBinding.tvMsTitle.setOnClickListener {
            findNavController().navigate(R.id.action_nav_user_prefs_to_MSFragment)
        }
        // The observer which updates the UI
        val msObserver = Observer<MeasuringSystem> { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> userPrefsBinding.tvMsValue.text = getString(R.string.metric)
                    "IMPERIAL" -> userPrefsBinding.tvMsValue.text = getString(R.string.imperial)
                    else -> userPrefsBinding.tvMsValue.text = getString(R.string.unknown)
                }
            }
        }
        // Observe the LiveData
        msViewModel.msValue.observe(viewLifecycleOwner, msObserver)

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _userPrefsBinding = null
    }
}
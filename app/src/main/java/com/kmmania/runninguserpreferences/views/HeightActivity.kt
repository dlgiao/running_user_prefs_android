package com.kmmania.runninguserpreferences.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.ActivityHeightBinding
import com.kmmania.runninguserpreferences.viewmodels.HeightViewModel
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel

class HeightActivity : AppCompatActivity() {
    private lateinit var heightBinding: ActivityHeightBinding
    private val heightViewModel: HeightViewModel by viewModels()
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        heightBinding = ActivityHeightBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(heightBinding.root)

        msViewModel.msValue.observe(this, { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> heightBinding.tvUnitHeight.text = getString(R.string.cm)
                    "IMPERIAL" -> heightBinding.tvUnitHeight.text = getString(R.string.inch)
                }
            }
        })

        heightViewModel.heightValue.observe(this, { height ->
            height?.let {
                heightBinding.etHeightValue.editText?.setText(it.heightValue.toString())
            }
        })
    }
}
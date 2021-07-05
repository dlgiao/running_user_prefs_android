package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.ActivityWeightBinding
import com.kmmania.runninguserpreferences.viewmodels.MeasuringSystemViewModel
import com.kmmania.runninguserpreferences.viewmodels.WeightViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeightActivity : AppCompatActivity() {
    private lateinit var weightBinding: ActivityWeightBinding
    private val weightViewModel: WeightViewModel by viewModels()
    private val msViewModel: MeasuringSystemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weightBinding = ActivityWeightBinding.inflate(layoutInflater)
        setContentView(weightBinding.root)

        msViewModel.msValue.observe(this, { ms ->
            ms?.let {
                when(it.measuringSystem.toString()) {
                    "METRIC" -> weightBinding.tvUnitWeight.text = getString(R.string.kg)
                    "IMPERIAL" -> weightBinding.tvUnitWeight.text = getString(R.string.lb)
                }
            }
        })

        weightViewModel.weightValue.observe(this, { weight ->
            weight?.let {
                weightBinding.etWeightValue.editText?.setText(it.weightValue.toString())
            }
        })

        weightBinding.btnSaveWeight.setOnClickListener {
            val weightValue = weightBinding.etWeightValue.editText?.text.toString()
            val weightUnit = weightBinding.tvUnitWeight.text.toString()
            val weightArray = arrayOf(weightValue, weightUnit)
            replyIntentArray(weightArray)
        }
    }

    private fun replyIntentArray(value: Array<String>) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY1, value)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }

    // TODO: Create CONSTANTS file
    companion object {
        const val EXTRA_REPLY1 = "com.example.android.wordlistsql.REPLY1"
    }
}
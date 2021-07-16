package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.ActivityDobBinding
import com.kmmania.runninguserpreferences.utils.CONSTANTS.Companion.EXTRA_REPLY_LONG
import com.kmmania.runninguserpreferences.viewmodels.DobViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DobActivity : AppCompatActivity() {
    private lateinit var dobBinding: ActivityDobBinding
    private val dobViewModel: DobViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dobBinding = ActivityDobBinding.inflate(layoutInflater)
        setContentView(dobBinding.root)

        dobViewModel.dobValue.observe(this, { dob ->
            dobBinding.tvDobValue.text = dob.dob.toString()
        })

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(getString(R.string.select_date))
            .setInputMode(MaterialDatePicker.INPUT_MODE_TEXT)
            .build()

        dobBinding.btnSelectDate.setOnClickListener {
            datePicker.show(supportFragmentManager, "SELECT_DATE")
        }

        datePicker.addOnPositiveButtonClickListener {
//            val dobDate = datePicker.headerText
            val dobValue = datePicker.selection
            replyIntent(dobValue)
        }
    }

    private fun replyIntent(value: Long?) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY_LONG, value)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }
}
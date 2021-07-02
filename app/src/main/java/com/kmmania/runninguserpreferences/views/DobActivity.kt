package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import com.kmmania.runninguserpreferences.R
import com.kmmania.runninguserpreferences.databinding.ActivityDobBinding
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

        dobViewModel.dobValue.observe(this, { value ->
            //
        })

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(getString(R.string.select_date))
            .build()

        dobBinding.btnSelectDate.setOnClickListener {
            datePicker.show(supportFragmentManager, "SELECT_DATE")
        }
    }

    private fun replyIntent(value: String) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY, value)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }

    // TODO: Create CONSTANTS file
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
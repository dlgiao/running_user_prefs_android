package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.databinding.ActivityGenderBinding
import com.kmmania.runninguserpreferences.viewmodels.GenderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenderActivity : AppCompatActivity() {
    private val genderViewModel: GenderViewModel by viewModels()
    private lateinit var genderBinding: ActivityGenderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        genderBinding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(genderBinding.root)

        genderViewModel.genderValue.observe(this, { value ->
            value?.let {
                when(it.gender.toString()) {
                    "MALE" -> genderBinding.rbMale.isChecked = true
                    "FEMALE" -> genderBinding.rbFemale.isChecked = true
                }
            }
        })

        genderBinding.rbMale.setOnClickListener {
            replyIntent("male")
        }
        genderBinding.rbFemale.setOnClickListener {
            replyIntent("female")
        }
    }

    private fun replyIntent(genderValue: String) {
        val replyIntentValue = Intent()
        replyIntentValue.putExtra(EXTRA_REPLY, genderValue)
        setResult(Activity.RESULT_OK, replyIntentValue)

        finish()
    }

    // TODO: Create CONSTANTS file
    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
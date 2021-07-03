package com.kmmania.runninguserpreferences.views

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kmmania.runninguserpreferences.databinding.ActivityMasBinding
import com.kmmania.runninguserpreferences.viewmodels.MasViewModel

class MasActivity : AppCompatActivity() {
    private lateinit var masBinding: ActivityMasBinding
    private val masViewModel: MasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        masBinding = ActivityMasBinding.inflate(layoutInflater)
        setContentView(masBinding.root)


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
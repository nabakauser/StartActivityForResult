package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.startactivityforresult.databinding.ActivityFourthBinding

class FourthActivity : AppCompatActivity() {
    private var binding: ActivityFourthBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        sendResult()
    }

    private fun sendResult() {
        binding?.uiBtnFour?.setOnClickListener {
            val text = binding?.uiEditText?.text.toString()
            setResult(Activity.RESULT_OK, Intent(this,MainActivity::class.java).putExtra("FA_RESPONSE", text))
            finish()
        }
    }
}
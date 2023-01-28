package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.startactivityforresult.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private var binding: ActivitySecondBinding? = null
    private val resultContracts by lazy {
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ::getActivityResult
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        resultContracts
        setUpListeners()
    }

    private fun getActivityResult(activityResult: ActivityResult?) {
        if(activityResult?.resultCode == RESULT_OK ) {
            binding?.uiBtnTwo?.setOnClickListener {
                val text = activityResult.data?.getStringExtra("TA_RESPONSE")
                setResult(Activity.RESULT_OK, Intent().putExtra("SA_RESPONSE", text))
                finish()
            }
        }
    }

    private fun setUpListeners() {
        binding?.uiBtnTwo?.setOnClickListener {
            navigateToThirdActivity()
        }
    }

    private fun navigateToThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        resultContracts.launch(intent)
    }
}
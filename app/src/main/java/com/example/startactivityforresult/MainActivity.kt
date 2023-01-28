package com.example.startactivityforresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.startactivityforresult.databinding.ActivityMainBinding
import androidx.activity.result.ActivityResult

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val resultContracts by lazy {
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ::getActivityResult
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        resultContracts  //must initialize contracts here -> else you'll compile time error
        setUpListeners()
    }

    private fun getActivityResult(activityResult: ActivityResult?) {
        if(activityResult?.resultCode == RESULT_OK ) {
            binding?.uiTvDisplayText?.text = activityResult.data?.getStringExtra("SA_RESPONSE")
        }
    }

    private fun setUpListeners() {
        binding?.uiBtnOne?.setOnClickListener {
            navigateToSecondActivity()
        }
    }

    private fun navigateToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        resultContracts.launch(intent)
    }

}
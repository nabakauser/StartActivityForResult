package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.startactivityforresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private var binding: ActivityThirdBinding? = null
    private val resultContracts by lazy {
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ::getActivityResult
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        resultContracts
        setUpListeners()
    }

    private fun getActivityResult(activityResult: ActivityResult?) {
        if(activityResult?.resultCode == RESULT_OK ) {
            binding?.uiBtnThree?.setOnClickListener {
                val text = activityResult.data?.getStringExtra("FA_RESPONSE")
                setResult(Activity.RESULT_OK, Intent().putExtra("TA_RESPONSE", text))
                finish()
            }
        }
    }

    private fun setUpListeners() {
        binding?.uiBtnThree?.setOnClickListener {
            navigateToFourthActivity()
        }
    }

    private fun navigateToFourthActivity() {
        val intent = Intent(this, FourthActivity::class.java)
        resultContracts.launch(intent)
    }
}
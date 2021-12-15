package com.example.kotlin1_homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin1_homework1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var textSec: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etSecAct.setText(intent.getStringExtra("text").toString())

        binding.btnSecAct.setOnClickListener {
            textSec = binding.etSecAct.text.toString().trim()
            if (textSec.isEmpty()) {
                Toast.makeText(this, getString(R.string.et_empty), Toast.LENGTH_SHORT).show()
            } else {
                returnToMainActivity(textSec)
            }
        }
    }

    private fun returnToMainActivity(text: String) {
        val intent = Intent()
        intent.putExtra("text2", text)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
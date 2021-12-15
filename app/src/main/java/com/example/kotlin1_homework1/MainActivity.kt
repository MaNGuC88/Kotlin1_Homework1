package com.example.kotlin1_homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlin1_homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var textMain: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainAct.setOnClickListener {
            textMain = binding.etMainAct.text.toString().trim()
            if (textMain.isEmpty()) {
                Toast.makeText(this, getString(R.string.et_empty), Toast.LENGTH_SHORT).show()
            } else {
                openSecondActivity(textMain)
            }
        }
    }

    private fun openSecondActivity(text: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("text", text)
        resultLauncher.launch(intent)
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.etMainAct.setText(result.data?.getStringExtra("text2").toString())
            }
        }
}
package com.example.umc_week5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_week5_2.databinding.ActivityMainBinding
import com.example.umc_week5_2.databinding.ActivityMemoBinding

class MemoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title", viewBinding.etTitle.text.toString())
            intent.putExtra("content", viewBinding.etContent.text.toString())
            startActivity(intent)
        }

    }
}
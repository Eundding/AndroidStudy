package com.example.umc_week8

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_week8.databinding.ActivityMemoBinding

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
            setResult(RESULT_OK, intent)
            if (!isFinishing) finish()
        }
    }
}
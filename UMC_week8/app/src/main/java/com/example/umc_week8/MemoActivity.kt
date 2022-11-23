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
        val extras = intent.extras
        var idx = -1 // position 값 초기화
        var key = -1 // key값 초기화
        var star = extras!!["star"] as Boolean

        viewBinding.btnSave.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java).apply {
                putExtra("title", viewBinding.etTitle.text.toString())
                putExtra("content", viewBinding.etContent.text.toString())
                putExtra("idx", idx)
                putExtra("key", key)
                putExtra("star", star) //즐겨찾기 여부
            }
                setResult(RESULT_OK, intent)
            if (!isFinishing) finish()
        }
    }
}
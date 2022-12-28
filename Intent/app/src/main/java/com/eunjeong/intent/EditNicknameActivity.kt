package com.eunjeong.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.intent.databinding.ActivityEditNicknameBinding

class EditNicknameActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityEditNicknameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityEditNicknameBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

       viewBinding.okBtn.setOnClickListener {
           // 입력한 새 닉네임이 뭔지 변수로 저장
           val changedNickname = viewBinding.newNicknameEdt.text.toString()

           // 입력한 닉네임을 가지고 메인으로 복귀
           val resultIntent = Intent() // 입력 닉네임을 담아주기 위한 용도로만 사용하는 Intent
           resultIntent.putExtra("nickname", changedNickname)
           setResult(RESULT_OK, resultIntent)
           finish()
       }



    }
}
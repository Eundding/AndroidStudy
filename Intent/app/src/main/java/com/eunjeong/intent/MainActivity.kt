package com.eunjeong.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val REQ_FOR_NICKNAME = 1000
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 화면 간 이동 (OtherActivity)
        viewBinding.moveToOtherBtn.setOnClickListener {
            //다른 화면으로 이동
            //Intent(출발지, 도착지)
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent)
        }

        // 메세지 전달 (MessageActivity)
        viewBinding.messageMoveToOtherBtn.setOnClickListener {
            val myIntent = Intent(this, MessageActivity::class.java)
            //입력한 내용 변수에 저장
            val inputMessage = viewBinding.messageEdt.text.toString()
            // putExtra(데이터 이름표, 내용)
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)
        }

        // 1 닉네임 변경 Activity로 이동
        viewBinding.changeNicknameBtn.setOnClickListener {
            val myIntent = Intent(this, EditNicknameActivity::class.java)
            // 데이터를 가지러 가는 이동
            val REQ_FOR_NICKNAME = 1000
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }
    }
    // 3돌아와서 받은 결과를 화면에 반영하기
    //onCreate 이후에
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // 돌아온 이유가 닉네임을 받으러 다녀온 게 맞는지?
        if(requestCode == REQ_FOR_NICKNAME){
            //추가질문 : 확인을 눌러서 돌아온게 맞는가?
            if(resultCode == RESULT_OK){
                // 실제 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영
                val newNickname = data?.getStringExtra("nickname")
                viewBinding.nicknameTv.text = newNickname
            }
        }
    }
}
package com.eunjeong.loginlogic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.eunjeong.loginlogic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        
        viewBinding.BtnLogin.setOnClickListener { 
            if((viewBinding.ETid.text.toString() == "admin@test.com") && (viewBinding.ETpw.text.toString() == "qwer")){
                Toast.makeText(this, "관리자입니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
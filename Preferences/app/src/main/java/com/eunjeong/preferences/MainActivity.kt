package com.eunjeong.preferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.preferences.databinding.ActivityMainBinding
import com.eunjeong.preferences.utils.ContextUtil

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.autoLoginCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            // 지금 체큰된 상황을 그대로 => ContextUtil을 이용해 자동로그인 여부로 저장
            ContextUtil.setAutoLogin(this, isChecked) // 저장
        }
        //화면이 만들어지면 => 저장된 자동로그인 여부 값을 체크박스에 반영
        viewBinding.autoLoginCheckBox.isChecked = ContextUtil.getAutoLogin(this)

    }
}
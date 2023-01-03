package com.eunjeong.library_img

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ViewAnimator
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //프로필 크게 보는 액티비티로 이동
        profileImg.setOnClickListener {
            val mIntent = Intent(this, ViewProfileActivity::class.java)
            startActivity(mIntent)
        }

        // 인터넷에 있는 이미지(https://로 시작)를 이미지뷰에 대입
        Glide.with(this).load("https://yozm.wishket.com/media/news/906/image002.jpg").into(img1)



    }
}
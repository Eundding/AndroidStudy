package com.eunjeong.library_img

import android.Manifest
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.ViewAnimator
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
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

        // 전화 걸기 버튼 누름 => 권한확인 / 전화연결
        callBtn.setOnClickListener {
            //라이브러리 활용 -> 전화 권한 확인 -> 실제 전화 연결
            val permissionListener = object : PermissionListener{
                override fun onPermissionGranted() {
                    // 권한 승인 => 실제로 전화 연결 진행
                    val myUri = Uri.parse("tel:010-2222-3333")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)

                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                    //권한 거절 -> 토스트로, 권한 없어서 전화 연결 실패
                    Toast.makeText(this@MainActivity, "권한이 없어서 전화연결에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("설정에서 진행해주세요")
                .setPermissions(Manifest.permission.CALL_PHONE) // Manifest 자동완성은 android로
                .check()
        }


    }
}
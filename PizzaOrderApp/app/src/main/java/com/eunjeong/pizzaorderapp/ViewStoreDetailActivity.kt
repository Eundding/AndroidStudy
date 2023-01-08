package com.eunjeong.pizzaorderapp

import android.Manifest
import android.content.Intent
import android.icu.number.NumberRangeFormatter.with
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.eunjeong.pizzaorderapp.datas.Store
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import kotlinx.android.synthetic.main.pizza_store_list.*

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStoreData : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        callPhoneBtn.setOnClickListener {

            val permissionListener = object : PermissionListener{
                override fun onPermissionGranted() {
                    val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "전화연결권한없음", Toast.LENGTH_SHORT).show()
                }
            }

            //실제 권한 확인 요청
            TedPermission.create()
                .setPermissionListener(permissionListener)
                .setDeniedMessage("[설정]에서 전화 권한을 켜주세요")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()


        }

    }

    override fun setValues() {
        mStoreData = intent.getSerializableExtra("StoreData") as Store
        Glide.with(mContext).load(mStoreData.logoUrl).into(storeLogoImg)
        storePhoneNum.text = mStoreData.phoneNum
        storeNameTxt.text = mStoreData.name
    }


}
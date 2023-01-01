package com.eunjeong.landapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.landapp.databinding.ActivityMainBinding.inflate
import com.eunjeong.landapp.databinding.ActivityViewRoomDetailBinding
import com.eunjeong.landapp.datas.Room

class ViewRoomDetailActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityViewRoomDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityViewRoomDetailBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val roomData = intent.getSerializableExtra("room") as Room

        viewBinding.priceTxt.text = roomData.getFormattedPrice()
        viewBinding.addressTxt.text = roomData.address
        viewBinding.descriptionTxt.text = roomData.description
        viewBinding.floorTxt.text = roomData.getFormattedFloor()

        
    }
}
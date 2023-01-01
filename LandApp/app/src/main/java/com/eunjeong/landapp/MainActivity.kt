package com.eunjeong.landapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunjeong.landapp.adapters.RoomAdapter
import com.eunjeong.landapp.databinding.ActivityMainBinding
import com.eunjeong.landapp.datas.Room

class MainActivity : AppCompatActivity() {
    val mRoomList = ArrayList<Room>()
    lateinit var mAdapter : RoomAdapter

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        mRoomList.add( Room( 7500, "서울시 동대문구", 8, "동대문구의 8층 7500만원 방 입니다." ) )
        mRoomList.add( Room( 24500, "서울시 서대문구", 0,  "서대문구의 반지하 2억 4500만원 방 입니다." ) )
        mRoomList.add( Room( 8500, "서울시 동작구", 0, "서작구의 반지하 8500만원 방 입니다." ) )
        mRoomList.add( Room( 4500, "서울시 은평구", -2, "은평구의 지하 2층 4500만원 방 입니다." ) )
        mRoomList.add( Room( 182500, "서울시 중랑구", 5,  "중랑구의 5층 1억 18억 2500만원 방 입니다." ) )
        mRoomList.add( Room( 235000, "서울시 도봉구", 7,  "도봉구의 7층 1억 23억 5000만원 방 입니다." ) )
        mRoomList.add( Room( 24000, "서울시 강남구", 19,  "강남구의 19층 2억 4000만원 방 입니다." ) )
        mRoomList.add( Room( 3700, "서울시 서초구", -1, "서초구의 지하 1층 3700만원 방 입니다." ) )

        mAdapter = RoomAdapter(this, R.layout.room_list_item, mRoomList)
        viewBinding.roomListView.adapter = mAdapter


    }
}
package com.eunjeong.landapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.eunjeong.landapp.R
import com.eunjeong.landapp.datas.Room

class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<Room>): ArrayAdapter<Room>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }
        val row = tempRow!!

        val roomData = mList[position]
        val priceTxt = row.findViewById<TextView>(R.id.priceTextView)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTextView)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTextView)

        descriptionTxt.text = roomData.description
        addressAndFloorTxt.text = roomData.address


        return row
    }



    }
package com.eunjeong.listview.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.eunjeong.listview.datas.Student

class StudentAdapter(
    val mContext : Context,
    val resId: Int,
    val mList: ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList){ //어떤타입의 아이디어 받을지<아이디어>

}
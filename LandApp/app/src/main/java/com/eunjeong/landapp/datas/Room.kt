package com.eunjeong.landapp.datas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.SerializablePermission
import java.text.NumberFormat
import java.util.*

//가격 / 주소 / 층수 / 설명.
class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String ) : java.io.Serializable{

    fun getFormattedPrice(): String{
        if (this.price >= 10000){
            val uk = this.price / 10000
            val rest = this.price % 10000
            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}"
        }
        else{
            //원래 1억이 안됨
            return "${NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)}"
        }
    }

    fun getFormattedFloor() : String{
        if (this.floor >= 1){
            return "${this.floor}층"
        }
        else if (this.floor == 0){
            return "반지하"
        }
        else {
            return "지하 ${-this.floor}층"
        }
    }
}
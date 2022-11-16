package com.example.umc_week7

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.umc_week7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
//Context Switching (언제 일어날지 모름)
//        Thread() {
//            for(i in 0 until 1001){
//                Log.d("Thread1", "$i")
//            }
//        }.start()
//
//        Thread() {
//            for(i in 1000 downTo 0){ // 1000에서 0으로 내려감
//                Log.d("Thread2", "$i")
//            }
//        }.start()

//        var milk = 500
//        Thread() {
//            while(true){
//                if(milk > 0){
//                    milk--
//                }
//                else {
//                    Log.d("Thread1", "hungry")
//                }
//            }
//        }.start()
//        Thread() {
//            while(true){
//              milk++
//                Log.d("Thread2", "NewMilk")
//            }
//        }.start()
//------------------------------------------------------------------------------------------------------
        //Image 바뀌는 예제
//        val imageList: ArrayList<Int> = arrayListOf(
//            R.drawable.threadtest1,
//            R.drawable.threadtest2,
//            R.drawable.threadtest3,
//        )
//        var imgIdx = 0
//
//        val handler = Handler(mainLooper) //메인쓰레드에 돌고 있는 걸 사용
//
//        Thread(){
//            while(true){
//                if (imgIdx == imageList.size - 1){
//                    imgIdx=0
//                }
//                else {
//                    imgIdx++
//                }
//                //여기서 하기 힘드니까 Handler가 있는 thread(UI Thread)에서 해줘~
//                handler.post{
//                    viewBinding.ivImage.setImageResource(imageList[imgIdx])
//                }
//                Thread.sleep(2000)
//            }
//        }.start()
//------------------------------------------------------------------------------------------------------
        var total = 10 // 전체 시간 저장
        val handler = Handler(mainLooper)
        val soundPool = SoundPool.Builder().build()
        var soundId : Int = 0
        soundId = soundPool.load(this, R.raw.birdsound, 1)
        fun handleMessage(total: Int){ //화면에 시간 출력하는 Handler
            val minute = String.format("%02d", total / 60)
            val second = String.format("%02d", total % 60)
            viewBinding.tvTime.text = "$minute;$second"
        }
        var status : Boolean = true
        Thread(){
            while(status){
                Thread.sleep(1000)
                total -= 1
                val post = handler.post {
                    val minute = String.format("%02d", total / 60)
                    val second = String.format("%02d", total % 60)
                    viewBinding.tvTime.text = "$minute:$second"
                    if (minute == "00") {
                        if (second == "01"){
                            status = false
                        }
                        if (second == "00") {
                            soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f,)
                        }
                    }

                }
            }
        }.start()


    }
}


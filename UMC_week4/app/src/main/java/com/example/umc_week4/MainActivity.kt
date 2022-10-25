package com.example.umc_week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AlertDialog
import com.example.umc_week4.databinding.ActivityMainBinding
import android.view.View //추가함

var temp : String = "" // 저장하기 위한 전역변수
class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root) // onCreate?
        Toast.makeText(this, "", Toast.LENGTH_SHORT)

        viewBinding.btnNext.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("input", viewBinding.ET.text.toString())
            startActivity(intent)
        }
    }

    override fun onStop(){
        super.onStop()
        temp = viewBinding.ET.text.toString()
        viewBinding.ET.setText(null) // 값 초기화
    }


    override fun onRestart(){
        super.onRestart()
        val builder = AlertDialog.Builder(this) // AlertDialog.Builder 생성

        //Dialog의 View 인스턴스를 생성해서 xml 파일을 inflate
        val dialogView = layoutInflater.inflate(R.layout.dialog, null) //Dialog의 View 인스턴스를 생성해서 xml 파일을 inflate

        builder.setView(dialogView)
            .setPositiveButton("Yes") { dialogInterface, i ->
                viewBinding.ET.setText("$temp")
            }

            .setNegativeButton("No") {dialogInterface, i ->
                viewBinding.ET.setText("")
            }
            .show()
    }
}
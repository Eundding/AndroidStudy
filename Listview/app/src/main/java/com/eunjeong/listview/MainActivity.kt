package com.eunjeong.listview

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.eunjeong.listview.adapters.StudentAdapter
import com.eunjeong.listview.databinding.ActivityMainBinding
import com.eunjeong.listview.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter

    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        mStudentList.add( Student("은딩", 2000) )
        mStudentList.add( Student("은조", 2001) )
        mStudentList.add( Student("하이", 1999) )
        mStudentList.add( Student("승승", 1987) )
        mStudentList.add( Student("은혜", 1980) )
        mStudentList.add( Student("재석", 1970) )
        mStudentList.add( Student("석진", 2007) )
        mStudentList.add( Student("유진", 2002) )

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        viewBinding.studentListView.adapter = mAdapter


        viewBinding.studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = mStudentList[position]
            Toast.makeText(this, "${clickedStudent.name}이 클릭 됨", Toast.LENGTH_SHORT).show()
        }

        viewBinding.studentListView.setOnItemLongClickListener { parent, view, position, id ->
//            val longClickedStudent = mStudentList[position]
//            Toast.makeText(this, "${longClickedStudent.name}이 롱클릭 됨", Toast.LENGTH_SHORT).show()
            val alert = AlertDialog.Builder(this) // Androidx 가 주는 AlertDialog 선택
            alert.setTitle("학생 목록 삭제")
            alert.setMessage("정말 해당 학생을 삭제 하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                mStudentList.removeAt(position)
                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)
            alert.show()

            return@setOnItemLongClickListener true
        }



    }
}
package com.example.umc_week8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_week8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 데이터를 담을 배열
        val dataList = arrayListOf(
            Data("환영합니다!","메모를 시작해보세요!")
        )

        //앱 실행 시 이전에 저장된 값들 데이터 리스트에 저장
        val roomDB = AppDatabase.getInstance(this)
        if (roomDB != null){
            val dataList = roomDB.bookmarkDao().selectAll()
            //반복문으로 저장된 값들 저장
            for (i: Int in 0 until dataList.size){
                dataList.add(Data(dataList[i].title, dataList[i].content))
            }
            //변경사항 어댑터에 알려주기
            DataRVAdapter.notifyItemInserted(dataList.size)
        }

        //recyclerview
        viewBinding.rvData.layoutManager = LinearLayoutManager(this) // 까먹으면 안됨
        viewBinding.rvData.setHasFixedSize(true)
        viewBinding.rvData.adapter = DataRVAdapter(dataList)

        // 메모 작성화면으로 넘어가기
        viewBinding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, MemoActivity::class.java)
            startActivity(intent)
        }

        //메모 작성 화면에서 보낸 데이터 받기(돌아왔을 때)
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {result ->
            if(result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("title")
                val data2 = result.data?.getStringExtra("content")

                //position값 MemoActivity에서 받아오기(새로 만든 경우 -1 반환)
                val idx = result.data?.getIntExtra("idx",-1)
                val key = result.data?.getIntExtra("key",-1) as Int
                dataList.add(Data(data.toString(), data2.toString()))
                //DataRVAdapter.notifyItemInserted(dataList.size)
                // 새로운 메모를 만든 경우
                if(idx == -1){
                    dataList.add(Data(data.toString(), data2.toString()))
                    DataRVAdapter.notifyItemInserted(dataList.size)
                    if(roomDB != null){
                        val newmemo = Bookmark(data.toString(), data2.toString())
                        roomDB.bookmarkDao().insert(newmemo)
                    }
                }
                // 기존 메모를 수정한 경우
                else {
                    val star = result.data?.getBooleanExtra("star", false)
                    dataList.set(idx as Int, Data("$data", "$data2", star as Boolean))
                    DataRVAdapter.notifyDataSetChanged()
                    if (roomDB != null){
                        roomDB.bookmarkDao().updateTitleByMemoId(key, "$data")
                        roomDB.bookmarkDao().updateContentByMemoId(key, "$data2")
                    }
                }
            }
        }

        // 메모화면으로 넘어가기
        viewBinding.btnAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, MemoActivity::class.java)
            // 즐겨찾기 상태 보내기
            intent.putExtra("star",false)
            activityResultLauncher.launch(intent)
        }

        viewBinding.btnLocker.setOnClickListener {
            val intent = Intent(this, LockerActivity::class.java)
            startActivity(intent)

        }
        viewBinding.btnLocker.setOnClickListener {
            val intent = Intent(this@MainActivity, LockerActivity::class.java)
            for(i in 0..dataList.size){
                dataList.apply{add(dataList[i])}
            }
            activityResultLauncher.launch(intent)
        }





//        //bookmark
//
//        //SharedPreferences 값을 넣기
//        val sharedPrefs = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
//        val editor = sharedPrefs.edit()
//
//        //이 코드는 무시(초기화용)
//        editor.putString("eric", "")
//        editor.apply()
//        //
//
//        editor.putString("eric", "android") //key, value
//        val beforeapplyvalue = sharedPrefs.getString("eric", "") //putstring만 하고 get했을때
//        Log.d("SP Before", "${beforeapplyvalue}")//가져오는 방법
//
//        editor.apply() // putstring한 거 저장장
//
//       val spvalue = sharedPrefs.getString("eric", "")
//        Log.d("SP", "${spvalue}")//가져오는 방법
//        ///////////////////////////////////////////////////////
//        //RoomDB
//        val roomDb = AppDatabase.getInstance(this)
//        if (roomDb != null){
//            //insert create
//            val bookmark = Bookmark("Eric", 13)
//            roomDb.bookmarkDao().insert(bookmark)
//
//            // update
//            roomDb.bookmarkDao().updateNameByMemoId(1, "루나") //이름바꾸기
//
//            //delete
//            val deleteBookmark = Bookmark("", 0, 1)
//            roomDb.bookmarkDao().delete(deleteBookmark)
//
//            //use
//            val user = roomDb.bookmarkDao().selectByUserId(2)
//            Log.d("DB", "MemoId 2: $user")
//
//            val bookmarkList = roomDb.bookmarkDao().selectAll()
//            Log.d("DB", "Memo List : ${bookmarkList}")
//
//
//        }


    }
}
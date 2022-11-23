package com.example.umc_week8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Bookmark::class], version=1) //DB구조 바뀌면 버전 바꾸기**
abstract class AppDatabase: RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao

    companion object{
        private var appDatabase: AppDatabase? = null

        //효율적으로 객체 재활용하는 방법. 그러려니니
       @Synchronized //공유 자원의 문제 방지
        fun getInstance(context: Context): AppDatabase? {
            if (appDatabase == null){
                synchronized(AppDatabase::class.java){
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase

        }
    }
}
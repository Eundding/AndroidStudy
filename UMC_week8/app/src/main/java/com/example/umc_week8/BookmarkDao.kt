package com.example.umc_week8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//interface 파일로 만들기

@Dao
interface BookmarkDao {
    @Insert
    fun insert(bookmark: Bookmark)

    @Delete
    fun delete(bookmark: Bookmark)

    @Query("SELECT * FROM Bookmark") //모든 북마크 정보
    fun selectAll(): List<Bookmark>

    @Query("SELECT * FROM Bookmark WHERE memoId = :memoId")
    fun selectByBookmarkId(memoId: Int) : Bookmark

    @Query("SELECT * FROM Bookmark WHERE title =:title")
    fun selectByBookmarkTitle(title: String): Bookmark

    @Query("SELECT memoId FROM Bookmark WHERE title =:title")
    fun getIdByBookmarkTitle(title: String) : Int

    @Query("UPDATE Bookmark SET title = :title WHERE memoId = :memoId")
    fun updateTitleByMemoId(memoId: Int, title: String)

    @Query("UPDATE Bookmark SET content =:content WHERE memoID =:memoId")
    fun updateContentByMemoId(memoId: Int, content: String)
}
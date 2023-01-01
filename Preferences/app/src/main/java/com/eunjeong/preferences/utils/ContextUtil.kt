package com.eunjeong.preferences.utils

import android.content.Context

class ContextUtil {

    companion object{
        private val prefName = "TestPref"
        private val AUTO_LOGIN = "AUTO_LOGIN"

        // setter -> 자동로그인 저장 기능
        fun setAutoLogin(context: Context, autoLogin: Boolean){
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putBoolean(AUTO_LOGIN, autoLogin).apply()
        }

        // getter -> 자동로그인 여부 확인 기능
        fun getAutoLogin(context: Context) : Boolean{
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getBoolean(AUTO_LOGIN, false) // 기본은 false
        }



    }

}
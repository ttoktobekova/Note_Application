package com.example.noteapp.UI.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context) {
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var textShared: String?
        get() = sharedPreferences.getString(TEXT, "")
        set(value) {
            sharedPreferences.edit().putString(TEXT, value).apply()
        }

    var isOnBoardShow: Boolean
        get() = sharedPreferences.getBoolean(ON_BOARD, false)
        set(value) {
            sharedPreferences.edit().putBoolean(ON_BOARD, value).apply()
        }

    companion object {
        const val TEXT = "TEXT"
        const val ON_BOARD = "ONBOARD"
    }
}

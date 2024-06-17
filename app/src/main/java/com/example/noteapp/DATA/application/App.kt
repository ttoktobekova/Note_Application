package com.example.noteapp.DATA.application

import android.app.Application
import com.example.noteapp.UI.utils.PreferenceHelper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val sharedPreference = PreferenceHelper()
        sharedPreference.unit(this)
    }
}

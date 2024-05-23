package com.example.mynewsblog

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class NewsApplication: Application() {

    @Inject
  lateinit var loginRepository: LoginRepository

    override fun onCreate() {
        super.onCreate()


    }

}
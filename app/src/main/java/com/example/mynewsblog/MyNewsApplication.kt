package com.example.mynewsblog

import android.app.Application
import com.example.mynewsblog.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyNewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyNewsApplication)
            modules(appModule)
        }
    }
}

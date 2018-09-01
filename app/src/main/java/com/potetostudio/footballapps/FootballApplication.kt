package com.potetostudio.footballapps

import android.app.Application
import com.androidnetworking.AndroidNetworking

class FootballApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidNetworking.initialize(this)
        AndroidNetworking.enableLogging()
    }

}
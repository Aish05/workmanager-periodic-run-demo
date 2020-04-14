package aish.android.workmanagerdemo

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPrefsManager.init(this)
    }
}
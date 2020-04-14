package aish.android.workmanagerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aish.android.workmanagerdemo.SharedPrefsManager.get
import aish.android.workmanagerdemo.SharedPrefsManager.set
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWorkManager()
    }

    private fun startWorkManager() {

        val isScheduled: Boolean? =
            SharedPrefsManager.customPrefs?.get(Constants.IS_SCHEDULED, false) //getter

        isScheduled?.let { scheduled ->
            if (!scheduled) {
                Log.d("MyWorker", "started scheduler")
                SharedPrefsManager.customPrefs?.set(Constants.IS_SCHEDULED, true) //setter
                WorkManagerScheduler.refreshPeriodicWork(this)
            }
        }
    }

}

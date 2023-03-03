package com.example.esimlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.charter.esimlibrary.EsimHandler
import com.charter.esimlibrary.OnEsimDownloadListener
import com.charter.esimlibrary.Profile

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callEventListener = object : OnEsimDownloadListener {
            override fun onSuccess(result: String) {
                Log.v("callEventListener", "success >>>>>>")
            }
            override fun onFailure(result: String, profile: Profile) {
                Log.v("callEventListener", "error >>>>>> $result")
            }
        }

        EsimHandler.init(applicationContext, callEventListener)
        EsimHandler.downloadEsim("1\$thales3.prod.ondemandconnectivity.com\$910913B399733281904D820BC4AE9CD8BFFC00E83AB844926565E041AA2272AB")
    }
}

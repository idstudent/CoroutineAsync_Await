package com.example.coroutineasync_await

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.result_text)

        CoroutineScope(Main).launch { // ui 작업을 위해 Main

            val result1 = async(IO) {
                getResult1()
            }

            val result2 = async(IO) {
                getResult2()
            }

            val total = result1.await() + result2.await()

            resultView.text = total.toString()
        }
    }
}
private suspend fun getResult1() : Int {
    delay(10000)
    Log.e("ljy", "getResult1 호출")
    return 100
}

private suspend fun getResult2() : Int {
    delay(5000)
    Log.e("ljy", "getResult2 호출")
    return 200
}


package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val data = LiveData(this)
    var value: Int = 5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onC reate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // iniial data
        data.observe(value){

        }

        data.setData(5)
        Thread.sleep(1000)
        data.setData(6)
        Thread.sleep(1000)

        data.setData(7)
        Thread.sleep(1000)

        data.setData(789)

     //   data.removeObserver()
     //   Log.d( "live data value ", value.toString())

    }

    fun setValue(value : Int) : Int {
        data
        return value
    }
    fun observeData() {
        Log.d( "live data changed", "$value")
    }

}
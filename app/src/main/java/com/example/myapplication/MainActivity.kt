package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var imageList = ArrayList<Uri>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.bt).setOnClickListener {
            openGallery()
        }

    }

    private fun openGallery() {
        var intent = Intent()
        intent.type = "image/*";
        intent.action = Intent.ACTION_GET_CONTENT;
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1001);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001) {
            setData(data)
        }
    }

    private fun setData(data: Intent?) {
        for (i in 0..data?.clipData?.itemCount!!) {
            data?.clipData?.getItemAt(0)?.uri?.let { imageList.add(it) }
        }
        if(imageList.size == 0) {
            setRV()
        }
    }

    private fun setRV() {
        var rv = findViewById<RecyclerView>(R.id.rv_images)
        rv.adapter = ImageAdaptor(this,imageList)
        rv.layoutManager = GridLayoutManager(this, 3)
    }
}
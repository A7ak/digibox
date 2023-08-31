package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ImageAdaptor(val context: Context, var imageList: ArrayList<Uri>) : RecyclerView.Adapter<ImageAdaptor.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.image_item,parent ,false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {


    }

     class ImageViewHolder(view: View) : RecyclerView.ViewHolder (view){

     }

}
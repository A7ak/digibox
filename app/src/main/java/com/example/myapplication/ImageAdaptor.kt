package com.example.myapplication

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdaptor(val context: Context, var imageList: ArrayList<Uri>) : RecyclerView.Adapter<ImageAdaptor.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.image_item,parent ,false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            Glide.with(context)
            .load(imageList[position])
            .into(holder.iv)
    }

     class ImageViewHolder(view: View) : RecyclerView.ViewHolder (view){
         val iv : ImageView = view.findViewById(R.id.image_item)

     }

    fun addItem(list : ArrayList<Uri>){
        var size = imageList.size
        imageList.addAll(list)
        notifyItemRangeInserted(size,imageList.size)
    }

}
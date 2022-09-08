package com.dicoding.alfred.firstsubmission.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object Helper {

    const val TYPE_MOVIE = "type_movie"
    const val TYPE_TVSHOW = "type_tvshow"

    fun setImageWithGlide(context: Context, imagePath: String, imageView: ImageView) {
        Glide.with(context).clear(imageView)
        Glide.with(context).load(imagePath).into(imageView)
    }
}
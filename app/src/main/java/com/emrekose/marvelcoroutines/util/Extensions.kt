package com.emrekose.marvelcoroutines.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import com.emrekose.marvelcoroutines.BuildConfig

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun debug(body: () -> Unit) {
    if (BuildConfig.DEBUG) body()
}

inline fun <reified T: Activity> Context.openActivity() =
    startActivity(Intent(this, T::class.java))

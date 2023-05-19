package com.planetsystems.events.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.ResponseBody
import org.json.JSONObject

fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("no activity")
}

fun ResponseBody.toJSONObject(): JSONObject {
    val json = this.string()
    return JSONObject(json)
}

fun JSONObject.toRequestBody(): RequestBody{
    val jsonString = this.toString()
    val mediaType = "application/json".toMediaTypeOrNull()
    return jsonString.toRequestBody(mediaType)
}
package com.planetsystems.events.feature_events.domain.model

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class Event(
    val id: Int,
    val name: String,
    val image: String?,
    @DrawableRes val imageRes: Int? = null,
    val date: String,
    val time: String,
    val location: String,
    val description: String,
    @SerializedName("attendees_count") val attendance: String,
    val organizerName: String?,
    val organizerImage: String?
)

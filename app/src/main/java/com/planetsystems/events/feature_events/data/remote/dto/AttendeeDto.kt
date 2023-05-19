package com.planetsystems.events.feature_events.data.remote.dto

data class AttendeeDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val title: String,
    val organisation: String,
    val nin: String,
    val phone: String,
    val receivedTransport: Boolean = false,
    val receivedLunch: Boolean = false
)

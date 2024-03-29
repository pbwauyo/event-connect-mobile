package com.planetsystems.events.feature_events.domain.model

data class Attendee(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val title: String,
    val organisation: String,
    val nin: String,
    val phone: String,
    val receivedTransport: Boolean = false,
    val receivedLunch: Boolean = false,
    val eventId: Int = 0
)

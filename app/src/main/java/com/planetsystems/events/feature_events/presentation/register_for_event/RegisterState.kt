package com.planetsystems.events.feature_events.presentation.register_for_event

data class RegisterState(
    val isLoading: Boolean = false,
    val success: String? = null,
    val error: String? = null
)

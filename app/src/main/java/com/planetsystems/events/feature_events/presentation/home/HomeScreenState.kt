package com.planetsystems.events.feature_events.presentation.home

import com.planetsystems.events.feature_events.domain.model.Event

data class HomeScreenState(
    val isLoading: Boolean = false,
    val loaded: List<Event> = listOf(),
    val error: String? = null
)

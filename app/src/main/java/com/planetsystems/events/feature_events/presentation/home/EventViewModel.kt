package com.planetsystems.events.feature_events.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.planetsystems.events.feature_events.data.repository.EventRepository
import com.planetsystems.events.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(private val eventRepository: EventRepository) :
    ViewModel() {
//    var homeScreenState = mutableStateOf(HomeScreenState())
//        private set

    val state = eventRepository.getEvents().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = Resource.Loading
    )

//    init {
//        getEvents()
//    }
//
//    private fun getEvents() {
//        eventRepository.getEvents().onEach { resource ->
//            when (resource) {
//                Resource.Loading -> {
//                    val newValue = homeScreenState.value.copy(isLoading = true)
//                    homeScreenState.value = newValue
//                }
//
//                is Resource.Success -> {
//                    val newValue =
//                        homeScreenState.value.copy(
//                            isLoading = false,
//                            loaded = resource.data,
//                            error = null
//                        )
//                    homeScreenState.value = newValue
//                }
//
//                is Resource.Error -> {
//                    val newValue =
//                        homeScreenState.value.copy(
//                            isLoading = false,
//                            loaded = listOf(),
//                            error = resource.message
//                        )
//                    homeScreenState.value = newValue
//                }
//            }
//        }.stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000L),
//            initialValue = Resource.Loading
//        )
//    }
}
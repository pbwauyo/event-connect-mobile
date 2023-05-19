package com.planetsystems.events.feature_events.data.repository

import com.planetsystems.events.feature_events.data.remote.ApiService
import com.planetsystems.events.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class EventRepository @Inject constructor(private val apiService: ApiService) {
    fun getEvents() = flow {
        emit(Resource.Loading)
        val events = apiService.getEvents()
        emit(Resource.Success(events))
    }.catch { e -> emit(Resource.Error(e.message)) }.flowOn(Dispatchers.IO)
}
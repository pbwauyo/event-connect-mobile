package com.planetsystems.events.feature_events.data.repository

import com.planetsystems.events.feature_events.data.remote.ApiService
import com.planetsystems.events.feature_events.domain.model.Attendee
import com.planetsystems.events.util.Resource
import com.planetsystems.events.util.toRequestBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.inject.Inject

class AttendeeRepository @Inject constructor(private val apiService: ApiService) {
//    fun registerAttendee(attendee: Attendee): Flow<Resource<String>> = flow {
//        emit(Resource.Loading)
//        val json = JSONObject()
//        json.put("eventId", attendee.eventId)
//        json.put("firstName", attendee.firstName)
//        json.put("lastName", attendee.lastName)
//        json.put("gender", attendee.gender)
//        json.put("title", attendee.title)
//        json.put("organisation", attendee.organisation)
//        json.put("nin", attendee.nin)
//        json.put("phone", attendee.phone)
//        json.put("receivedTransport", attendee.receivedTransport)
//        json.put("receivedLunch", attendee.receivedLunch)
//        apiService.registerAttendee(json.toRequestBody())
//        emit(Resource.Success("Attendee Registered Successfully"))
//    }.catch { e -> emit(Resource.Error(e.message)) }.flowOn(Dispatchers.IO)

    suspend fun registerAttendee(attendee: Attendee){
        val json = JSONObject()
        json.put("eventId", attendee.eventId)
        json.put("firstName", attendee.firstName)
        json.put("lastName", attendee.lastName)
        json.put("gender", attendee.gender)
        json.put("title", attendee.title)
        json.put("organisation", attendee.organisation)
        json.put("nin", attendee.nin)
        json.put("phone", attendee.phone)
        json.put("receivedTransport", attendee.receivedTransport)
        json.put("receivedLunch", attendee.receivedLunch)
        withContext(Dispatchers.IO){
            apiService.registerAttendee(json.toRequestBody())
        }
    }
}
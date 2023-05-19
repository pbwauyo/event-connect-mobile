package com.planetsystems.events.feature_events.data.remote

import com.planetsystems.events.feature_events.domain.model.Event
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
    @GET("events")
    suspend fun getEvents(): List<Event>

    @POST("attendees/")
    suspend fun registerAttendee(@Body requestBody: RequestBody): Response<ResponseBody>

    @PUT("attendees")
    suspend fun updateAttendee(@Body requestBody: RequestBody): Response<ResponseBody>
}
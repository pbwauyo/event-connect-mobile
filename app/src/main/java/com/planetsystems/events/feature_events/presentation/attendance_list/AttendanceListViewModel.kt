package com.planetsystems.events.feature_events.presentation.attendance_list

import androidx.lifecycle.ViewModel
import com.planetsystems.events.feature_events.data.repository.AttendeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AttendanceListViewModel @Inject constructor(private val attendeeRepository: AttendeeRepository) :
    ViewModel() {

}
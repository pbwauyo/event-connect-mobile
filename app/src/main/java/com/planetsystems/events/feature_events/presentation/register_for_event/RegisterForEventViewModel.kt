package com.planetsystems.events.feature_events.presentation.register_for_event

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.planetsystems.events.feature_events.data.repository.AttendeeRepository
import com.planetsystems.events.feature_events.domain.model.Attendee
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterForEventViewModel @Inject constructor(private val attendeeRepository: AttendeeRepository) :
    ViewModel() {

    var fName by mutableStateOf("")

    var lName by mutableStateOf("")

    var title by mutableStateOf("")

    var gender by mutableStateOf("")

    var organisation by mutableStateOf("")

    var nin by mutableStateOf("")

    var phone by mutableStateOf("")

    private var _registerScreenState = mutableStateOf(RegisterState())
    val registerScreenState: State<RegisterState> = _registerScreenState

    fun registerForEvent(eventId: Int) {
        _registerScreenState.value = RegisterState(isLoading = true)
        val attendee = Attendee(
            firstName = fName,
            lastName = lName,
            nin = nin,
            organisation = organisation,
            phone = phone,
            title = title,
            eventId = eventId,
            gender = gender
        )
        viewModelScope.launch {
            try {
                attendeeRepository.registerAttendee(attendee)
                _registerScreenState.value = _registerScreenState.value.copy(
                    isLoading = false,
                    success = "Registration Successful"
                )
                clearFields()
            } catch (e: Exception) {
                if (e is CancellationException) {
                    throw e
                }
                _registerScreenState.value = _registerScreenState.value.copy(
                    isLoading = false,
                    error = "Registration Unsuccessful"
                )
            }
        }
    }

    private fun clearFields(){
        fName = ""
        lName = ""
        title = ""
        gender = ""
        organisation = ""
        nin = ""
        phone = ""
    }
}
package com.planetsystems.events.feature_events.presentation.attendance_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.planetsystems.events.feature_events.domain.model.Attendee
import com.planetsystems.events.feature_events.domain.util.dummyAttendees

@Composable
fun AttendanceListScreen(attendees: List<Attendee>, onClick: (Attendee) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            bottom = 16.dp,
            top = 8.dp
        )
    ) {
        items(attendees, key = { it.phone }) { attendee ->
            AttendanceCard(attendee = attendee, onClick = onClick)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AttendanceListScreenPreview() {
    AttendanceListScreen(attendees = dummyAttendees, onClick = {})
}
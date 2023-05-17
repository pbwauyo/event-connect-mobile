package com.planetsystems.events.feature_events.presentation.attendance_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.planetsystems.events.R
import com.planetsystems.events.feature_events.domain.model.Attendee
import com.planetsystems.events.feature_events.domain.util.dummyAttendees

@Composable
fun AttendanceCard(attendee: Attendee, onClick: (Attendee) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .clickable {
                onClick(attendee)
            }
            .padding(top = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painterResource(id = R.drawable.default_profile_pic),
                    contentDescription = "",
                    modifier = Modifier.size(60.dp)
                )

                Column(modifier = Modifier.padding(start = 4.dp)) {
                    Text(
                        text = "${attendee.title} ${attendee.firstName} ${attendee.lastName}",
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(text = attendee.phone, modifier = Modifier.padding(top = 8.dp))
                }
            }

            Icon(
                Icons.Outlined.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(20.dp),
                tint = Color(0x66000000)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AttendanceCardPreview() {
    AttendanceCard(attendee = dummyAttendees.first(), onClick = {})
}
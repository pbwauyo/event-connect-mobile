package com.planetsystems.events.feature_events.presentation.attendee_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.planetsystems.events.R
import com.planetsystems.events.feature_events.domain.model.Attendee
import com.planetsystems.events.feature_events.domain.util.dummyAttendees

@Composable
fun AttendeeDetailsScreen(attendee: Attendee) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.default_profile_pic),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(65.dp)
        )

        Text(
            text = "${attendee.title} ${attendee.firstName} ${attendee.lastName}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 16.dp),
        ) {
            Card(
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 4.dp)
            ) {
                Row {
                    Checkbox(checked = true, onCheckedChange = {})
                    Text(
                        text = "Received Lunch",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 4.dp)
            ) {
                Row {
                    Checkbox(checked = true, onCheckedChange = {})
                    Text(
                        text = "Received Transport",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.outline_business_center),
                contentDescription = "",
                tint = Color(0xFF9FA3AE),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Organisation",
                    color = Color(0xFFA9ACB2),
                    fontSize = 12.sp
                )

                Text(text = attendee.organisation, modifier = Modifier.padding(top = 4.dp))

                Divider(
                    color = Color(0xFFEEEEEE),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_phone),
                contentDescription = "",
                tint = Color(0xFF9FA3AE),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Phone Number",
                    color = Color(0xFFA9ACB2),
                    fontSize = 12.sp
                )

                Text(text = attendee.phone, modifier = Modifier.padding(top = 4.dp))

                Divider(
                    color = Color(0xFFEEEEEE),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_perm_identity),
                contentDescription = "",
                tint = Color(0xFF9FA3AE),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "NIN",
                    color = Color(0xFFA9ACB2),
                    fontSize = 12.sp
                )

                Text(text = attendee.nin, modifier = Modifier.padding(top = 4.dp))

                Divider(
                    color = Color(0xFFEEEEEE),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AttendeeDetailsScreenPreview() {
    AttendeeDetailsScreen(attendee = dummyAttendees.first())
}
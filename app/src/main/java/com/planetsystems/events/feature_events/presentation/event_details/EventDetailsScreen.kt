package com.planetsystems.events.feature_events.presentation.event_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.planetsystems.events.R
import com.planetsystems.events.feature_events.domain.model.Event
import com.planetsystems.events.feature_events.domain.util.dummyEvents
import com.planetsystems.events.ui.theme.Orange

@Composable
fun EventDetailsScreen(event: Event) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = event.name, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(180.dp)
                .padding(top = 8.dp)
        ) {
            Image(
                painterResource(id = event.imageRes ?: R.drawable.wb_youth_summit),
                contentDescription = "Youth Summit",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF8531DF))
            ) {
                Icon(
                    Icons.Filled.DateRange,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.padding(6.dp)
                )
            }

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append(event.date)
                    }
                    append(" ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, color = Orange)) {
                        append(event.time)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)
            )
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE1A625))
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.padding(6.dp)
                )
            }

            Text(
                "${event.attendance} People",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)
            )
        }

        Row(modifier = Modifier.padding(top = 8.dp)) {
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF2C3BCA))
            ) {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.padding(6.dp)
                )
            }

            Text(
                event.location,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(end = 16.dp, top = 20.dp)
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Icon(painterResource(id = R.drawable.baseline_groups_24), contentDescription = null)
                Text(text = "Attendance", modifier = Modifier.padding(start = 4.dp))
            }

            Button(
                onClick = {
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(end = 16.dp, top = 20.dp)
                    .weight(1F),
                colors = ButtonDefaults.buttonColors(containerColor = Orange)
            ) {
                Icon(painterResource(id = R.drawable.playlist_add), contentDescription = null)
                Text(text = "Join", modifier = Modifier.padding(start = 4.dp))
            }
        }

        Text(
            text = "About this Event",
            modifier = Modifier.padding(top = 10.dp),
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = event.description,
            modifier = Modifier.padding(top = 4.dp),
            lineHeight = 22.sp
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun EventDetailsScreenPreview() {
    EventDetailsScreen(event = dummyEvents.first())
}
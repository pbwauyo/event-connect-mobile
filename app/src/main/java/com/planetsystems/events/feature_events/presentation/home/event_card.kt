package com.planetsystems.events.feature_events.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.planetsystems.events.R
import com.planetsystems.events.feature_events.domain.model.Event
import com.planetsystems.events.feature_events.domain.util.dummyEvents
import com.planetsystems.events.ui.theme.Orange

@Composable
fun EventCard(event: Event, onJoinClick: () -> Unit, onCardClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .clickable {
                onCardClick()
            }
            .padding(top = 16.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Box {
                Image(
                    painterResource(id = event.imageRes ?: R.drawable.wb_youth_summit),
                    contentDescription = "Youth Summit",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Button(
                    onClick = {
                        onJoinClick()
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(y = (22).dp)
                        .padding(end = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Orange)
                ) {
                    Icon(painterResource(id = R.drawable.playlist_add), contentDescription = null)
                    Text(text = "Join", modifier = Modifier.padding(start = 4.dp))
                }
            }

            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
                Row {
                    Text(text = event.date, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = event.time,
                        color = Color.Magenta,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Text(
                    text = event.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Image(
                            painterResource(id = R.drawable.wb_logo_3),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                        )

                        Text(
                            text = event.organizerName,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(start = 2.dp)
                                .align(Alignment.CenterVertically),
                            fontWeight = FontWeight.Normal
                        )

                        Text(
                            text = "Sponsor",
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .align(Alignment.CenterVertically),
                            fontWeight = FontWeight.Light
                        )
                    }

                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Icon(
                            painterResource(id = R.drawable.ic_person),
                            contentDescription = null,
                            tint = Color(0xFF9AADBA),
                            modifier = Modifier
                                .size(24.dp)
                        )

                        Text(
                            text = event.attendance,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(start = 2.dp)
                                .align(Alignment.CenterVertically),
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun EventCardPreview() {
    val event = dummyEvents.first()
    EventCard(
        event = event,
        onJoinClick = {},
        onCardClick = {}
    )
}


package com.planetsystems.events.feature_events.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.planetsystems.events.feature_events.domain.model.Event
import com.planetsystems.events.feature_events.domain.util.dummyEvents

@Composable
fun HomeScreen(events: List<Event>, onJoinClick: (Event) -> Unit, onCardClick: (Event) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 8.dp,
            bottom = 16.dp
        )
    ) {
        items(events, key = { it.id }) { event ->
            EventCard(
                event = event,
                onJoinClick = {
                    onJoinClick(event)
                },
                onCardClick = {
                    onCardClick(event)
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        events = dummyEvents,
        onJoinClick = {},
        onCardClick = {}
    )
}
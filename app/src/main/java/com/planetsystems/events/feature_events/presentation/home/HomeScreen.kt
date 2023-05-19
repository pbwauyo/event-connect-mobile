package com.planetsystems.events.feature_events.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.planetsystems.events.feature_events.domain.model.Event
import com.planetsystems.events.util.Resource

@Composable
fun HomeScreen(
//    events: List<Event>,
    onJoinClick: (Event) -> Unit,
    onCardClick: (Event) -> Unit,
    viewModel: EventViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.state.collectAsState()

    LaunchedEffect(key1 = state) {
        if (state.value is Resource.Error) {
            state.value.let {
                val err = it as Resource.Error
                Toast.makeText(context, err.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        if (state.value is Resource.Success) {
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 16.dp
                )
            ) {
                val data = (state.value as Resource.Success).data
                items(data, key = { it.id }) { event ->
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

        if (state.value is Resource.Loading) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
//        events = dummyEvents,
        onJoinClick = {},
        onCardClick = {}
    )
}
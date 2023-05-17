package com.planetsystems.events.util

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object HomeScreen : Screen("home_screen")
    object RegisterForEventScreen : Screen("register_for_event_screen")
    object EventDetailsScreen : Screen("event_details_screen")
    object AttendeeDetailsScreen : Screen("attendee_details_screen")
    object AttendanceListScreen : Screen("attendance_list_screen")
}
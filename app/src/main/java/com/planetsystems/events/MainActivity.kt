package com.planetsystems.events

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.planetsystems.events.feature_auth.login.LoginScreen
import com.planetsystems.events.feature_auth.signup.SignUpScreen
import com.planetsystems.events.feature_events.presentation.event_details.EventDetailsScreen
import com.planetsystems.events.feature_events.presentation.home.HomeScreen
import com.planetsystems.events.feature_events.presentation.register_for_event.RegisterForEventScreen
import com.planetsystems.events.feature_events.presentation.register_for_event.RegisterForEventViewModel
import com.planetsystems.events.ui.theme.EventsTheme
import com.planetsystems.events.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventsTheme (dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(Screen.LoginScreen.route) {
                            var email by remember {
                                mutableStateOf("")
                            }

                            var password by remember {
                                mutableStateOf("")
                            }

                            LoginScreen(
                                email = email,
                                onEmailChange = { email = it },
                                password = password,
                                onPasswordChange = { password = it },
                                navigateToRegister = {
                                    navController.navigate(Screen.SignUpScreen.route)
                                },
                                navigateToHome = {
                                    navController.navigate(Screen.HomeScreen.route)
                                }
                            )
                        }

                        composable(Screen.SignUpScreen.route) {
                            var fName by remember {
                                mutableStateOf("")
                            }

                            var lName by remember {
                                mutableStateOf("")
                            }

                            var email by remember {
                                mutableStateOf("")
                            }

                            var nin by remember {
                                mutableStateOf("")
                            }

                            var password by remember {
                                mutableStateOf("")
                            }

                            SignUpScreen(
                                fName = fName,
                                onFNameChange = {
                                    fName = it
                                },
                                lName = lName,
                                onLNameChange = {
                                    lName = it
                                },
                                email = email,
                                onEmailChange = {
                                    email = it
                                },
                                nin = nin,
                                onNinChange = {
                                    nin = it
                                },
                                password = password,
                                onPasswordChange = {
                                    password = it
                                },
                                navigateToLogin = {
                                    navController.navigate(Screen.LoginScreen.route)
                                }
                            )
                        }

                        composable(Screen.HomeScreen.route) {
//                            val eventViewModel: EventViewModel = hiltViewModel()

                            HomeScreen(
//                                events = dummyEvents,
                                onJoinClick = {
                                    navController.navigate(Screen.RegisterForEventScreen.route + "/${it.id}")
                                },
                                onCardClick = {

                                }
                            )
                        }

                        composable(
                            route = Screen.RegisterForEventScreen.route + "/{eventId}",
                            arguments = listOf(navArgument("eventId") { type = NavType.IntType })
                        ) {
                            val viewModel: RegisterForEventViewModel = hiltViewModel()

                            val eventId = it.arguments?.getInt("eventId") ?: 0
                            RegisterForEventScreen(
                                registerForEventViewModel = viewModel,
                                firstName = viewModel.fName,
                                onFirstNameChange = { fName -> viewModel.fName = fName },
                                lastName = viewModel.lName,
                                onLastNameChange = { lName -> viewModel.lName = lName },
                                gender = viewModel.gender,
                                onGenderChange = { gender -> viewModel.gender = gender },
                                title = viewModel.title,
                                onTitleChange = { title -> viewModel.title = title },
                                organisation = viewModel.organisation,
                                onOrganisationChange = { organisation ->
                                    viewModel.organisation = organisation
                                },
                                nin = viewModel.nin,
                                onNinChange = { nin -> viewModel.nin = nin },
                                phone = viewModel.phone,
                                onPhoneChange = { phone -> viewModel.phone = phone },
                                onRegisterBtnClicked = {
                                    viewModel.registerForEvent(eventId)
                                }
                            )
                        }

//                        composable(
//                            route = Screen.EventDetailsScreen.route
//                        ){
//                            EventDetailsScreen(event = )
//                        }
                    }
                }
            }
        }
    }
}
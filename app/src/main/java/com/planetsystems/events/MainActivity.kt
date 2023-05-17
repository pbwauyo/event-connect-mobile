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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.planetsystems.events.feature_auth.login.LoginScreen
import com.planetsystems.events.feature_auth.signup.SignUpScreen
import com.planetsystems.events.feature_events.domain.util.dummyEvents
import com.planetsystems.events.feature_events.presentation.register_for_event.RegisterForEventScreen
import com.planetsystems.events.feature_events.presentation.home.HomeScreen
import com.planetsystems.events.ui.theme.EventsTheme
import com.planetsystems.events.util.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LoginScreen.route
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
                            HomeScreen(
                                events = dummyEvents,
                                onJoinClick = {
                                    navController.navigate(Screen.RegisterForEventScreen.route)
                                },
                                onCardClick = {}
                            )
                        }

                        composable(Screen.RegisterForEventScreen.route) {
                            var fName by remember {
                                mutableStateOf("")
                            }

                            var lName by remember {
                                mutableStateOf("")
                            }

                            var title by remember {
                                mutableStateOf("")
                            }

                            var organisation by remember {
                                mutableStateOf("")
                            }

                            var nin by remember {
                                mutableStateOf("")
                            }

                            var phone by remember {
                                mutableStateOf("")
                            }

                            RegisterForEventScreen(
                                firstName = fName,
                                onFirstNameChange = { fName = it },
                                lastName = lName,
                                onLastNameChange = { lName = it },
                                title = title,
                                onTitleChange = { title = it },
                                organisation = organisation,
                                onOrganisationChange = { organisation = it },
                                nin = nin,
                                onNinChange = { nin = it },
                                phone = phone,
                                onPhoneChange = { phone = it },
                                onRegisterBtnClicked = {}
                            )
                        }
                    }
                }
            }
        }
    }
}
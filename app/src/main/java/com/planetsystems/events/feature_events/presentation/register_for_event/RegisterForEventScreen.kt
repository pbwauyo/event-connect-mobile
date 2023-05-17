@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.planetsystems.events.feature_events.presentation.register_for_event

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.planetsystems.events.feature_events.domain.util.CustomButton
import com.planetsystems.events.feature_events.domain.util.CustomTextField

val modifier = Modifier.fillMaxWidth()

val inputModifier = Modifier
    .padding(top = 6.dp)
    .fillMaxWidth()

val labelModifier = Modifier
    .padding(top = 16.dp)

val containerModifier = Modifier
    .fillMaxWidth()
    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)

val buttonModifier = Modifier
    .padding(top = 24.dp)
    .fillMaxWidth()

@Composable
fun RegisterForEventScreen(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    title: String,
    onTitleChange: (String) -> Unit,
    organisation: String,
    onOrganisationChange: (String) -> Unit,
    nin: String,
    onNinChange: (String) -> Unit,
    phone: String,
    onPhoneChange: (String) -> Unit,
    onRegisterBtnClicked: () -> Unit
) {
    Column(
        modifier = containerModifier
            .verticalScroll(rememberScrollState()),
    ) {
        CustomTextField(
            label = "First Name",
            value = firstName,
            onValueChange = onFirstNameChange,
            modifier = modifier,
            inputModifier = inputModifier,
            labelModifier = labelModifier
        )

        CustomTextField(
            label = "Last Name",
            value = lastName,
            onValueChange = onLastNameChange,
            modifier = modifier,
            inputModifier = inputModifier,
            labelModifier = labelModifier
        )

        CustomTextField(
            label = "Title",
            value = title,
            onValueChange = onTitleChange,
            modifier = modifier,
            inputModifier = inputModifier,
            labelModifier = labelModifier
        )

        CustomTextField(
            label = "Organisation Representing",
            value = organisation,
            onValueChange = onOrganisationChange,
            modifier = modifier,
            inputModifier = inputModifier,
            labelModifier = labelModifier
        )

        CustomTextField(
            label = "NIN Number",
            value = nin,
            onValueChange = onNinChange,
            modifier = modifier,
            inputModifier = inputModifier,
            labelModifier = labelModifier
        )

        CustomTextField(
            label = "Phone Number",
            value = phone,
            onValueChange = onPhoneChange,
            modifier = modifier,
            inputModifier = inputModifier,
            labelModifier = labelModifier
        )

        CustomButton(
            modifier = buttonModifier,
            label = "Register for Event",
            onClick = onRegisterBtnClicked
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterForEventScreenPreview() {
    RegisterForEventScreen(
        firstName = "",
        onFirstNameChange = {},
        lastName = "",
        onLastNameChange = {},
        title = "",
        onTitleChange = {},
        organisation = "",
        onOrganisationChange = {},
        nin = "",
        onNinChange = {},
        phone = "",
        onPhoneChange = {},
        onRegisterBtnClicked = {}
    )
}


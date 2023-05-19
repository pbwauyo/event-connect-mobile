@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.planetsystems.events.feature_events.presentation.register_for_event

import android.app.Activity
import android.content.ContentValues
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.planetsystems.events.feature_events.domain.util.CustomButton
import com.planetsystems.events.feature_events.domain.util.CustomTextField
import com.planetsystems.events.util.BitmapUtils
import com.planetsystems.events.util.Utility
import com.planetsystems.events.util.findActivity

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
    registerForEventViewModel: RegisterForEventViewModel = hiltViewModel(),
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    gender: String,
    onGenderChange: (String) -> Unit,
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

    val activity = LocalContext.current.findActivity()

    val textRecognizer = remember {
        TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    }

    var imageUri: Uri? by remember {
        mutableStateOf(null)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                processImage(activity, imageUri!!, textRecognizer, {
                    onFirstNameChange(it)
                }, {
                    onLastNameChange(it)
                }, {
                    onNinChange(it)
                }, {
                    onGenderChange(it)
                })
            }
        }

    Box {
        Column(
            modifier = containerModifier
                .verticalScroll(rememberScrollState()),
        ) {
            CustomButton(
                modifier = buttonModifier,
                label = "Autofill with National ID",
                onClick = {
                    imageUri = getUri(activity)
                    cameraLauncher.launch(imageUri)
                }
            )

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
                label = "Gender",
                value = gender,
                onValueChange = onGenderChange,
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

            CustomButton(
                modifier = buttonModifier,
                label = "Register for Event",
                onClick = onRegisterBtnClicked
            )
        }

        if (registerForEventViewModel.registerScreenState.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

private fun processImage(
    activity: Activity,
    imageUri: Uri,
    textRecognizer: TextRecognizer,
    retrieveFirstName: (String) -> Unit,
    retrieveLastName: (String) -> Unit,
    retrieveNin: (String) -> Unit,
    retrieveGender: (String) -> Unit
) {
    try {
        val imageBitmap =
            BitmapUtils.getBitmapFromContentUri(activity.contentResolver, imageUri)
                ?: return
        val inputImage = InputImage.fromBitmap(imageBitmap, 0)
        textRecognizer.process(inputImage)
            .addOnSuccessListener { text ->
                val list = text.text.split(Regex("\n")).map { it.trim().trimIndent() }
                Log.d("Reg_Event", "processImage: text=${text.text}")
                Log.d("Reg_Event", "processImage: list=$list")
                retrieveFirstName(getFirstName(list))
                retrieveLastName(getLastName(list))
                retrieveNin(getNin(list))
                retrieveGender(getGender(list))
            }.addOnFailureListener {

            }
    } catch (e: Exception) {
    }
}

private fun getFirstName(strings: List<String>): String {
    return strings[3]
}

private fun getLastName(strings: List<String>): String {
    return strings[5]
}

private fun getGender(strings: List<String>): String {
    val gender = strings.firstOrNull { it == "M" || it == "F" }
    return gender ?: "N/A"
}

private fun getNin(strings: List<String>): String {
    var nin =
        strings.firstOrNull { string -> string.startsWith("CF") || string.startsWith("CM") }
    if (nin != null && nin.length > 14) {
        nin = nin.substring(0, 14)
    }
    return if (nin != null && Utility.isNinValid(nin)) {
        nin
    } else {
        "Invalid NIN"
    }
}

private fun getUri(activity: Activity): Uri? {
    val values = ContentValues()
    values.put(MediaStore.Images.Media.TITLE, "Take National ID Picture")
    values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera")
    return activity.contentResolver.insert(
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        values
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterForEventScreenPreview() {
    RegisterForEventScreen(
        firstName = "",
        onFirstNameChange = {},
        lastName = "",
        onLastNameChange = {},
        gender = "",
        onGenderChange = {},
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


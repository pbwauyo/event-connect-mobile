@file:OptIn(ExperimentalMaterial3Api::class)

package com.planetsystems.events.feature_events.domain.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    inputModifier: Modifier,
    labelModifier: Modifier
) {
    Column(modifier = modifier) {
        Text(text = label, modifier = labelModifier)

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = inputModifier,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomTextFieldPreview() {
    CustomTextField(
        label = "First Name",
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        inputModifier = Modifier
            .padding(top = 6.dp)
            .fillMaxWidth(),
        labelModifier = Modifier
            .padding(top = 16.dp)
    )
}
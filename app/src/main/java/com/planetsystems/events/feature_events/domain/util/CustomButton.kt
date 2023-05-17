package com.planetsystems.events.feature_events.domain.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(modifier: Modifier, label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 16.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(text = label)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth(),
        label = "Register",
        onClick = {}
    )
}
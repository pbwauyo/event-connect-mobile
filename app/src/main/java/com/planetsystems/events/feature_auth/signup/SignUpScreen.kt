package com.planetsystems.events.feature_auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.planetsystems.events.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    fName: String,
    onFNameChange: (String) -> Unit,
    lName: String,
    onLNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    nin: String,
    onNinChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    navigateToLogin: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_transparent),
            contentDescription = "logo",
            modifier = Modifier.size(250.dp),
        )

        Text(text = "Welcome to EventConnect", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)

        Text(text = "Please signup to start using the app", fontSize = 12.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = fName,
            onValueChange = onFNameChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = lName,
            onValueChange = onLNameChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nin,
            onValueChange = onNinChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(0.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Register")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            onClick = {
                navigateToLogin()
            },
            shape = RoundedCornerShape(0.dp),
            contentPadding = PaddingValues(vertical = 15.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Already have an account? Sign In")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        fName = "",
        onFNameChange = {},
        lName = "",
        onLNameChange = {},
        email = "",
        onEmailChange = {},
        nin = "",
        onNinChange = {},
        password = "",
        onPasswordChange = {},
        navigateToLogin = {}
    )
}

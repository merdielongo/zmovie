package com.elongocrea.zmovie.ui.screen.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elongocrea.zmovie.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
        )
        Button(
            onClick = {
                authViewModel.signUp(email, password) { success ->
                    message = if (success) "Registration Successful" else "Registration Failed"
                }
            }
        ) {
            Text("Register")
        }
        Text(text = message)
    }
}
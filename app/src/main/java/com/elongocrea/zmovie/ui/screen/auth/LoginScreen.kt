package com.elongocrea.zmovie.ui.screen.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elongocrea.zmovie.viewmodel.AuthViewModel
import org.koin.androidx.compose.koinViewModel
import com.elongocrea.zmovie.R
import com.elongocrea.zmovie.ui.components.button.ButtonIcon
import com.elongocrea.zmovie.ui.components.button.CustomButton
import com.elongocrea.zmovie.ui.components.form.CustomTextField

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = koinViewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val message by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_1),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome back", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "Enter your email",
        )
        Spacer(modifier = Modifier.height(15.dp))
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            label = "Password",
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible) painterResource(id = R.drawable.ic_visibility)
                else painterResource(id = R.drawable.ic_visibility_off)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                }
            }
        )
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { /* Handle forgot password */ }) {
                Text(text = "Forgot password?")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(
            modifier = Modifier.fillMaxWidth().height(45.dp),
            label = "Login",
            enabled = email.isNotEmpty() && password.isNotEmpty(),
            onClick = {

                authViewModel.signIn(email, password) { success ->
                    if (success) {
                        navController.navigate("movies")
                    }
                }
            },
        )
        Spacer(modifier = Modifier.height(16.dp))
        ButtonIcon(
            modifier = Modifier.fillMaxWidth(),
            label = "Continue with Google",
            onClick = { }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have an account?")
            Spacer(modifier = Modifier.width(4.dp))
            TextButton(onClick = { /* Handle register */ }) {
                Text(text = "Register")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
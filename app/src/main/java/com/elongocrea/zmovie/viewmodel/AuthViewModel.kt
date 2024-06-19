package com.elongocrea.zmovie.viewmodel

import androidx.lifecycle.ViewModel
import com.elongocrea.zmovie.auth.FirebaseAuthManager

class AuthViewModel(private val authManager: FirebaseAuthManager) : ViewModel() {

    fun signIn(email: String, password: String, onResult: (Boolean) -> Unit) {
        authManager.signIn(email, password, onResult)
    }

    fun signUp(email: String, password: String, onResult: (Boolean) -> Unit) {
        authManager.signUp(email, password, onResult)
    }

    fun signOut() {
        authManager.signOut()
    }

    fun getCurrentUser() = authManager.currentUser()
}
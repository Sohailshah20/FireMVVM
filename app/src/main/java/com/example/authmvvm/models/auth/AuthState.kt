package com.example.authmvvm.models.auth

sealed class AuthState  {

    object Success : AuthState()
    data class Error(val message: String) : AuthState()
    object Loading : AuthState()
    object Empty : AuthState()

}
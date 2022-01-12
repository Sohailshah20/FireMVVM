package com.example.authmvvm.auth.Authmodels

sealed class AuthEvent{

//    object Success: AuthEvent()

//    data class EnteredMobileNumber(val number: String): RegisterEvent()
//
//    data class EnteredEmail(val email: String): RegisterEvent()
//
//    data class EnteredPassword(val password: String): RegisterEvent()

    object Auth : AuthEvent()
}

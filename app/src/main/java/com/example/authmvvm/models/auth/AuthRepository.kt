package com.example.authmvvm.models.auth

import com.example.authmvvm.util.Response
import com.google.firebase.auth.AuthResult

interface AuthRepository {

    suspend fun register(number: String, email: String, password: String): Response<AuthResult>

    suspend fun login(email: String, password: String): Response<AuthResult>
}
package com.example.authmvvm.auth.Authmodels

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun register(number: String, email: String, password: String): Flow<AuthResult>

//    suspend fun login(email: String, password: String): Resource<AuthResult>
}
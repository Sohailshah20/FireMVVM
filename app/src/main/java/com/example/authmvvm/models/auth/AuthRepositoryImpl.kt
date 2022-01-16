package com.example.authmvvm.models.auth

import com.example.authmvvm.models.data.User
import com.example.authmvvm.util.Response
import com.example.authmvvm.util.safeCall
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepositoryImpl: AuthRepository {

    val auth = FirebaseAuth.getInstance()
    private val users = FirebaseFirestore.getInstance().collection("users")

    override suspend fun register(
        number: String,
        email: String,
        password: String
    ): Response<AuthResult> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                val uid = result.user?.uid!!
                val user = User(uid, number, email)
                users.document(uid).set(user).await()
                Response.Success(result)
            }
        }

    }

    override suspend fun login(
        email: String,
        password: String
    ): Response<AuthResult> {
        return withContext(Dispatchers.IO) {
            safeCall {
                val result = auth.signInWithEmailAndPassword(email, password).await()
                Response.Success(result)
            }
        }

    }
}
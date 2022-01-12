package com.example.authmvvm.auth.Authmodels

import com.example.authmvvm.others.Response
import com.example.authmvvm.others.safeCall
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepositoryImpl: AuthRepository {

    val auth = FirebaseAuth.getInstance()
    val users = FirebaseFirestore.getInstance().collection("users")

    override suspend fun register(
        number: String,
        email: String,
        password: String
    ): Response<AuthResult> {
        return withContext(Dispatchers.IO){
            safeCall {
                 val result = auth.createUserWithEmailAndPassword(email, password).await()
                 val uid = result.user?.uid!!
                 val user = User(uid, number, email)
                users.document(uid).set(user).await()
                Response.Success(result)
            }
        }

    }

//    override suspend fun login(email: String, password: String): Resource<AuthResult> {
//
//    }
}
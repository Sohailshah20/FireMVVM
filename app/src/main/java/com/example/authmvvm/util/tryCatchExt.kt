package com.example.authmvvm.util

inline fun <T> safeCall(action:() -> Response<T>) : Response<T> {
    return try {
        action()
    }catch(e: Exception){
        Response.Error(e.message ?: "Unknown error occured")
    }

}
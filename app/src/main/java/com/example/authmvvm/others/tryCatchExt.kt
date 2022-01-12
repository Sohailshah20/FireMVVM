package com.example.authmvvm.others

inline fun <T> safeCall(action:() -> Response<T>) : Response<T> {
    return try {
        action()
    }catch(e: Exception){
        Response.Error(e.message ?: "Unknown error occured")
    }

}
package com.example.authmvvm.others

class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if(!hasBeenHandled){
            hasBeenHandled = true
            content
        }else null
    }
}
package com.example.authmvvm.models.auth

import androidx.lifecycle.*
import com.example.authmvvm.util.Response
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository

) : ViewModel() {

    private val _authState = MutableStateFlow<Response<AuthResult>>(Response.Error("nothing"))
    val authState : StateFlow<Response<AuthResult>> = _authState


//    fun handleEvent(authenticationEvent: AuthEvent) {
//        when (authenticationEvent) {
//
//                is AuthEvent.EnteredEmail ->{
//                    updateEmail(authenticationEvent.email)
//                }
////                is AuthEvent.Register ->{
////                    register()
////                }
////            }
//        }
//    }

//    private fun updateEmail(email: String){
//        authState.value = authState.value.
//    }

//    private fun updatePassword(password: String){
//        val requirements = mutableListOf<PasswordRequirements>()
//        if(password.length > 7){
//            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
//        }
//        if (password.any{it.isUpperCase()}){
//            requirements.add(PasswordRequirements.CAPITAL_LETTER)
//        }
//        if(password.any { it.isDigit() }){
//            requirements.add(PasswordRequirements.NUMBER)
//        }
//        uiState.value = uiState.value.copy(password = password)
//    }

     fun register(
         number: String,
         email: String,
         password: String
     ){
        viewModelScope.launch(Dispatchers.Main){
            val result = repository.register(number, email, password)
                _authState.value = result
            }

        }

    fun login(
        email: String,
        password: String
    ){
        viewModelScope.launch(Dispatchers.Main) {
            val result = repository.login(email, password)
            _authState.value = result
        }
    }



}
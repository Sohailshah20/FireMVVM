package com.example.authmvvm.auth.Authmodels

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Empty)
    val authState : StateFlow<AuthState> = _authState


    fun handleEvent(authenticationEvent: AuthEvent) {
        when (authenticationEvent) {
//            is AuthenticationEvent.Authenticate ->{
//                Register()
//            }
//            is AuthenticationEvent.EmailChanged ->{
//                updateEmail(authenticationEvent.emailAddress)
//            }
//            is AuthenticationEvent.PasswordChanged ->{
//                updatePassword(authenticationEvent.password)
//            }
            is AuthEvent.Auth -> {
                Register()
            }
        }
    }

//    private fun updateEmail(email: String){
//        uiState.value = uiState.value.copy(email = email)
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

    private fun Register(){

        viewModelScope.launch(Dispatchers.IO){
            val result = repository.register(email = )

//
            }

        }



}
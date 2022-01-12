package com.example.authmvvm.auth.data

import com.example.authmvvm.auth.PasswordRequirements

data class AuthenticationState(
    //User Input
    val email : String? = null,
    val password : String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    //change between authmode is asynchoronous(i.e wait for 1 for 2 to complete
    //so we add loading state to indicate
    val isLoading: Boolean = false,
    //catch error on result
    val error : String? = null
){
    fun isFormValid(): Boolean{
        return password?.isEmpty() == true &&
                email?.isEmpty() == true &&
                (passwordRequirements.containsAll(PasswordRequirements.values().toList()))
    }
}
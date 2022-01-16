package com.example.authmvvm.models.auth

import com.example.authmvvm.models.NumberRequirements
import com.example.authmvvm.models.PasswordRequirements

data class RegisterState(
    val number: String? = null,
    val email : String? = null,
    val password : String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val numberRequirements: List<NumberRequirements> = emptyList(),
    //change between authmode is asynchoronous(i.e wait for 1 for 2 to complete
    //so we add loading state to indicate
    val isLoading: Boolean = false,
    //catch error on result
    val error : String? = null
){
    fun isFormValid(): Boolean{
        return password?.isEmpty() == true &&
                number?.isEmpty() == true &&
                email?.isEmpty() == true &&
                (passwordRequirements.containsAll(PasswordRequirements.values().toList())) &&
                (numberRequirements).containsAll(NumberRequirements.values().toList())

    }
}


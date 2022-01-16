package com.example.authmvvm.models

import androidx.annotation.StringRes
import com.example.authmvvm.R

enum class PasswordRequirements(
    //each requirement as label inform of string resource
    @StringRes val label: Int
) {
    //Password validation
    CAPITAL_LETTER(R.string.password_req_capital),
    NUMBER(R.string.password_req_digit),
    EIGHT_CHARACTERS(R.string.password_req_characters)
}
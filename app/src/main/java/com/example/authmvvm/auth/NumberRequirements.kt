package com.example.authmvvm.auth

import androidx.annotation.StringRes
import com.example.authmvvm.R

enum class NumberRequirements (
        @StringRes val label: Int
    ) {
        //mobile number validation
        TEN_CHARACTERS(R.string.number_req)
    }
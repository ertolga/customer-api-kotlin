package com.tolga.customerapikotlin.dto

data class CustomerRequest(
    val fullName: String,
    val email: String,
    val phone: String,
    val password: String
)

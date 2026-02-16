package com.tolga.customerapikotlin.dto

data class CustomerResponse(
    val id: Long?,
    val fullName: String,
    val email: String,
    val phone: String,
    val nlIban: String?,
    val trIban: String?
)


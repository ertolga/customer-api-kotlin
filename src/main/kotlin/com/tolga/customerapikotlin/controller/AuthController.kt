package com.tolga.customerapikotlin.controller

import com.tolga.customerapikotlin.dto.LoginRequest
import com.tolga.customerapikotlin.dto.LoginResponse
import com.tolga.customerapikotlin.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val service: CustomerService
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): LoginResponse {
        val customer = service.findByEmail(request.email)
            ?: throw RuntimeException("User not found")

        if (customer.password != request.password) {
            throw RuntimeException("Invalid password")
        }

        return LoginResponse(
            id = customer.id,
            fullName = customer.fullName,
            email = customer.email
        )
    }
}

package com.tolga.customerapikotlin.controller

import com.tolga.customerapikotlin.dto.CustomerRequest
import com.tolga.customerapikotlin.dto.CustomerResponse
import com.tolga.customerapikotlin.dto.LoginRequest
import com.tolga.customerapikotlin.dto.UpdateIbanRequest
import com.tolga.customerapikotlin.model.Customer
import com.tolga.customerapikotlin.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    private val service: CustomerService
) {

    @PostMapping("/create")
    fun create(@RequestBody request: CustomerRequest): CustomerResponse {
        val customer = Customer(
            fullName = request.fullName,
            email = request.email,
            phone = request.phone,
            password = request.password
        )

        val saved = service.save(customer)

        return CustomerResponse(
            id = saved.id,
            fullName = saved.fullName,
            email = saved.email,
            phone = saved.phone
        )
    }

    @GetMapping
    fun getAll(): List<Customer> = service.findAll()

    @PutMapping("/{id}/iban")
    fun updateIban(
        @PathVariable id: Long,
        @RequestBody request: UpdateIbanRequest
    ): CustomerResponse {
        val customer = service.findById(id)
            ?: throw RuntimeException("Customer not found")

        customer.nlIban = request.iban
        val saved = service.save(customer)

        return CustomerResponse(
            id = saved.id,
            fullName = saved.fullName,
            email = saved.email,
            phone = saved.phone
        )
    }


    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): CustomerResponse {
        val customer = service.findByEmail(request.email)
            ?: throw RuntimeException("User not found")

        if (customer.password != request.password) {
            throw RuntimeException("Invalid password")
        }

        return CustomerResponse(
            id = customer.id,
            fullName = customer.fullName,
            email = customer.email,
            phone = customer.phone
        )
    }
}

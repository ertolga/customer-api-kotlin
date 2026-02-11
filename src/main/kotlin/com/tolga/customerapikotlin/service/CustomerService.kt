package com.tolga.customerapikotlin.service

import com.tolga.customerapikotlin.model.Customer
import com.tolga.customerapikotlin.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val repository: CustomerRepository
) {

    fun findByEmail(email: String): Customer? =
        repository.findByEmail(email)

    fun save(customer: Customer): Customer =
        repository.save(customer)

    fun findAll(): List<Customer> =
        repository.findAll()

    fun findById(id: Long): Customer =
        repository.findById(id).orElseThrow { RuntimeException("Customer not found") }
}

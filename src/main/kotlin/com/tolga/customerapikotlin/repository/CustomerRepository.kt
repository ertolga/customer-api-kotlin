package com.tolga.customerapikotlin.repository

import com.tolga.customerapikotlin.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByEmail(email: String): Customer?
}

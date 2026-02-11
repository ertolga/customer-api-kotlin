package com.tolga.customerapikotlin.model

import jakarta.persistence.*

@Entity
@Table(name = "customer")
open class Customer(

    @Column(nullable = false)
    open var fullName: String,

    @Column(nullable = false, unique = true)
    open var email: String,

    @Column(nullable = false)
    open var phone: String,

    @Column(nullable = false)
    open var password: String,

    @Column(name = "nl_iban")
    open var nlIban: String? = null

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null

    // JPA için boş constructor
    protected constructor() : this(
        fullName = "",
        email = "",
        phone = "",
        password = ""
    )
}

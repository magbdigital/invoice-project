package com.example.invoiceproject.entity

import jakarta.persistence.*

@Entity
@Table(name = "product")
class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var description: String? = null
    var brand: String? = null
    var price: Double? = null
    var stock: Long? = null
}
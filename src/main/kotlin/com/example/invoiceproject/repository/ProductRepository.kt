package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository:JpaRepository<Product, Long?> {

  fun findById (id:Long?):Product?
}
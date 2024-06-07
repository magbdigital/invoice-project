package com.example.invoiceproject.repository

import com.example.invoiceproject.dto.InvoiceDto
import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface InvoiceRepository:JpaRepository<Invoice, Long?> {

  fun findById (id:Long?):Invoice

  @Query(nativeQuery = true)
  fun filterTotal (value:Double):List<Invoice>

  @Query(nativeQuery = true)
  fun getInvoiceReport (): List<Array<out Any>>

  fun findByClientId(clientId: Long?): List<Invoice>
}
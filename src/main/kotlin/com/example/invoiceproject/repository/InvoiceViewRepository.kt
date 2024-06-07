package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.entity.InvoiceView
import com.example.invoiceproject.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface InvoiceViewRepository:JpaRepository<InvoiceView, Long?> {

  fun findById (id:Long?):InvoiceView

}
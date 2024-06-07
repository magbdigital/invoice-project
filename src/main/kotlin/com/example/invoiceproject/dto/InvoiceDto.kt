package com.example.invoiceproject.dto

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Date

data class InvoiceDto(
    val id: Integer,
    val createAt: Date,
    val total: BigDecimal,
    val fullname: String,
    val address: String
)
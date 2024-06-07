package com.example.invoiceproject.controller

import com.example.invoiceproject.dto.InvoiceDto
import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.entity.InvoiceView
import com.example.invoiceproject.repository.InvoiceRepository
import com.example.invoiceproject.service.ClientService
import com.example.invoiceproject.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoices")  //va despues de localhost:8080/invoice  es laruta
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping()
    fun list (): List<Invoice> {
      return invoiceService.list()
    }

    @PostMapping()
    fun save (@RequestBody invoice:Invoice): Invoice {
        return invoiceService.save(invoice)
    }

    @GetMapping("/with-client")
    fun listView (): List<InvoiceView> {
        return invoiceService.listView()
    }

    @GetMapping("/report")
    fun listReport (): List<InvoiceDto> {
        return invoiceService.listInvoiceReport()
    }

    //Desde postman: localhost:8081/invoices/1/get-total
    @GetMapping("/{value}/get-total")
    fun getTotal (@PathVariable value: Double):List<Invoice>{
        return invoiceService.getTotal(value)
    }




}
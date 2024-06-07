package com.example.invoiceproject.service

import com.example.invoiceproject.dto.InvoiceDto
import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.entity.InvoiceView
import com.example.invoiceproject.entity.Product
import com.example.invoiceproject.repository.ClientRepository
import com.example.invoiceproject.repository.InvoiceRepository
import com.example.invoiceproject.repository.InvoiceViewRepository
import com.example.invoiceproject.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.*

@Service //anotacion
class InvoiceService {
    @Autowired  // Inyectar un obj de tipo CLientR desde
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired  //
    lateinit var invoiceViewRepository: InvoiceViewRepository

    fun list ():List<Invoice>{
        return invoiceRepository.findAll()
    }
    fun save (invoice: Invoice):Invoice{
       // val invoices = invoiceRepository.findByClienteId(invoice.client.id)
        return invoiceRepository.save(invoice)
    }


    fun listView():List<InvoiceView>{
        return invoiceViewRepository.findAll()
    }

    fun listInvoiceReport():List<InvoiceDto>{

        val results: List<Array<out Any>> = invoiceRepository.getInvoiceReport()
        return results.map { result ->
            InvoiceDto(
                result[0] as Integer,
                result[1] as Date,
                result[2] as BigDecimal,
                result[3] as String,
                result[4] as String? ?: "" //en caso de nulo devuelve vacio
            )
        }
    }

    fun getTotal (value:Double): List<Invoice> {
        return invoiceRepository.filterTotal(value) //select * from Client --Jpa repostprty
    }

}
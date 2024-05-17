package com.example.invoiceproject.controller

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.repository.InvoiceRepository
import com.example.invoiceproject.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")  //va despues de localhost:8080/invoice  es laruta
class ClientController {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping//Esta anotacion relaciona este metodo con GET de HTTP
    fun list(): List<Client> {
        val list = clientService.list()
        return list
    }
    @PostMapping
    fun save(@RequestBody client: Client):Client {
        return clientService.save(client) //llamando
    }
}
package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service

@Service //anotacion
class ClientService {
    @Autowired  // Injectar un obj de tipo CLientR desde
    lateinit var clientRepository: ClientRepository

    fun list (client:Client): List<Client> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            // Filtro por fullname, agrega la siguiente linea para filtrar por otro campo
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        val example = Example.of(client, matcher)
        val pageResponse = clientRepository.findAll(example)
        return pageResponse
    }

    fun save(client: Client):Client{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("description"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
          return clientRepository.save(client) // insert into ... JPaRepository
    }


    fun validateNui (nui:String?):Boolean?{


        return null
    }
}
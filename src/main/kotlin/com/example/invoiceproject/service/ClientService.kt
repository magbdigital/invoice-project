package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service //anotacion
class ClientService {
    @Autowired  // Injectar un obj de tipo CLientR desde
    lateinit var clientRepository: ClientRepository

    fun list (): List<Client> {
        return clientRepository.findAll() //select * from Client --Jpa repostprty
    }

    fun save(client: Client):Client{
          return clientRepository.save(client) // insert into ... JPaRepository
    }


    fun validateNui (nui:String?):Boolean?{


        return null
    }
}
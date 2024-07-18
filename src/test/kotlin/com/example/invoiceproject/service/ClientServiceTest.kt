package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Invoice
import com.example.invoiceproject.repository.ClientRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.io.File

@ExtendWith(SpringExtension::class)
@SpringBootTest(properties = [
    "spring.main.web-application-type=none",
    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration"
])
class ClientServiceTest {

    @InjectMocks
    lateinit var clientService: ClientService //clae que se va a probar

    @Mock   //objeto simulado
    lateinit var clientRepository: ClientRepository

    //Lee el archivo desde l ruta
    val jsonString = File("./src/test/resources/client/newClient.json").readText(Charsets.UTF_8)
    // convierte en objeto de tipo Client
    val clientMock = Gson().fromJson(jsonString, Client::class.java)

    @Test
    fun saveWhenClientIsCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        Assertions.assertEquals(response.id, clientMock.id)
    }

    @Test
    fun saveWhenNuiClientIsCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNui(clientMock.nui)
        Assertions.assertEquals(true,response)
    }
}
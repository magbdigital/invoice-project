package com.example.invoiceproject.controller

import com.example.invoiceproject.service.MqttPublisherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mqtt")
class MqttController {
    @Autowired
    private val mqttPublisherService: MqttPublisherService? = null

    @PostMapping("/publish")
    fun publishMessage(@RequestParam topic: String, @RequestParam message: String?): String {
        try {
            mqttPublisherService?.publish(topic, message!!)
            return "Mensaje enviado a $topic"
        } catch (e: Exception) {
            return "Error al enviar mensaje: " + e.message
        }
    }
}
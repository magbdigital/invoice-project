package com.example.invoiceproject.service

import org.eclipse.paho.client.mqttv3.IMqttClient
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MqttPublisherService {

    @Autowired
    private val mqttClient: IMqttClient? = null

    @Throws(Exception::class)
    fun publish(topic: String?, message: String) {
        check(mqttClient!!.isConnected) { "Cliente MQTT no conectado" }

        val mqttMessage = MqttMessage()
        mqttMessage.payload = message.toByteArray()
        mqttMessage.qos = 1 // QoS 1 (al menos una vez)
        mqttMessage.isRetained = false

        mqttClient!!.publish(topic, mqttMessage)
    }
}
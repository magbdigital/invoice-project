package com.example.invoiceproject.service

import org.eclipse.paho.client.mqttv3.IMqttClient
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MqttConfig {

    private val MQTT_BROKER: String = "tcp://localhost:1883"
    private val CLIENT_ID: String = "spring-boot-client"
    private val TOPIC = "test/topic"

    @Bean
    @Throws(Exception::class)
    fun mqttClient(): IMqttClient {
        val client: IMqttClient = MqttClient(MQTT_BROKER, CLIENT_ID, MemoryPersistence())
        val options = MqttConnectOptions().apply {
            isAutomaticReconnect = true
            isCleanSession = true
            connectionTimeout = 10
        }

        client.connect(options)
        client.subscribe(TOPIC, 1)
        client.setCallback(MqttListener())

        return client
    }
}
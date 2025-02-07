package com.example.invoiceproject.service

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

class MqttListener: MqttCallback {
    override fun connectionLost(cause: Throwable?) {
        println("Connection lost: ${cause?.message}")
    }

    override fun messageArrived(topic: String?, message: MqttMessage?) {
        // Aquí se maneja el mensaje recibido
        val msg = message?.payload?.toString(Charsets.UTF_8) ?: "No message"
        println("Received message from topic $topic: $msg")
    }

    override fun deliveryComplete(token: IMqttDeliveryToken?) {
        // Este método no es necesario para un subscriber, pero debe implementarse
    }
}
package com.gloeats.payment_kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentStatusConsumer {
    @KafkaListener(topics = "${app.kafka.topic.payment-status}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        System.out.println("Consumed message: " + message);
    }
}

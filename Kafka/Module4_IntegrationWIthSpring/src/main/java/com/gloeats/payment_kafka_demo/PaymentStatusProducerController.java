package com.gloeats.payment_kafka_demo;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentStatusProducerController {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final String topic;

    public PaymentStatusProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                           @Value("${app.kafka.topic.payment-status}")String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishPaymentStatus(@RequestBody PaymentStatusRequest req){
        String message = String.format("PaymentID: %s, Status: %s", req.getPaymentId(), req.getStatus());
        kafkaTemplate.send(topic, req.getPaymentId(), message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }

    @PostMapping("/publish-inline")
    public ResponseEntity<String> publishInline(@RequestParam String paymentId, @RequestParam String status){
        String message = String.format("PaymentID: %s, Status: %s", paymentId, status);
        kafkaTemplate.send(topic, paymentId, message);
        return ResponseEntity.ok("Message sent to Kafka: " + message);
    }


}

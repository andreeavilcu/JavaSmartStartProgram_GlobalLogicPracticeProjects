package com.techlogics.parking.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WarningConsumer {
    @KafkaListener(topics = "${app.kafka.topic.warning}", groupId = "warning-group")
    public void listeningWarning(String message){
        System.out.printf("WARNING low availability: %s%n", message);
    }
}

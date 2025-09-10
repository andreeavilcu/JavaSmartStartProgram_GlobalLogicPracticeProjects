package com.techlogics.parking.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ParkingProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;
    private final Random random = new Random();

    private final String[] PARKING_AREAS = {"A1", "A2", "B1", "B2", "C1"};

    public ParkingProducerService(KafkaTemplate<String, String> kafkaTemplate,
                                  @Value("${app.kafka.topic.avl}")String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;

    }

    @Scheduled(fixedRate = 3000)
    public void publishRandomAvailability(){
        String area = PARKING_AREAS[random.nextInt(PARKING_AREAS.length)];
        int available = random.nextInt(51); // 0..50
        String message = String.valueOf(available);

        // key = area, value = available count (string)
        kafkaTemplate.send(topic, area, message);
        System.out.printf("Produced -> key:%s value:%s%n", area, message);
    }

}


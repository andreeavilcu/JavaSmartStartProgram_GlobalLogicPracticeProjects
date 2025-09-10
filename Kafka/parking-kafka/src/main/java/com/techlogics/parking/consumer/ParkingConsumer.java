package com.techlogics.parking.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ParkingConsumer {
    @KafkaListener(topics = "${app.kafka.topic.avl}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, String> record){
        long timestamp = record.timestamp();
        long offset = record.offset();
        int partition = record.partition();
        String key = record.key();
        String value = record.value();

        System.out.printf("Consumed metadata -> timestamp:%d partition:%d offset:%d key:%s value:%s%n",
                timestamp, partition, offset, key, value);
    }
}

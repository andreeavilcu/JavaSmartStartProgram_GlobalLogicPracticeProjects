package org.example;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class OrderProducer {
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC = "OrderUpdates";
    private static final String[] STATUSES = {"Order Placed", "Order Confirmed", "Order Delivered"};
    private static final String[] RESTAURANTS = {"Restaurant1", "Restaurant2", "Restaurant3"};
    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        for (int orderId = 101; orderId <= 105; orderId++){
            String status = STATUSES[random.nextInt(STATUSES.length)];
            String restaurant = RESTAURANTS[random.nextInt(RESTAURANTS.length)];
            String message = "OrderID: " + orderId + ", Status: " + status;

            ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, restaurant, message);
            producer.send(record);
            System.out.println("Sent: " + message + " to " + restaurant);

            Thread.sleep(1000);
        }

        producer.close();
    }
}

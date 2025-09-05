package org.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class PaymentStatusProducer {
    private static final String TOPIC_NAME = "PaymentStatus";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";

    public static void main(String[] args){
        //Producer properties
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        try{
            for (int i = 0; i <= 5; i++){
                String key = "Payment" + i;
                String value = "PaymentID: " + i + ", Status: SUCCESS";

                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key, value);

                RecordMetadata metadata = producer.send(record).get();
                System.out.printf("Sent record(key=%s value=%s) to partition=%d offset=%d%n",
                        key, value, metadata.partition(), metadata.offset());
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}

package com.gloeats.payment_kafka_demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${app.kafka.topic.payment-status}")
    private String paymentTopic;

    @Bean
    public NewTopic paymentStatusTopic() {
        return TopicBuilder.name(paymentTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}

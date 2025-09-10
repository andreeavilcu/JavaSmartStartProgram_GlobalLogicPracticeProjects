package com.techlogics.parking.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("$app.kafka.topic.avl")
    private String avlTopic;

    @Value("${app.kafka.topic.warning}")
    private String warningTopic;

    @Bean
    public NewTopic liveAvlFreeSpace(){
        return TopicBuilder.name(avlTopic)
                .partitions(3)
                .replicas(1)
                .build();

    }

    @Bean
    public NewTopic liveAvblWarning() {
        return TopicBuilder.name(warningTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}

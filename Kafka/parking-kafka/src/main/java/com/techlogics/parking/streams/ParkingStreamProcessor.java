package com.techlogics.parking.streams;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ParkingStreamProcessor {
    @Value("${app.kafka.topic.avl}")
    private String avlTopic;

    @Value("${app.kafka.topic.warning}")
    private String warningTopic;

    @Bean
    public KStream<String, String> kStream(StreamsBuilder builder){
        KStream<String, String> stream = builder.stream(avlTopic, Consumed.with(Serdes.String(), Serdes.String()));

        stream.
                mapValues( v -> {
                    return v;

                })
                .filter((key, value) -> {
                    try {
                        int val = Integer.parseInt(value);
                        return val < 10;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .to(warningTopic, Produced.with(Serdes.String(), Serdes.String()));

        stream
                .mapValues(v -> {
                    return v;
                })
                .toTable(Materialized.as("parking-store"));

        return stream;
    }
}

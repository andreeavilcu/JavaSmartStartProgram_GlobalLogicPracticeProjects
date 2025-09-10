package com.techlogics.parking.rest;


import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.streams.KafkaStreamsInteractiveQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ParkingQueryController {
    @Value("${app.kafka.topic.avl}")
    private String avlTopic;

    @Autowired
    private KafkaStreamsInteractiveQueryService interactiveQueryService;

    @Autowired
    private KafkaStreams kafkaStreams;

    @GetMapping("/{area}")
    public String getAvailability(@PathVariable String area) {
        ReadOnlyKeyValueStore<String, String> store =
                kafkaStreams.store(
                        StoreQueryParameters.fromNameAndType(
                                "parking-space-store",
                                QueryableStoreTypes.keyValueStore()
                        )
                );
        if (store == null) {
            return "State store not ready";
        }
        String val = store.get(area);
        if (val == null) {
            return "No data for area " + area;
        }
        return val;
    }

}

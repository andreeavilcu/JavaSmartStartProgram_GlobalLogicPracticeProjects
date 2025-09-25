package com.example.ecommerce_order_system.event;

import com.example.ecommerce_order_system.model.Order;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderEventProducer {
    private static final String TOPIC = "order-events";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendOrderEvent(Order order){
        try{
            Map<String, Object> orderEvent = new HashMap<>();
            orderEvent.put("orderId", order.getOrderId());
            orderEvent.put("customerId", order.getCustomer().getCustomerId());
            orderEvent.put("customerName", order.getCustomer().getName());
            orderEvent.put("orderDate", order.getOrderDate().toString());
            orderEvent.put("totalAmount", order.getTotalAmount());
            String message = objectMapper.writeValueAsString(orderEvent);

            kafkaTemplate.send(TOPIC, message);
            System.out.println("Order event sent to Kafka: " + message);
        } catch (JsonProcessingException e) {
            System.err.println("Error serializing order event: " + e.getMessage());
        }
    }
}

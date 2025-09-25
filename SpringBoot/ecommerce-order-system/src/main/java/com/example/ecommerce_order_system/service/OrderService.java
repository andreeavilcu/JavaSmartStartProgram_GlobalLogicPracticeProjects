package com.example.ecommerce_order_system.service;

import com.example.ecommerce_order_system.dto.OrderDTO;
import com.example.ecommerce_order_system.event.OrderEventProducer;
import com.example.ecommerce_order_system.model.*;
import com.example.ecommerce_order_system.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderEventProducer orderEventProducer;

    @Transactional
    public Order createOrder(OrderDTO orderDTO){
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = new Order(customer);
        List<OrderItem> orderItems = new ArrayList<>();

        BigDecimal totalAmount = BigDecimal.ZERO;

        for(OrderDTO.OrderItemDTO itemDTO : orderDTO.getOrderItems()){
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setUnitPrice(product.getPrice());

            orderItems.add(orderItem);

            BigDecimal itemTotal = product.getPrice().multiply(new BigDecimal(itemDTO.getQuantity()));
            totalAmount = totalAmount.add(itemTotal);
        }

        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);

        // Salvează comanda
        Order savedOrder = orderRepository.save(order);

        orderEventProducer.sendOrderEvent(savedOrder);

        return savedOrder;
    }

    public Optional<Order> getOrderById(Long orderId){
        return orderRepository.findByIdWithDetails(orderId);
    }

    public List<Order> getOrdersByCustomerId(Long customerId){
        return orderRepository.findByCustomerCustomerId(customerId);
    }
}

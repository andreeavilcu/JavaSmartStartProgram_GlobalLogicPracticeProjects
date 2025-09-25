package com.example.ecommerce_order_system.repository;

import com.example.ecommerce_order_system.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.customer WHERE o.orderId = :orderId")
    Optional<Order> findByIdWithCustomer(@Param("orderId") Long orderId);

    @Query("SELECT o FROM Order o JOIN FETCH o.customer JOIN FETCH o.orderItems oi JOIN FETCH oi.product WHERE o.orderId = :orderId")
    Optional<Order> findByIdWithDetails(@Param("orderId") Long orderId);

    List<Order> findByCustomerCustomerId(Long customerId);

}

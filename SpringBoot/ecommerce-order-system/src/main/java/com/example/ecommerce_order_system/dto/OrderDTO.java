package com.example.ecommerce_order_system.dto;

import java.util.List;

public class OrderDTO {
    private Long customerId;
    private List<OrderItemDTO> orderItems;

    public OrderDTO() {}

    public OrderDTO(Long customerId, List<OrderItemDTO> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }


    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;

        public OrderItemDTO() {}


        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public OrderItemDTO(Long productId, Integer quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }


    }

}

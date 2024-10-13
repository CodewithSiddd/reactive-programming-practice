package com.sid.reactive_programming_practice.intro02.entity;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class CustomerOrder {

    @Id
    private UUID orderId;
    private Integer customerId;
    private Integer productId;
    private Integer amount;
    private Integer orderDate;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Integer orderDate) {
        this.orderDate = orderDate;
    }

}

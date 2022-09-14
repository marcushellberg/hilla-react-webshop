package com.example.application.data.dto;

import com.example.application.data.entity.Order;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO extends AbstractDTO {
    @NotNull
    private int orderNumber;

    @NotNull
    private LocalDateTime added;

    private CustomerDTO customer;

    private String fulfillment;

    private String paymentStatus;

    private BigDecimal total;

    private String currency;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this(order, true);
    }

    public OrderDTO(Order order, boolean deep) {
        this.setId(order.getId());
        this.added = order.getAdded();
        this.currency = order.getCurrency();
        this.orderNumber = order.getOrderNumber();
        this.total = order.getTotal();
        this.fulfillment = order.getFulfillment();
        this.paymentStatus = order.getPaymentStatus();

        if (deep) {
            this.customer = new CustomerDTO(order.getCustomer(), false);
        }
    }

    @Override
    public String toString() {
        return String.format("#%d by %s", orderNumber, customer);
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public String getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(String fulfillment) {
        this.fulfillment = fulfillment;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

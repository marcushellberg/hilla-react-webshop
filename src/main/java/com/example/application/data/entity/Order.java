package com.example.application.data.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order extends AbstractEntity {
    @NotNull
    private LocalDateTime added;

    @ManyToOne
    private Customer customer;

    private String fullfillment;

    private String paymentStatus;

    private BigDecimal total;

    private String currency;

    @Override
    public String toString() {
        return getId() + " by " + customer;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getFullfillment() {
        return fullfillment;
    }

    public void setFullfillment(String fullfillment) {
        this.fullfillment = fullfillment;
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

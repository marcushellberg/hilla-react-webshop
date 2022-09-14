package com.example.application.data.dto;

import com.example.application.data.entity.Customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTO extends AbstractDTO {
    @NotNull
    private LocalDateTime added;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private List<OrderDTO> orders;

    private int orderCount;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this(customer, true);
    }

    public CustomerDTO(Customer customer, boolean deep) {
        this.setId(customer.getId());
        this.added = customer.getAdded();
        this.name = customer.getName();
        this.email = customer.getEmail();
        var orders = customer.getOrders();
        orderCount = orders.size();

        if (deep) {
            this.orders = orders.stream().map(order -> new OrderDTO(order, false)).collect(Collectors.toList());
        } else {
            this.orders = List.of();
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;

        if (orders != null) {
            orderCount = orders.size();
        }
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }
}

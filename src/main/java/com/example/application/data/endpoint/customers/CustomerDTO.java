package com.example.application.data.endpoint.customers;

import com.example.application.data.entity.Customer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public class CustomerDTO {

    private UUID id;
    @NotNull
    private LocalDateTime added;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    private int orders;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.added = customer.getAdded();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.orders = customer.getOrders().size();
    }

    public CustomerDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }
}

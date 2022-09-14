package com.example.application.data.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Customer extends AbstractEntity {
    @NotNull
    private LocalDateTime added;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @OneToMany
    private List<Order> orders;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

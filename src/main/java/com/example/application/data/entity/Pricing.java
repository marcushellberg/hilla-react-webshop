package com.example.application.data.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Pricing extends AbstractEntity {
    @NotBlank
    private String name;

    private String description;

    private String status;

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

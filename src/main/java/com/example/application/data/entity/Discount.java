package com.example.application.data.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Discount extends AbstractEntity {
    @NotBlank
    private String code;

    private String description;

    private int amount;

    private String status;

    private int redemptions;

    @Override
    public String toString() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRedemptions() {
        return redemptions;
    }

    public void setRedemptions(int redemptions) {
        this.redemptions = redemptions;
    }
}

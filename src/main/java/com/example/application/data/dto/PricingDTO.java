package com.example.application.data.dto;

import com.example.application.data.entity.Pricing;

import javax.validation.constraints.NotBlank;

public class PricingDTO extends AbstractDTO {
    @NotBlank
    private String name;

    private String description;

    private String status;

    public PricingDTO() {
    }

    public PricingDTO(Pricing pricing) {
        this.setId(pricing.getId());
        this.description = pricing.getDescription();
        this.name = pricing.getName();
        this.status = pricing.getStatus();
    }

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

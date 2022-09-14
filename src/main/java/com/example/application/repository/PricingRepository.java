package com.example.application.repository;

import com.example.application.data.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PricingRepository extends JpaRepository<Pricing, UUID> {
}

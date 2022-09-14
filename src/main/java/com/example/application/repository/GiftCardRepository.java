package com.example.application.repository;

import com.example.application.data.entity.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GiftCardRepository extends JpaRepository<GiftCard, UUID> {
}

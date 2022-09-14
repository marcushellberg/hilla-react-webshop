package com.example.application.data.endpoint;

import com.example.application.data.entity.Order;
import com.example.application.repository.CustomerRepository;
import com.example.application.repository.DiscountRepository;
import com.example.application.repository.GiftCardRepository;
import com.example.application.repository.OrderRepository;
import com.example.application.repository.PricingRepository;
import dev.hilla.Endpoint;

import java.util.List;

@Endpoint
public class GiftCardsEndpoint {
    private final GiftCardRepository giftCardRepository;

    public GiftCardsEndpoint(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
    }
}

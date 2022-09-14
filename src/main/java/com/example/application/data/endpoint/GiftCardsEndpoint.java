package com.example.application.data.endpoint;

import com.example.application.repository.GiftCardRepository;
import dev.hilla.Endpoint;

@Endpoint
public class GiftCardsEndpoint {
    private final GiftCardRepository giftCardRepository;

    public GiftCardsEndpoint(GiftCardRepository giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
    }
}

package com.example.application.data.endpoint;

import com.example.application.repository.DiscountRepository;
import dev.hilla.Endpoint;

@Endpoint
public class DiscountsEndpoint {
    private final DiscountRepository discountRepository;

    public DiscountsEndpoint(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }
}

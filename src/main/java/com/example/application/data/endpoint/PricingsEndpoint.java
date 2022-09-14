package com.example.application.data.endpoint;

import com.example.application.repository.PricingRepository;
import dev.hilla.Endpoint;

@Endpoint
public class PricingsEndpoint {
    private final PricingRepository pricingRepository;

    public PricingsEndpoint(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }
}

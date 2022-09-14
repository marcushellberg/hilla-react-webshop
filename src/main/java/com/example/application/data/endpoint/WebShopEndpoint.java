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
public class WebShopEndpoint {
    private final CustomerRepository customerRepository;

    private final DiscountRepository discountRepository;

    private final GiftCardRepository giftCardRepository;

    private final OrderRepository orderRepository;

    private final PricingRepository pricingRepository;

    public WebShopEndpoint(CustomerRepository customerRepository, DiscountRepository discountRepository,
                           GiftCardRepository giftCardRepository, OrderRepository orderRepository,
                           PricingRepository pricingRepository) {
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.giftCardRepository = giftCardRepository;
        this.orderRepository = orderRepository;
        this.pricingRepository = pricingRepository;
    }

    // CUSTOMERS

    // DISCOUNTS

    // GIFT CARDS

    // ORDERS

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    // PRICING
}

package com.example.application.data.endpoint;

import com.example.application.data.entity.Order;
import com.example.application.repository.CustomerRepository;
import com.example.application.repository.DiscountRepository;
import com.example.application.repository.GiftCardRepository;
import com.example.application.repository.OrderRepository;
import com.example.application.repository.PricingRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

import java.util.List;

@Endpoint
public class OrdersEndpoint {

    private final OrderRepository orderRepository;

    public OrdersEndpoint(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @AnonymousAllowed
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}

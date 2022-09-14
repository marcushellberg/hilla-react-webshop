package com.example.application.data.endpoint;

import com.example.application.data.dto.OrderDTO;
import com.example.application.repository.OrderRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Endpoint
@AnonymousAllowed
public class OrdersEndpoint {

    private final OrderRepository orderRepository;

    public OrdersEndpoint(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getOrders() {
        return orderRepository.findAll().stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Nullable
    public Optional<OrderDTO> getOrderById(UUID id) {
        return orderRepository.findById(id).map(OrderDTO::new);
    }
}

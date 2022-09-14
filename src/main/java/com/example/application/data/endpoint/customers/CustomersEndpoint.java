package com.example.application.data.endpoint.customers;

import com.example.application.data.entity.Customer;
import com.example.application.repository.CustomerRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Endpoint
@AnonymousAllowed
public class CustomersEndpoint {
    private final CustomerRepository customerRepository;

    public CustomersEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Nonnull
    public List<@Nonnull CustomerDTO> getCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<Customer> findCustomerById(UUID id) {
        return customerRepository.findById(id);
    }
}

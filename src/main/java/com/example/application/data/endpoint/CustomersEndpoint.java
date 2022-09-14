package com.example.application.data.endpoint;

import com.example.application.data.dto.CustomerDTO;
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
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDTO(customer, false))
                .collect(Collectors.toList());
    }

    public Optional<CustomerDTO> findCustomerById(UUID id) {
        return customerRepository.findById(id).map(CustomerDTO::new);
    }
}

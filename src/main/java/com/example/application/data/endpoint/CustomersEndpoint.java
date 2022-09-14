package com.example.application.data.endpoint;

import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Order;
import com.example.application.repository.CustomerRepository;
import com.example.application.repository.DiscountRepository;
import com.example.application.repository.GiftCardRepository;
import com.example.application.repository.OrderRepository;
import com.example.application.repository.PricingRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Endpoint
@AnonymousAllowed
public class CustomersEndpoint {
    private final CustomerRepository customerRepository;

    public static class CustomerDTO {
        @NotNull
        private LocalDateTime added;

        @NotBlank
        private String name;

        @NotBlank
        private String email;

        private int orders;
        public CustomerDTO(Customer customer) {
            this.added = customer.getAdded();
            this.name = customer.getName();
            this.email = customer.getEmail();
            this.orders = customer.getOrders().size();
        }

        public CustomerDTO() {
        }

        public LocalDateTime getAdded() {
            return added;
        }

        public void setAdded(LocalDateTime added) {
            this.added = added;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getOrders() {
            return orders;
        }

        public void setOrders(int orders) {
            this.orders = orders;
        }
    }

    public CustomersEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toList());
    }
}

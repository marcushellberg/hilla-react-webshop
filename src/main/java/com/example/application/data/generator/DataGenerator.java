package com.example.application.data.generator;

import com.example.application.data.entity.Customer;
import com.example.application.data.entity.Order;
import com.example.application.repository.CustomerRepository;
import com.example.application.repository.OrderRepository;
import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(OrderRepository orderRepository, CustomerRepository customerRepository) {

        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (orderRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;
            Random r = new Random(seed);

            logger.info("Generating demo data");

            logger.info("... generating 50 customers...");
            ExampleDataGenerator<Customer> customerGenerator = new ExampleDataGenerator<>(Customer.class,
                    LocalDateTime.now());
            customerGenerator.setData(Customer::setName, DataType.FULL_NAME);
            customerGenerator.setData(Customer::setEmail, DataType.EMAIL);
            customerGenerator.setData(Customer::setAdded, DataType.DATETIME_LAST_1_YEAR);

            List<Customer> customers = customerGenerator.create(50, seed);
            customerRepository.saveAll(customers);

            logger.info("... generating 50 orders...");
            ExampleDataGenerator<Order> orderGenerator = new ExampleDataGenerator<>(Order.class,
                    LocalDateTime.now());
            orderGenerator.setData(Order::setAdded, DataType.DATETIME_LAST_30_DAYS);
            List<Order> orders = orderGenerator.create(50, seed).stream().map(order -> {
                order.setCurrency("EUR");
                order.setCustomer(customers.get(r.nextInt(customers.size())));
                return order;
            }).collect(Collectors.toList());
            orderRepository.saveAll(orders);
        };
    }

}

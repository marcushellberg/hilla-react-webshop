package com.example.application.data.endpoint;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.application.data.entity.Product;
import com.example.application.repository.ProductRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import dev.hilla.Endpoint;
import dev.hilla.Nonnull;

@Endpoint
@AnonymousAllowed
public class ProductEndpoint {
  private static Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);
  private final ProductRepository productRepository;

  public ProductEndpoint(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Collection<Product> getProducts() {
    return Collections.emptyList();
  }

  public Product saveProduct(@Nonnull Product product) {
    logger.info("Saved product {} {}", product.getName(), product.getDescription());
    return productRepository.save(product);
  }
}
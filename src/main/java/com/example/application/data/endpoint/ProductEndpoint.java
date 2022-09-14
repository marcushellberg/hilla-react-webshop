package com.example.application.data.endpoint;

import com.example.application.data.dto.ProductDTO;
import com.example.application.repository.ProductRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;

@Endpoint
@AnonymousAllowed
public class ProductEndpoint {
    private static Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);
    private final ProductRepository productRepository;

    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<ProductDTO> getProducts() {
        return Collections.emptyList();
    }

    public ProductDTO saveProduct(@Nonnull ProductDTO product) {
        logger.info("Saved product {} {}", product.getName(), product.getDescription());
        return new ProductDTO(productRepository.save(product.toProduct()));
    }
}
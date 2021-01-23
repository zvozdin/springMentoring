package com.example.springMentoring.service;

import com.example.springMentoring.dao.ProductRepository;
import com.example.springMentoring.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("doesn't exist such product as [%s]", name)));
    }
}

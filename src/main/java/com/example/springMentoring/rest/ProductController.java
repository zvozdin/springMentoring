package com.example.springMentoring.rest;

import com.example.springMentoring.model.Product;
import com.example.springMentoring.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('read')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('write')")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}

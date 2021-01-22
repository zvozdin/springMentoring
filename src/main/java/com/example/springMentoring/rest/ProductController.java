package com.example.springMentoring.rest;

import com.example.springMentoring.model.Product;
import com.example.springMentoring.model.ProductDTO;
import com.example.springMentoring.model.ProductMapper;
import com.example.springMentoring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public List<ProductDTO> getAllProducts() {
        return productMapper.toProductDTOs(productService.getAllProducts());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasAuthority('write')")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}

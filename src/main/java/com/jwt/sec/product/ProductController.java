package com.jwt.sec.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
        Product savedProduct = productRepo.save(product);
        URI productURI = URI.create("/product/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }

    @GetMapping
    public List<Product> list() {
        return productRepo.findAll();
    }

}

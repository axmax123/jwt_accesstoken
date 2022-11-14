package com.jwt.sec.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}

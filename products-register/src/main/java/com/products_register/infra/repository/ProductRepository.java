package com.products_register.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products_register.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

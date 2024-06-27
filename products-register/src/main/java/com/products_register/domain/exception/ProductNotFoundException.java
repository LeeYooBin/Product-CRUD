package com.products_register.domain.exception;

public class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(Long id) {
    super("Product not found with id: " + id);
  }
}

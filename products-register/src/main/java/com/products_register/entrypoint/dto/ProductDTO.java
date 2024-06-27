package com.products_register.entrypoint.dto;

public record ProductDTO(
  Long id,
  String name,
  String description,
  Double value,
  Boolean isAvailable 
) {}

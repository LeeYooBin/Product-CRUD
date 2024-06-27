package com.products_register.infra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_register.domain.exception.ProductNotFoundException;
import com.products_register.domain.model.Product;
import com.products_register.entrypoint.dto.ProductDTO;
import com.products_register.infra.repository.ProductRepository;

@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public ProductDTO registerProduct(ProductDTO productDTO) {
    Product product = new Product(
      productDTO.name(),
      productDTO.description(),
      productDTO.value(),
      productDTO.isAvailable()
    );

    product = productRepository.save(product);

    ProductDTO newProductDTO = new ProductDTO(
      product.getId(), 
      product.getName(), 
      product.getDescription(), 
      product.getValue(), 
      product.getIsAvailable()
    );

    return newProductDTO;
  }

  public List<ProductDTO> getProducts() {
    return productRepository.findAll().stream()
      .map(product -> {
        ProductDTO dto = new ProductDTO(
          product.getId(),
          product.getName(),
          product.getDescription(),
          product.getValue(),
          product.getIsAvailable()
        );
        return dto;
      })
      .collect(Collectors.toList());
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  public ProductDTO editProduct(Long id, ProductDTO productDTO) {
    Product product = productRepository.findById(id)
      .orElseThrow(() -> new ProductNotFoundException(id));

    product.setName(productDTO.name());
    product.setDescription(productDTO.description());
    product.setValue(productDTO.value());
    product.setIsAvailable(productDTO.isAvailable());

    product = productRepository.save(product);

    return new ProductDTO(
      product.getId(),
      product.getName(),
      product.getDescription(),
      product.getValue(),
      product.getIsAvailable()
    );
  }
}

package com.products_register.entrypoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.products_register.entrypoint.dto.ProductDTO;
import com.products_register.infra.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  ProductService productService;

  @PostMapping
  public ResponseEntity<ProductDTO> registerProduct(@RequestBody ProductDTO body) {      
    ProductDTO savedProduct = productService.registerProduct(body);
    return ResponseEntity.status(201).body(savedProduct);
  }
  
  @GetMapping
  public ResponseEntity<List<ProductDTO>> getProducts() {
    List<ProductDTO> products = productService.getProducts();
    return ResponseEntity.status(200).body(products);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDTO> editProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
    ProductDTO updatedProduct = productService.editProduct(id, productDTO);
    return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
  }
}

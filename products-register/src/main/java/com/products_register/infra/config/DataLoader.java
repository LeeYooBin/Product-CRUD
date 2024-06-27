package com.products_register.infra.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.products_register.domain.model.Product;
import com.products_register.infra.repository.ProductRepository;

@Configuration
public class DataLoader {
  @Bean
  CommandLineRunner loadData(ProductRepository repository) {
    return args -> {
      repository.save(new Product("Apple iPhone 13", "Latest model with A15 Bionic chip, 128GB storage.", 999.99, true));
      repository.save(new Product("Samsung Galaxy S21", "Flagship smartphone with Snapdragon 888, 256GB storage.", 799.99, true));
      repository.save(new Product("Sony WH-1000XM4", "Noise-cancelling wireless headphones with 30 hours battery life.", 349.99, true));
      repository.save(new Product("Dell XPS 13", "13.3-inch laptop with Intel i7 processor, 16GB RAM, 512GB SSD.", 1199.99, true));
    };
  }
}

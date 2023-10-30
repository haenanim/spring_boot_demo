package com.example.demo.repository;

import com.example.demo.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRepositoryTest {
  ProductRepository productRepository = new MemoryProductRespository();

  @BeforeEach
  void setUp() {
  }

  @Test
  void findAll() {
    List<Product> allProducts = productRepository.findAll();
//    System.out.println(allProducts.size());
    Assertions.assertThat(allProducts.size()).isEqualTo(1);
  }

  @Test
  void findById() {
    Product product = productRepository.findById(1);
    Assertions.assertThat(product.getProductName()).isEqualTo("제품명1");
  }

  @Test
  void insert() {
    Product product = Product.builder().productName("제품명2").maker("오리").price(2000).qty(50).build();
    Product insert = productRepository.insert(product);
    Assertions.assertThat(insert.getProductId()).isEqualTo(2);
  }

  @Test
  void productUpdate() {
    Product product = Product.builder().productId(1).productName("제품명2").maker("오리").price(2000).qty(50).build();
    productRepository.update(product.getProductId(), product);
    Product product1 = productRepository.findById(1);
    Assertions.assertThat(product1.getProductName()).isEqualTo("제품명2");
  }

  @Test
  void deleteProduct() {
    Product product = productRepository.delete(1);
    Assertions.assertThat(product.getProductName()).isEqualTo("제품명1");

  }
}
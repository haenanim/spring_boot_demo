package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRepository;
import com.example.demo.repository.ProductRepository;
//import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

  ProductRepository productRepository = new MemoryProductRepository();
  ProductService productService = new ProductService(productRepository);

  @Test
  void 제품테스트() {
    Product product = Product.builder().productName("제품명2").maker("오리").price(1000).qty(50).build();
    String s = productService.addProduct(product);
//    assertThat(s).isEqualTo("");
  }


}
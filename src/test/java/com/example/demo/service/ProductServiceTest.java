package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRespository;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

  ProductRepository productRepository = new MemoryProductRespository();
  ProductServie productService = new ProductServie(productRepository);

  @Test
  void 제품테스트() {
    Product product = Product.builder().productName("제품명2").maker("오리").price(1000).qty(50).build();
    String s = productService.addProduct(product);
//    assertThat(s).isEqualTo("");
  }
}
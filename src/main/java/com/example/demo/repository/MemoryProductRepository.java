package com.example.demo.repository;


import com.example.demo.model.Post;
import com.example.demo.model.Product;
import lombok.experimental.PackagePrivate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryProductRepository implements ProductRepository {
  private static Map<Integer, Product> productMap = new HashMap<>();
  private static int seq = 0;

  public MemoryProductRepository() {
    seq++;
    Product product = Product.builder()
        .productId(seq)
        .productName("제품명1")
        .maker("오리")
        .price(1000)
        .qty(100)
        .build();

    productMap.put(seq,product);
  }

  @Override
  public List<Product> findAll() {
    return new ArrayList<>(productMap.values());
  }

  @Override
  public Product findById(int productId) {
    return productMap.get(productId);
  }

  @Override
  public Product insert(Product product) {
    seq++;
    product.setProductId(seq);
    productMap.put(seq, product);
    return product;
  }

  @Override
  public Product productUpdate(int productId, Product product) {
    productMap.put(productId, product);
    return product;
  }

  @Override
  public Product deleteProduct(int productId) {
    Product product = productMap.get(productId);
    productMap.remove(productId);
    return product;
  }
}

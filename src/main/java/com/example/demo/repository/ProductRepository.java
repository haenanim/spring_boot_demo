package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductRepository {
  List<Product>findAll();
  Product findById(int productId);
  public Product insert(Product product);
  public Product productUpdate(int productId, Product product);
  public Product deleteProduct(int productId);
}

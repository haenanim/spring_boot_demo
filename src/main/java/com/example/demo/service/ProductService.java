package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products;
  }
  public String addProduct(Product product) {
    Product inserted = productRepository.insert(product);
    if(inserted == null)
      return "새로운 제품 추가 성공";
    else
      return "새로운 제품 추가 실패";
  }
  public String update(int productId, ProductDTO productDTO) {
    Product product = productRepository.findById(productId);
    product.setQty(productDTO.getQty());
    Product updated = productRepository.productUpdate(productId, product);
    if(updated != null)
      return "제품 수정 성공";
    else
      return "제품 수정 실패";
  }

  public String delete(int productId) {
    Product deleted = productRepository.deleteProduct(productId);
    if(deleted != null)
      return "제품 삭제 성공";
    else
      return "제품 삭제 실패";
  }
}


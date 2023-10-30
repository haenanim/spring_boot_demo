package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
  private int productId;
  private String productName;
  private String maker;
  private int price;
  private int qty;
}

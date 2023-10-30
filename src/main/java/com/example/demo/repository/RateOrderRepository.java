package com.example.demo.repository;

public class RateOrderRepository implements OrderRepository{
  private final int DISCOUNT_RATE = 10;
  @Override
  public int getPrice(int price) {
    return price - (price /100 * DISCOUNT_RATE);
  }
}

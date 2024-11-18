package com.example.demo.service;

import com.example.demo.bo.CreateOrderRequest;
import com.example.demo.bo.OrderResponse;

public interface StockService {

    OrderResponse updateStock(CreateOrderRequest request);

    void addItems(CreateOrderRequest stock);
}
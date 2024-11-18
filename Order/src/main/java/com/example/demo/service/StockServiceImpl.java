package com.example.demo.service;

import com.example.demo.bo.CreateOrderRequest;
import com.example.demo.bo.OrderResponse;
import com.example.demo.entity.StockEntity;
import com.example.demo.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    private final StockRepository repository;

    public StockServiceImpl(StockRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderResponse updateStock(CreateOrderRequest request) {
        System.out.println("Inside update inventory for order " + request);

        OrderResponse orderStatus = new OrderResponse();

        try {
            Iterable<StockEntity> inventories = repository.findByItem(request.getItem());

            boolean exists = inventories.iterator().hasNext();

            if (!exists) {
                System.out.println("Stock not exist so reverting the order");
                throw new Exception("Stock not available");
            }

            inventories.forEach(i -> {
                i.setQuantity(i.getQuantity() - request.getQuantity());
                repository.save(i);

                orderStatus.setItem(i.getItem());
                orderStatus.setOrderId(i.getId());
                orderStatus.setRemainingQty(i.getQuantity());
                orderStatus.setStatus("Success");
            });

        } catch (Exception e) {
        }

        return orderStatus;
    }

    @Override
    public void addItems(CreateOrderRequest stock) {
        Iterable<StockEntity> items = repository.findByItem(stock.getItem());

        if (items.iterator().hasNext()) {
            items.forEach(i -> {
                i.setQuantity(stock.getQuantity() + i.getQuantity());
                repository.save(i);
            });
        } else {
            StockEntity i = new StockEntity();
            i.setItem(stock.getItem());
            i.setQuantity(stock.getQuantity());
            repository.save(i);
        }
    }
}
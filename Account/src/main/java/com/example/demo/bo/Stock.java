package com.example.demo.bo;

public class Stock {

    private String item;
    private Long quantity;
    private String status;

    public Stock(String item, Long quantity, String status) {
        this.item = item;
        this.quantity = quantity;
        this.status = status;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

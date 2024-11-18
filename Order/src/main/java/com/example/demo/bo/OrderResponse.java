package com.example.demo.bo;

public class OrderResponse {

    private String item;

    private Long remainingQty;

    private String status;

    private long orderId;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(Long remainingQty) {
        this.remainingQty = remainingQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "item='" + item + '\'' +
                ", remainingQty=" + remainingQty +
                ", status='" + status + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
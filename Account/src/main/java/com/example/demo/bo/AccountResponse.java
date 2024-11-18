package com.example.demo.bo;

import java.util.List;

public class AccountResponse {

    private List<Stock> stocks;

    public AccountResponse(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

}
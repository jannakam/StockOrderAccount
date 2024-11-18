package com.example.demo.controller;

import com.example.demo.bo.AccountResponse;
import com.example.demo.bo.Stock;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final RestTemplate restTemplate;

    private static final String STOCK_API = "http://localhost:8080/api/account";

    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/account")
    public AccountResponse getStocks() {
        ResponseEntity<List<Stock>> responseEntity = restTemplate.exchange(
                STOCK_API,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Stock>>() {}
        );

        List<Stock> stocks = responseEntity.getBody();

        AccountResponse accountResponse = new AccountResponse(stocks);

        return accountResponse;
    }


}
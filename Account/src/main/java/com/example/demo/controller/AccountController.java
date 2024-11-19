package com.example.demo.controller;

import com.example.demo.bo.AccountResponse;
import com.example.demo.bo.Stock;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final RestTemplate restTemplate;

    private static final String STOCK_API = "http://localhost:8080/api/account";

    public AccountController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/account")
    @CircuitBreaker(name = "orderMS", fallbackMethod = "fallbackMethod")
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

    public AccountResponse fallbackMethod(Throwable throwable) {
        Stock fallbackStock = new Stock("", 0L, "Called Fallback Method");

        List<Stock> fallbackStocks = new ArrayList<>();
        fallbackStocks.add(fallbackStock);

        return new AccountResponse(fallbackStocks);
    }


}
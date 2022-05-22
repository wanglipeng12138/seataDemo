package com.demo.seata.controller;

import com.demo.seata.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping("/stock")
    public void addStock(String productId, Integer count) {
        stockService.addUser(productId, count);
    }

    @PutMapping("/stock/reduce")
    public void reduceStock(String productId, Integer count) {
        stockService.reduceStock(productId, count);
    }

    @PutMapping("/stock/increase")
    public void increaseStock(String productId, Integer count) {
        stockService.increaseStock(productId, count);
    }
}

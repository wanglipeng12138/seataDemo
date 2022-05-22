package com.demo.seata.controller;

import com.demo.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public void addOrder(String productId, Integer totalAmount) {
        orderService.addOrder(productId, totalAmount);
    }

    @PostMapping("/order/tcc")
    public void tccAddOrder(String productId, Integer totalAmount) {
        orderService.tccAddOrder(productId, totalAmount);
    }
}

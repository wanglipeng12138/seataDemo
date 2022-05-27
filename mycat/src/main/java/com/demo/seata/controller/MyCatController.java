package com.demo.seata.controller;

import com.demo.seata.dao.Order;
import com.demo.seata.dao.Stock;
import com.demo.seata.service.OrderService;
import com.demo.seata.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MyCatController {

    @Autowired
    OrderService orderService;

    @Autowired
    StockService stockService;

    // 新增Order
    @PostMapping("/order")
    public Order saveOrder() {
        return orderService.saveOrder("1", 10);
    }

    // 新增stock
    @PostMapping("/stock")
    public Stock saveStock() {
        return stockService.saveStock("1", 100, "product1", "product1", "1");
    }

    // 批量新增order
    @PostMapping("/order/batch")
    public List<Order> saveOrders() {
        List<Order> list = new ArrayList<>();
        for (int i = 1; i < 10001; i++) {
            list.add(orderService.saveOrder(i + "", 10));
        }
        return list;
    }

    // 批量新增stock
    @PostMapping("/stock/batch")
    public List<Stock> saveStocks() {
        List<Stock> list = new ArrayList<>();
        for (int i = 1; i < 10001; i++) {
            String type = String.valueOf(i % 50);
            list.add(stockService.saveStock(i + "", 100, "product" + i, "product" + i, type));
        }
        return list;
    }

    // 分库分表后的连表查询order
    @GetMapping("/order")
    public List<Order> getOrder() {
        return orderService.findAllOrderAndProductCount();
    }
}

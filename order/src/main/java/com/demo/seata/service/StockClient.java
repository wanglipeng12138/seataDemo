package com.demo.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "StockClient", url = "localhost:8893")
public interface StockClient {

    @PutMapping("/stock/reduce")
    void reduceStock(@RequestParam("productId") String productId, @RequestParam("count") Integer count);

    @PutMapping("/stock/increase")
    void increaseStock(@RequestParam("productId") String productId, @RequestParam("count") Integer count);
}

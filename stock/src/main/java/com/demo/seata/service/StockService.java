package com.demo.seata.service;

import cn.hutool.core.util.IdUtil;
import com.demo.seata.dao.Stock;
import com.demo.seata.dao.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public void addUser(String productId, Integer count) {
        Stock stock = new Stock();
        stock.setId(IdUtil.objectId());
        stock.setProductId(productId);
        stock.setCount(count == null ? 100 : count);
        stockRepository.save(stock);
    }


    public void reduceStock(String productId, Integer count) {
        Optional<Stock> stockOptional = stockRepository.findAllByProductId(productId);
        if (Boolean.FALSE.equals(stockOptional.isPresent())) {
            return;
        }
        Stock stock = stockOptional.get();
        stock.setCount(stock.getCount() - count);
        stockRepository.save(stock);
    }


    public void increaseStock(String productId, Integer count) {
        Optional<Stock> stockOptional = stockRepository.findAllByProductId(productId);
        if (Boolean.FALSE.equals(stockOptional.isPresent())) {
            return;
        }
        Stock stock = stockOptional.get();
        stock.setCount(stock.getCount() + count);
        stockRepository.save(stock);
    }
}

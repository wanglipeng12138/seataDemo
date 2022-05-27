package com.demo.seata.service;

import cn.hutool.core.util.IdUtil;
import com.demo.seata.dao.Stock;
import com.demo.seata.dao.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public Stock saveStock(String productId, Integer count, String desc, String name, String type) {
        Stock stock = new Stock();
        stock.setId(IdUtil.objectId());
        stock.setProductId(productId);
        stock.setCount(count);
        stock.setPdesc(desc);
        stock.setPname(name);
        stock.setType(type);
        return stockRepository.save(stock);
    }
}

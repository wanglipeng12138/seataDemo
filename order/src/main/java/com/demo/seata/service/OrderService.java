package com.demo.seata.service;

import cn.hutool.core.util.IdUtil;
import com.demo.seata.dao.Order;
import com.demo.seata.dao.OrderRepository;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    StockClient stockClient;

    @Autowired
    OrderTCCServiceImpl orderTCCService;

    // 测试 AT模式 全局事务
    @GlobalTransactional
    public void addOrder(String productId, Integer totalAmount) {
        // 减少库存
        stockClient.reduceStock(productId, totalAmount);
        int i = 1 / 0;

        // 增加订单
        Order order = new Order();
        order.setId(IdUtil.objectId());
        order.setProductId(productId);
        order.setStatus("1");
        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
    }

    // 测试 TCC模式
    @GlobalTransactional
    public void tccAddOrder(String productId, Integer totalAmount) {
        orderTCCService.addOrder(productId, totalAmount);
    }
}

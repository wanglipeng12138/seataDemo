package com.demo.seata.service;

import cn.hutool.core.util.IdUtil;
import com.demo.seata.dao.Order;
import com.demo.seata.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(String productId, int totalAmount) {
        Order order = new Order();
        order.setId(IdUtil.objectId());
        order.setProductId(productId);
        order.setTotalAmount(totalAmount);
        order.setStatus("0");
        return orderRepository.save(order);
    }

    public List<Order> findAllOrderAndProductCount() {
        List<Order> list = orderRepository.findAllOrderAndProductCount();
        return list;
    }
}

package com.demo.seata.service;

import cn.hutool.core.util.IdUtil;
import com.demo.seata.dao.Order;
import com.demo.seata.dao.OrderRepository;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderTCCServiceImpl implements OrderTCCService {

    @Autowired
    StockClient stockClient;

    @Autowired
    OrderRepository orderRepository;

    @Override
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

    @Override
    public void commit(BusinessActionContext actionContext) {
        System.out.println("提交成功");
    }

    @Override
    public void rollback(BusinessActionContext actionContext) {
        System.out.println("开始回滚");
        String productId = actionContext.getActionContext("productId").toString();
        Integer totalAmount = Integer.parseInt(actionContext.getActionContext("totalAmount").toString());
        // 增加库存
        stockClient.increaseStock(productId, totalAmount);
    }
}

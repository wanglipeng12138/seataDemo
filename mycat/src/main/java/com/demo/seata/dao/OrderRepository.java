package com.demo.seata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends JpaRepository<Order, String> {

    // 根据stock的type查询对应的Order
    @Query(value = "select porder.*, pstock.count as count from porder join pstock on porder.product_id = pstock.product_id where pstock.type = 3", nativeQuery = true)
    List<Order> findAllOrderAndProductCount();
}

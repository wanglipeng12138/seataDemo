package com.demo.seata.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "porder")
public class Order {

    @Id
    String id;

    String productId;       // 产品Id

    String status;          // 状态

    Integer totalAmount;    // 数量

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}

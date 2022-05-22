package com.demo.seata.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pstock")
public class Stock {

    @Id
    String id;

    String productId;

    Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

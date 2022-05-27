package com.demo.seata.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pstock")
public class Stock {

    @Id
    String id;

    String productId;

    Integer count;

    String pdesc;

    String pname;

    String type;

    String puse;

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

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPuse() {
        return puse;
    }

    public void setPuse(String puse) {
        this.puse = puse;
    }
}

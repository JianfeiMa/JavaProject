package com.jianfei.sax;

import java.math.BigDecimal;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-11-12 10:38
 */
public class Entity {
    private BigDecimal priceOfFirstWeight;
    private BigDecimal priceOfAddWeight;
    private String description;

    public BigDecimal getPriceOfFirstWeight() {
        return priceOfFirstWeight;
    }

    public void setPriceOfFirstWeight(BigDecimal priceOfFirstWeight) {
        this.priceOfFirstWeight = priceOfFirstWeight;
    }

    public BigDecimal getPriceOfAddWeight() {
        return priceOfAddWeight;
    }

    public void setPriceOfAddWeight(BigDecimal priceOfAddWeight) {
        this.priceOfAddWeight = priceOfAddWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

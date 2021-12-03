package com.springboot.demo.Dao;

import java.math.BigDecimal;

public class Transaction {

    private String date;
    private BigDecimal countChange;
    private String source;

    public Transaction(String date, BigDecimal countChange, String source) {
        this.date = date;
        this.countChange = countChange;
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getCountChange() {
        return countChange;
    }

    public void setCountChange(BigDecimal countChange) {
        this.countChange = countChange;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}

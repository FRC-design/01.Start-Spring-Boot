package com.frc.entity;

public class FeeRecord {
    private String amount;
    private String name;
    private String phone;

    public FeeRecord(String amount, String name, String phone) {
        this.amount = amount;
        this.name = name;
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

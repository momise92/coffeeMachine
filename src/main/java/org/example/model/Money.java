package org.example.model;

public class Money {
    private float amount;

    public Money(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public float subtractAmount(float price) {
        return amount - price;
    }
}

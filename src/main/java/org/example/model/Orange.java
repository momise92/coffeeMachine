package org.example.model;

public class Orange implements IDrink {

    private final String CODE = "O";
    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public float getPrice() {
        return 0.6f;
    }
}

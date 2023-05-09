package org.example.model;

import org.example.model.Drink;

public class Orange implements Drink {

    private final String CODE = "O";
    @Override
    public String getCode() {
        return CODE;
    }

    @Override
    public float price() {
        return 0;
    }
}

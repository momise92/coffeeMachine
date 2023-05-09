package org.example.model;

import java.math.BigDecimal;

public class Chocolate implements Drink, ExtraHotInterface {

    private final String CODE = "H";
    private boolean extraHot = false;

    @Override
    public String getCode() {
        if (extraHot) {
            return CODE + getExtraHotCode();
        } else
            return CODE;
    }

    @Override
    public float price() {
        return 0.5f;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }
}

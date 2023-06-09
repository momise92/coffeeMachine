package org.example.model;

public class Chocolate implements IDrink, ExtraHotInterface {

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
    public float getPrice() {
        return 0.5f;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }
}

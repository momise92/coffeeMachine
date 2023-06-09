package org.example.model;

public class Coffee implements IDrink, ExtraHotInterface {
    private final String CODE = "C";
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
        return 0.6f;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }
}

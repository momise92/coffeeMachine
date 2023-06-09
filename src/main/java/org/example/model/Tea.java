package org.example.model;


public class Tea implements IDrink, ExtraHotInterface {
    private final String CODE = "T";
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
        return 0.4f;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }
}

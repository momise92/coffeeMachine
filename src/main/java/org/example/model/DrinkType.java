package org.example.model;

public enum DrinkType {

    TEA("T", 0.4f, false),
    COFFEE("C", 0.6f, false),
    CHOCOLATE("H",0.5f, false),
    ORANGE("O", 0.6f, false) {
        @Override
        public void setExtraHot(boolean extraHot) {
            this.extraHot = false;
        }
    };

    private String code;
    private float price;
    protected boolean extraHot;


    DrinkType(String code, float price, boolean extraHot) {
        this.code = code;
        this.price = price;
        this.extraHot = extraHot;
    }

    public String getCode() {
        if (extraHot) {
            return code + 'h';
        } else
            return code;
    }

    public float getPrice() {
        return price;
    }

    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

}

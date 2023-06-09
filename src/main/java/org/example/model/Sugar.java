package org.example.model;

public class Sugar {

    private int sugarNumber;
    private final String stickCode = "0";

    public Sugar(int number) {
        this.sugarNumber = number;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public String getCode() {
        return sugarNumber > 0 ? sugarNumber + Message.SEPARATOR + stickCode : "";
    }
}

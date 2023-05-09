package org.example.model;

public class Sugar implements StickInterface {

    private int sugarNumber;

    public Sugar(int number) {
        this.sugarNumber = number;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public String getCode() {
        return sugarNumber > 0 ? sugarNumber + Message.SEPARATOR + getStickCode() : "";
    }
}

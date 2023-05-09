package org.example.model;

public final class Message {
    public static final String CODE_MESSAGE = "M:";
    public static final String CHOOSE_DRINK = CODE_MESSAGE + "Please choose a drink";
    public static final String INSUFFICIENT = CODE_MESSAGE + "Missing ";

    public static final String SEPARATOR = ":";
    public static final String DOUBLE_SEPARATOR = "::";

    public static String insufficientMessage(float amountSubtracted) {
        return INSUFFICIENT + -amountSubtracted + "€";
    }

}

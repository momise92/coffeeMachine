package org.example.model;

public class DrinkMaker {
    private Money amount;

    public void setMoney(Money amount) {
        this.amount = amount;
    }

    public String make(Drink drink) {
        return make(drink, new Sugar(0));
    }

    public String make(Drink drink, Sugar sugar) {

        if(drink == null) {
            return Message.CHOOSE_DRINK;
        }

        if(amount.getAmount() < drink.price()) {
            float amountSubtracted = amount.subtractAmount(drink.price());
            return Message.insufficientMessage(amountSubtracted);
        }

        if (sugar.getSugarNumber() < 1) {
            return drink.getCode() + Message.DOUBLE_SEPARATOR;
        }
        return drink.getCode() + Message.SEPARATOR + sugar.getCode();
    }
}
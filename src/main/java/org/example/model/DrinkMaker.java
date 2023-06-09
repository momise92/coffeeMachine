package org.example.model;

public class DrinkMaker {


    public static String make(Order order) {

        String message = checkOrder(order.getMoney(), order.getDrink(), order.getSugar());
        if (!message.isEmpty()) return message;

        if (order.getSugar().getSugarNumber() < 1) {
            return order.getDrink().getCode() + Message.DOUBLE_SEPARATOR;
        }

        return order.getDrink().getCode() + Message.SEPARATOR + order.getSugar().getCode();
    }

    private static String checkOrder(Money money, DrinkType drink, Sugar sugar) {
        String message = "";

        if (money == null || drink == null || sugar == null) {
            message = Message.ERROR;
        }
       else if(money.getAmount() < drink.getPrice()) {
            float amountSubtracted = money.getAmount() - drink.getPrice();
            message = Message.insufficientMessage(amountSubtracted);
        }
        return message;
    }
}
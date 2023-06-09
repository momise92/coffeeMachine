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

//    public static String makeDrink(float amount, DrinkType drink) {
//        String message = checkOrder(amount, drink);
//        if (!message.isEmpty()) return message;
//
//        return drink.getCode() + Message.DOUBLE_SEPARATOR;
//    }
//
//    public static String makeDrink(float amount, DrinkType drink, Sugar sugar) {
//        String message = checkOrder(amount, drink);
//        if (!message.isEmpty()) return message;
//
//        if (sugar.getSugarNumber() < 1) {
//            return makeDrink(amount, drink);
//        }
//
//        return drink.getCode() + Message.SEPARATOR + sugar.getCode();
//    }
//
//    public static String makeDrink(float amount, DrinkType drink, Sugar sugar, boolean extraHot) {
//        String message = checkOrder(amount, drink);
//        if (!message.isEmpty()) return message;
//
//        drink.setExtraHot(extraHot);
//
//        return makeDrink(amount, drink, sugar);
//    }

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
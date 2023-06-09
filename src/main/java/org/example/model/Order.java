package org.example.model;

public class Order {
    private Money money;
    private DrinkType drinkType;
    private Sugar sugar;


    private Order(Money money, DrinkType drinkType, Sugar sugar) {
        this.money = money;
        this.drinkType = drinkType;
        this.sugar = sugar;
    }

    public static Order orderDrink(Money money, DrinkType drink) {
        return new Order(money, drink, new Sugar(0));
    }
    public static Order orderDrink(Money money, DrinkType drink, Sugar sugar) {
        return new Order(money, drink, sugar);
    }

    public Money getMoney() {
        return money;
    }

    public DrinkType getDrink() {
        return drinkType;
    }

    public Sugar getSugar() {
        return sugar;
    }
}

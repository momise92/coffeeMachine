package org.example.model;

public class Order {

    private Money money;
    private Drink drink;
    private Sugar sugar;

    public Order(Money money, Drink drink, Sugar sugar) {
        this.money = money;
        this.drink = drink;
        this.sugar = sugar;
    }

    public Order(Money money, Drink drink) {
        this.money = money;
        this.drink = drink;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }
}

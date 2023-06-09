package org.example.model;

public interface IOrder {

    Order orderHotDrink(Money money, DrinkType drink, Sugar sugar, Boolean extraHot);

    Order orderDrink(Money money, DrinkType drink);
}

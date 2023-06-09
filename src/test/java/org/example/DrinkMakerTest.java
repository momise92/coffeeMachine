package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DrinkMakerTest {

    @Test
    public void order_tea_should_make_a_tea() {
        //given
        Money money = new Money(0.4f);
        Sugar sugar = new Sugar(0);
        DrinkType drinkType = DrinkType.TEA;
        Order order = Order.orderDrink(money, drinkType, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("T::", codeReceived);
    }

    @Test
    public void order_coffee_should_make_a_coffee() {
        //given
        Money money = new Money(0.6f);
        Sugar sugar = new Sugar(0);
        DrinkType drinkType = DrinkType.COFFEE;
        drinkType.setExtraHot(false);
        Order order = Order.orderDrink(money, drinkType, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("C::", codeReceived);
    }

    @Test
    public void order_chocolate_should_make_a_chocolate() {
        //given
        Money money = new Money(0.5f);
        Sugar sugar = new Sugar(0);
        Order order = Order.orderDrink(money, DrinkType.CHOCOLATE, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("H::", codeReceived);
    }

    @Test
    public void drink_null_should_return_message() {
        //given
        Money money = new Money(0.1f);
        Sugar sugar = new Sugar(0);
        Order order = Order.orderDrink(money, null, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals(Message.ERROR, codeReceived);
    }

    @Test
    public void order_tea_with_1_sugar_should_make_tea_with_1_sugar_and_stick() {
        //given
        Money money = new Money(0.4f);
        Sugar sugar = new Sugar(1);
        Order order = Order.orderDrink(money, DrinkType.TEA, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("T:1:0", codeReceived);
    }

    @Test
    public void order_tea_with_0_sugar_should_make_tea() {
        //given
        Money money = new Money(0.4f);
        Sugar sugar = new Sugar(0);
        DrinkType drinkType = DrinkType.TEA;
        drinkType.setExtraHot(false);
        Order order = Order.orderDrink(money, drinkType, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("T::", codeReceived);
    }


    @Test
    public void order_tea_with_incorrect_amount_should_return_message() {
        //given
        Money money = new Money(0.1f);
        Sugar sugar = new Sugar(0);
        Order order = Order.orderDrink(money, DrinkType.TEA, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        float amountSubtracted = 0.1f - DrinkType.TEA.getPrice();
        //then
        Assertions.assertEquals("M:Missing " + -amountSubtracted + "€" , codeReceived);
    }

    @Test
    public void order_orange_juice_should_make_orange_juice() {
        //given
        Money money = new Money(0.6f);
        Order order = Order.orderDrink(money, DrinkType.ORANGE);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("O::", codeReceived);
    }

    @Test
    public void order_orange_juice_extra_hot_should_not_make_extra_hot_juice() {
        //given
        Money money = new Money(0.6f);
        DrinkType drinkType = DrinkType.ORANGE;
        drinkType.setExtraHot(true);
        Order order = Order.orderDrink(money, drinkType);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("O::", codeReceived);
    }

    @Test
    public void order_tea_extra_hot_should_make_a_tea_extra_hot() {
        //given
        Money money = new Money(0.4f);
        DrinkType drinkType = DrinkType.TEA;
        drinkType.setExtraHot(true);
        Order order = Order.orderDrink(money, drinkType);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("Th::", codeReceived);
    }

    @Test
    public void order_coffee_extra_hot_with_1_sugar() {
        //given
        Money money = new Money(0.6f);
        Sugar sugar = new Sugar(1);
        DrinkType drinkType = DrinkType.COFFEE;
        drinkType.setExtraHot(true);
        Order order = Order.orderDrink(money, drinkType, sugar);
        //when
        String codeReceived = DrinkMaker.make(order);
        //then
        Assertions.assertEquals("Ch:1:0", codeReceived);
    }

}

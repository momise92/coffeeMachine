package org.example;

import org.example.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DrinkMakerTest {

    @Test
    public void order_tea_should_make_a_tea() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.4f);
        drinkMaker.setMoney(money);
        Tea tea = new Tea();
        //when
        String codeReceived = drinkMaker.make(tea);
        //then
        Assertions.assertEquals("T::", codeReceived);
    }

    @Test
    public void order_coffee_should_make_a_coffee() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.6f);
        drinkMaker.setMoney(money);

        //when
        String codeReceived = drinkMaker.make(new Coffee());
        //then
        Assertions.assertEquals("C::", codeReceived);
    }

    @Test
    public void order_chocolate_should_make_a_chocolate() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.5f);
        drinkMaker.setMoney(money);

        //when
        String codeReceived = drinkMaker.make(new Chocolate());
        //then
        Assertions.assertEquals("H::", codeReceived);
    }

    @Test
    public void order_null_should_return_message() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.1f);
        drinkMaker.setMoney(money);
        //when
        String codeReceived = drinkMaker.make(null);
        //then
        Assertions.assertEquals("M:Please choose a drink", codeReceived);
    }

    @Test
    public void order_tea_with_1_sugar_should_make_tea_with_1_sugar_and_stick() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.4f);
        Sugar sugar = new Sugar(1);
        drinkMaker.setMoney(money);
        //when
        String codeReceived = drinkMaker.make(new Tea(), sugar);
        //then
        Assertions.assertEquals("T:1:0", codeReceived);
    }

    @Test
    public void order_tea_with_0_sugar_should_make_tea() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.4f);
        Sugar sugar = new Sugar(0);
        drinkMaker.setMoney(money);
        //when
        String codeReceived = drinkMaker.make(new Tea(), sugar);
        //then
        Assertions.assertEquals("T::", codeReceived);
    }

    @Test
    public void order_tea_with_correct_amount_should_make_tea() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.4f);
        drinkMaker.setMoney(money);
        //when
        String codeReceived = drinkMaker.make(new Tea());
        //then
        Assertions.assertEquals("T::", codeReceived);
    }

    @Test
    public void order_tea_with_incorrect_amount_should_return_message() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.1f);
        drinkMaker.setMoney(money);
        Drink tea = new Tea();
        //when
        String codeReceived = drinkMaker.make(tea);
        float amountSubtracted = 0.1f - tea.price();
        //then
        Assertions.assertEquals("M:Missing " + -amountSubtracted + "€" , codeReceived);
    }

    @Test
    public void order_orange_juice_should_make_orange_juice() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.6f);
        drinkMaker.setMoney(money);

        //when
        String codeReceived = drinkMaker.make(new Orange());
        //then
        Assertions.assertEquals("O::", codeReceived);
    }

    @Test
    public void order_tea_extra_hot_should_make_a_tea_extra_hot() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.4f);
        drinkMaker.setMoney(money);
        Tea tea = new Tea();
        tea.setExtraHot(true);
        //when
        String codeReceived = drinkMaker.make(tea);
        //then
        Assertions.assertEquals("Th::", codeReceived);
    }

    @Test
    public void order_coffee_extra_hot_with_1_sugar() {
        //given
        DrinkMaker drinkMaker = new DrinkMaker();
        Money money = new Money(0.6f);
        Sugar sugar = new Sugar(1);
        drinkMaker.setMoney(money);
        Coffee coffee = new Coffee();
        coffee.setExtraHot(true);
        //when
        String codeReceived = drinkMaker.make(coffee, sugar);
        //then
        Assertions.assertEquals("Ch:1:0", codeReceived);
    }

}

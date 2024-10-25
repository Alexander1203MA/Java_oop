package Picnic.view;

import Picnic.model.Basket;

public class CalculateCountFruits implements Calculate<Basket> {

    @Override
    public void calculate(Basket basket) {
        System.out.printf("Всего фруктов в нашей корзине - %s%n", basket.getBasketSize());
    }
}
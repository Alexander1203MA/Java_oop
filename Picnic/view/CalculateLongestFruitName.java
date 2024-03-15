package Picnic.view;

import Picnic.model.Basket;
import Picnic.model.Fruits;
import Picnic.model.FruitsComparator;

import java.util.Optional;

public class CalculateLongestFruitName implements Calculate<Basket>{

    @Override
    public void calculate(Basket basket) {
        Optional<Fruits> maxFruit = basket.getBasket().keySet().stream().max(new FruitsComparator());
        System.out.printf("Самое длинное название - %s, его длина %s символов%n", maxFruit.get().getName(),maxFruit.get().getNameLength());
    }
}
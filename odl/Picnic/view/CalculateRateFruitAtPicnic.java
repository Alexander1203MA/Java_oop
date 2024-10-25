package Picnic.view;

import Picnic.model.Basket;
import Picnic.model.Fruits;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;


public class CalculateRateFruitAtPicnic implements Calculate<Basket> {
    private static boolean ascending = false;

    public CalculateRateFruitAtPicnic() {
    }

    public CalculateRateFruitAtPicnic(boolean ascending) {CalculateRateFruitAtPicnic.ascending = ascending;}

    @Override
    public void calculate(Basket basket) {
        Map<Fruits, Integer> sorted = sortBasket(basket);
        for (Fruits fruit: sorted.keySet()) {
            System.out.printf("'%s' = %s%n",fruit.getName(),basket.getPlantAmount(fruit));
        }

    }
    private Map<Fruits, Integer> sortBasket(Basket<Fruits> basket){
        Map<Fruits, Integer> sorted = basket.getBasket();

        if (!ascending) {
            sorted = sorted
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        } else {
            sorted = sorted
                    .entrySet()
                    .stream()
                    .sorted(comparingByValue())
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        }
        return sorted;
    }
    public static void setAscending(boolean ascending){ CalculateRateFruitAtPicnic.ascending = ascending;}
}

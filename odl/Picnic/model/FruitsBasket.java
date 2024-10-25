package Picnic.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FruitsBasket implements Basket<Fruits>, Iterable<Fruits>{
    private Map<Fruits, Integer> basket;

    public FruitsBasket() {
        basket = new HashMap<>();
    }

    public FruitsBasket(Map<Fruits, Integer> basket) {
        this.basket = basket;
    }

    public FruitsBasket(List<String> rawData){
        basket = new HashMap<>();
        if (rawData==null) {
            System.err.println("Список имен пуст. Корзина пуста.");
            return;
        }
        for (String fruit: rawData){
            if (!fruit.isEmpty()) {
                addToBasket(Fruits.getFruitInstance(fruit));
            }
        }
    }

    public Map<Fruits, Integer> getBasket() {
        return basket;
    }

    @Override
    public int getBasketSize() {
        return this.basket.size();
    }

    @Override
    public void addToBasket(Fruits plant) {
        if (plant == null) throw new RuntimeException("В корзине могут быть только фрукты");
        int count = this.basket.getOrDefault(plant, 0);
        Integer put = basket.put(plant, ++count);

    }
    @Override
    public Integer getPlantAmount(Fruits fruit) {
        return basket.get(fruit);
    }


    @Override
    public Iterator<Fruits> iterator() {
        return basket.keySet().iterator();
    }
}
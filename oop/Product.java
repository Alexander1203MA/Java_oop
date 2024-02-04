package oop;

import java.util.Objects;
import java.util.Random;

/**
 * Родительский класс для товаров
 *
 */
public class Product {
    protected String name;
    protected int price;
    protected double rating;
    protected static int defaultIndex;
    protected static Random rand;
    static {
        Product.defaultIndex =0;
        Product.rand = new Random();
    }


    public Product(String name, int price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(String name, int price) {
        this(name,price,setRandomRating());
    }

    public Product(String name) {
        this(name, setRandomPrice(5_000),setRandomRating());
    }

    public Product() {
        this(setDefaultName("Товар",++Product.defaultIndex),
                setRandomPrice(5_000));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @apiNote Метод создающий наименование по-умолчанию
     * @param prefix строковое значение. Например: "Товар" или "Полуфабрикат" и т.п.
     * @param index целочисленное значение, порядковый номер
     * @return строковое значение. Например: "Товар 10"
     */
    public static String setDefaultName(String prefix, int index){
        return String.format("%s %d",prefix,index);
    }

    /**
     * @apiNote Метод создающий случайную цену.
     * @param max целочисленное значение, верхняя граница.
     * @return целое случайное число, в диапазоне [0;max].
     */
    public static int setRandomPrice(int max){
        return Product.rand.nextInt(max+1);
    }

    public static double setRandomRating(){
        return (rand.nextDouble()*10*100)/100.0;
    }
    public void showProducts(){}

    @Override
    public String toString() {
        return String.format(
                "Наименование=' %s \'" +
                ", Цена= %d" +
                ", Рейтинг= %.2f",
                name,price,rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Double.compare(rating, product.rating) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, rating);
    }
}

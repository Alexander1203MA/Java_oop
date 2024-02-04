package Relayrace;

import java.util.Random;

/**
 * Базовый класс препятствий
 */
public abstract class Obstacles {
    protected String name;
    protected enum Directions {
        vertical, horizontal
    }
    protected int dimension; //Размер препятствия
    protected Directions direction; //Направление препятствия (горизонтальное|вертикальное)
    protected static Random rand;
    static {
        rand = new Random();
    }


    Obstacles(String name, int dimension, Directions direction) {
        this.name = name;
        this.dimension = dimension;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }

    public Directions getDirection() {
        return direction;
    }

    /**
     * Метод создающий случайное целое число в диапазоне [min;max]
     * @param max Максимальное возможное значение
     * @param min Минимальное возможное значение
     * @return псевдослучайное целое число в диапазоне [min;max]
     */
    public static int setRandomDimension(int max, int min){
        return rand.nextInt(max-min+1)+min+1;
    }

    /**
     * Метод создающий автоматическое имя
     * @param name  строка Имя
     * @param index целое Счетчик
     * @return строку вида "Имя № Счетчик"
     */
    public static String  setDefaultName(String name,int index) {
        return String.format("%s № %d",name,index);
    }


    /**
     * Метод возвращающий единицу измерения
     * @return строку с названием ед.изм.
     */
    abstract String getUnit();
}
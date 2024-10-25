package Relayrace;
/**
 * Класс Кот, наследуется от базового класса Творения
 */
public class Cat extends Creature {

    // Константы для определения случайных величин
    final private static int MAX_SPEED = 1;
    final private static int MIN_SPEED = 1;
    final private static int MAX_DISTANCE = 1_000;
    final private static int MIN_DISTANCE = 10;
    final private static int MAX_HEIGHT = 300;
    final private static int MIN_HEIGHT = 100;

    // счетчик котов для автоматического задания имени
    private static int catIndex;
    static {
        catIndex =0;
    }
    public Cat(String name, int speed) {
        super(name, speed);
        this.maxRunDistance = setMaxValue(MAX_DISTANCE,MIN_DISTANCE);
        this.maxJumpHeight = setMaxValue(MAX_HEIGHT,MIN_HEIGHT);
    }

    public Cat(){
        this(setDefaultName("Кот", ++catIndex), setMaxValue(MAX_SPEED,MIN_SPEED));
    }
}
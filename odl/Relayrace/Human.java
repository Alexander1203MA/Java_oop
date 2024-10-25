package Relayrace;
import java.util.Random;
/**
 * Класс Человек, наследуется от базового класса Созданий
 */
public class Human extends Creature {

    // Константы для определения случайных величин
    final private static int MAX_SPEED = 5;
    final private static int MIN_SPEED = 1;
    final private static int MAX_DISTANCE = 1_000;
    final private static int MIN_DISTANCE = 100;
    final private static int MAX_HEIGHT = 200;
    final private static int MIN_HEIGHT = 100;
    private static int humanCount;
    static {
        humanCount = 0;
    }

    public Human(String name, int speed) {
        super(name, speed);
        Human.rand = new Random();
        this.maxRunDistance = setMaxValue(MAX_DISTANCE,MIN_DISTANCE);
        this.maxJumpHeight = setMaxValue(MAX_HEIGHT,MIN_HEIGHT);

    }
    public Human(){
        this(setDefaultName("Человек", ++humanCount), setMaxValue(MAX_SPEED,MIN_SPEED));
    }


}
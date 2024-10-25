package Relayrace;
import java.util.Random;
/**
 * Создал условный базовый класс для наших созданий условно, или творений,дабы не создавать отдельно 2 класса под живых и неживых
 */
public abstract class Creature implements SportInterface {

    protected String name;
    protected static Random rand;
    protected boolean canContinue;
    protected int maxRunDistance;
    protected int maxJumpHeight;
    protected int speed;
    protected int time;

    static {
        rand = new Random();
    }


    Creature(String name, int speed) {
        this.name = name;
        this.speed = speed;
        this.canContinue = true;

    }

    public String getName() {
        return name;
    }

    public boolean isContinue() {
        return canContinue;
    }

    public void start() {
        time = 0;
    }

    public int finish() {
        return time;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * Метод возвращающий время затраченное на прохождение distance
     * @param distance Расстояние
     * @param speed Скорость
     * @return Время в сек.
     */
    public int getTime(int distance, int speed) {
        int result;
        try {
            result = distance / speed;
        } catch (ArithmeticException e) {
            result = Integer.MAX_VALUE;
        }

        return result;

    }

    /**
     * Метод возвращающий случайное целое число [min;max]
     * @param max Максимально возможная граница (включительно)
     * @param min Минимально возможная граница (включительно)
     * @return Случайное целое число в диапазоне [min;max]
     */
    public static int setMaxValue(int max, int min) {
        return rand.nextInt(max - min + 1) + min + 1;
    }

    /**
     * Метод возвращющий информацию о Творении
     * @return Строка вида "Имя Творения(МаксДистанция м., МаксВысота см., МаксСкорость м/с)"
     */
    public String getInfo() {
        return String.format("%s(Макс. дистанция %d м., Макс. высота %d см., Макс. скорость %d м/с)",
                getName(), maxRunDistance, maxJumpHeight, getSpeed());
    }


    /**
     * Метод возвращающий автоматическое имя Творения
     * @param defaultName Строка с именем по-умолчанию
     * @param index  Целое число Счетчика созданий
     */
    public static String setDefaultName(String defaultName, int index) {
        return String.format("%s № %d", defaultName, index);
    }

    @Override
    public String toString() {
        return String.format("%s{%s %s}", getClass().getTypeName(), name, canContinue ? "может продолжать гонку" : "сошёл с дистанции");
    }


    /**
     * ОДИН метод преодоления разных препятствий любыми созданиями
     *
     * @param obstacle Препятствие
     */
    @Override
    public void overcoming(Obstacles obstacle) {
        String separator = "-------------------------------------------------------------------";
        // Определяем параметры для преодоления разных препятствий одним методом для любого творения
        int maxDimension = switch (obstacle.getDirection()) {
            case horizontal -> maxRunDistance;
            case vertical -> maxJumpHeight;
        };
        String action = switch (obstacle.getDirection()) {
            case horizontal -> "пробежал дистанцию";
            case vertical -> "перепрыгнул препятствие высотой";
        };
        // Если ограничения для создания срабатывают, то конец гонки
        if (obstacle.getDimension() > maxDimension || getSpeed() <= 0) canContinue = false;
        if (!canContinue) {
            System.out.println(separator);
            System.out.printf("%s %s не может продолжать гонку%n", getClass().getTypeName(), getName());
            System.out.printf("%s%n", getInfo());
            System.out.println(separator);
            time = Integer.MAX_VALUE;
            return;
        }
        System.out.printf("%s %s %s %d %s%n", getClass().getTypeName(), getName(), action, obstacle.getDimension(), obstacle.getUnit());
        if (obstacle.getDirection() == Obstacles.Directions.horizontal)
            time += getTime(obstacle.getDimension(), getSpeed());
    }

}
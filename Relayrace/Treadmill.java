package Relayrace;

/**
 * Класс беговой дорожки, наследуется от базового класса
 * Направление - горизонтальное
 * Измерение - длина
 * Ед.изм. - метры
 */
public class Treadmill extends Obstacles{

    // Счетчик дорожек для автоматического задания имени
    private static int treadMillIndex;

    //Константы для задания случайных величин
    final private static int MAX_DISTANCE = 500;
    final private static int MIN_DISTANCE = 10;
    static {
        treadMillIndex = 0;
    }
    public Treadmill(String name, int dimension, Directions direction) {
        super(name, dimension, direction);
    }

    public Treadmill() {
        this(setDefaultName("Дорожка",++treadMillIndex), setRandomDimension(MAX_DISTANCE,MIN_DISTANCE), Directions.horizontal);
    }


    @Override
    String getUnit() {
        return "метров";
    }
}
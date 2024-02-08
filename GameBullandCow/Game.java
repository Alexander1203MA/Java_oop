package GameBullandCow;
public interface Game {

    void start(Integer sizeWord, Integer maxTry, Conditions conditions);

    void stop();

    void exit();

    void restart();

    Answer inputValue(String value);

    GameStatus getGameStatus();
}
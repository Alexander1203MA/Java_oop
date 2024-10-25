package GameBullandCow;
import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    private String word;
    private Integer attemptCounter;
    private Integer maxAttempts; 
    private Integer wordSize; 
    private Conditions currentCondition; 
    private GameStatus status = GameStatus.INIT; 
    private HistoryGame historyGame;

    public String generateWord(Integer sizeWord, Conditions conditions) {
        StringBuilder result = new StringBuilder();
        List<String> charList = generateCharList();
        Random rand = new Random();
        String randomSymbol = charList.get(rand.nextInt(charList.size()));
        for (int i = 0; i < sizeWord; i++) {
            switch (conditions) {
                case UNIQUE_SYMBOLS:
                    while (result.lastIndexOf(randomSymbol) > -1) {
                        randomSymbol = charList.get(rand.nextInt(charList.size()));
                    }
                    break;
            }
            result.append(randomSymbol);
        }
        return result.toString();
    }

    public HistoryGame getHistoryGame() {
        return historyGame;
    }


    public abstract List<String> generateCharList();


    @Override
    public void start(Integer sizeWord, Integer attemptCounter, Conditions conditions) {
        if (!status.equals(GameStatus.RESTART)) {
            word = generateWord(sizeWord, conditions);
            maxAttempts = attemptCounter;
            wordSize = sizeWord;
            currentCondition = conditions;
        }
        status = GameStatus.START;
        this.attemptCounter = attemptCounter;
        historyGame = new HistoryGame();
    }

    @Override
    public void stop() {
        status = GameStatus.INIT;
    }

    @Override
    public void restart() {
        status = GameStatus.RESTART;
        start(wordSize, maxAttempts, currentCondition);
    }

    @Override
    public void exit() {
        status = GameStatus.EXIT;
    }


    @Override
    public Answer inputValue(String value) {
        if (!getGameStatus().equals(GameStatus.START))
            throw new RuntimeException("Игра не в активном состоянии");
        int cowCount = 0;
        int bullCount = 0;
        if (!value.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == value.charAt(i)) {
                    bullCount++;
                    cowCount++;
                } else if (word.contains(String.valueOf(value.charAt(i))))
                    cowCount++;
            }
        }
        --attemptCounter;
        if (bullCount == word.length()) {
            status = GameStatus.WIN;
        } else if (attemptCounter == 0) {
            status = GameStatus.LOSE;
        }
        Answer result = new Answer(attemptCounter, cowCount, bullCount);
        historyGame.addTurn(result, value);
        return result;
    }

    public abstract Integer getCharListSize();
    public abstract String getTypeGame();
    public String getHiddenWord(){
        return word;
    }
    public Integer getAttemptLeft(){
        return attemptCounter;
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }
}
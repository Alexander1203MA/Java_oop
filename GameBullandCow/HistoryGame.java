package GameBullandCow;
import java.util.LinkedHashMap;
import java.util.Map;


public class HistoryGame {
    private Map<Answer, String> turn;

    public HistoryGame() {
        turn = new LinkedHashMap<>();
    }

    public void addTurn(Answer answer, String value){
        turn.put(answer, value);
    }

    public void showHistory(){
        for (Answer answer:turn.keySet()){
            Integer attempt = answer.getAttemptCounter();
            Integer[] counters = answer.getCounters();
            System.out.printf("На %d ходу вы ввели слово '%s' и угадали %d символов при %d полных совпадениях%n",
                    attempt+1,
                    turn.get(answer),
                    counters[0],counters[1]);
        }
    }

}
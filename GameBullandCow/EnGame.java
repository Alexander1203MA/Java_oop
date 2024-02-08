package GameBullandCow;
import java.util.ArrayList;
import java.util.List;

public class EnGame extends AbstractGame{
    @Override
    public List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 'a'; i <= 'z' ; i++) {
            result.add(String.valueOf((char)i));

        }
        return result;
    }

    @Override
    public Integer getCharListSize() {
        return 26;
    }

    @Override
    public String getTypeGame() {
        return "'Игра с английским алфавитом'";
    }
}
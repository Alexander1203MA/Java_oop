package GameBullandCow;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final int debugMode = 1;

    public static final int maxWordSize = 5;
    public static String promptTypeGame = String.format("Выберите какие символы будут использоваться:%n" +
            "  1 - только цифры%n" +
            "  2 - только русский алфавит%n" +
            "  3 - только английский алфавит%n" +
            "  0 - завершить игру%n" +
            "Введите ответ: ");
    public static String promptCommand = String.format("Выберете действие:%n" +
            "  1 - начать новую игру%n" +
            "  2 - рестарт текущей игры%n" +
            "  3 - продолжить игру%n" +
            "  4 - показать историю текущей игры%n" +
            "  0 - завершить игру%n" +
            "Введите ответ: ");
    public static String promptConditions = String.format("Выберите режим игры:%n" +
            "  1 - только уникальные символы%n" +
            "  2 - символы могут повторятся%n" +
            "Введите ваш ответ: ");
    public static String promptContinue = String.format("Хотите продолжить игру?%n" +
            "  1 - Да%n" +
            "  2 - Нет%n" +
            "Выш выбор: ");

    public static String promptValue = "Введите %s";

   
    public static AbstractGame getTypeGame(int typeGame) {
        AbstractGame result;
        result = switch (typeGame) {
            case 1 -> new NumeralGame();
            case 2 -> new RuGame();
            case 3 -> new EnGame();
            default -> null;
        };
        return result;
    }

    public static int getAnswer(String prompt, Scanner scanner) {
        System.out.printf(prompt);
        int result = -999;
        try {
            result = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число!");
            String error = scanner.next();
            System.out.println(error);
        } catch (NoSuchElementException e) {
            System.out.println("Всё закончилось!");
        } catch (IllegalStateException e) {
            System.out.println("Невероятно!");
        }
        return result;

    }

 
    public static String getString(String prompt, Scanner scanner) {
        System.out.printf(prompt);
        String result = scanner.next();
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AbstractGame newGame = null;
        int userAnswer = -999;
        while (userAnswer != 0) {
            if (Objects.isNull(newGame) || newGame.getGameStatus().equals(GameStatus.INIT)){
                userAnswer=getAnswer(promptTypeGame, scanner);
            }
            newGame = getTypeGame(userAnswer);
            if (Objects.isNull(newGame)) {
                userAnswer = 0;
                continue;
            }
            Integer wordSize = getAnswer(String.format(promptValue, "размер загадываемого слова: "), scanner);
            Integer maxAttempts = getAnswer(String.format(promptValue, "количество попыток: "), scanner);
            Conditions conditions = switch (getAnswer(promptConditions, scanner)) {
                case 1 -> Conditions.UNIQUE_SYMBOLS;
                case 2 -> Conditions.NON_UNIQUE_SYMBOLS;
                default -> null;
            };
            if (checkParameters(newGame, wordSize, maxAttempts, conditions)) {
                newGame.start(wordSize, maxAttempts, conditions);
            }
            while (newGame.getGameStatus().equals(GameStatus.START)) {
                System.out.printf("Текущая игра %s. Осталось %d попыток.%n", newGame.getTypeGame(),newGame.getAttemptLeft());
                if (debugMode == 1){
                    System.out.printf("Загаданное слово %s%n", newGame.getHiddenWord());
                }
                userAnswer = getAnswer(promptCommand, scanner);
                switch (userAnswer) {
                    case 1:
                        System.out.println("Запускаю новую игру.");
                        newGame.stop();
                        break;
                    case 2:
                        newGame.restart();
                        break;
                    case 3:
                        String value = getString(String.format(promptValue, "Ваше загаданное слово: "), scanner);
                        Answer answer = newGame.inputValue(value);
                        System.out.println(answer);
                        System.out.println(newGame.getGameStatus());
                        if (!newGame.getGameStatus().equals(GameStatus.START)) {
                            userAnswer = getAnswer(promptContinue, scanner);
                            if (userAnswer == 1) {
                                newGame.stop();
                            } else {
                                newGame.exit();

                            }
                        }
                        break;
                    case 4:
                        HistoryGame history = newGame.getHistoryGame();
                        if (!Objects.isNull(history)) {
                            history.showHistory();
                        } else System.out.println("Истории игры в данный момент нет.");
                        break;
                    case 0:
                        newGame.exit();
                        break;
                    default:
                        System.out.println("Слишком много неправильных ответов");
                        break;

                }
            }
            if (newGame.getGameStatus().equals(GameStatus.EXIT)) userAnswer =0;
        }
        System.out.println("Завершаю текущую игру");
        scanner.close();
    }

    private static boolean checkParameters(AbstractGame game, Integer wordSize, Integer maxAttempts, Conditions conditions) {
        if (Objects.isNull(conditions)) return false;
        if (wordSize <= 0 || wordSize > maxWordSize) {
            System.out.printf("Размер загадываемого слова не может быть больше %d и меньше или равно нулю%n",
                    maxWordSize);
            return false;
        }
        return maxAttempts != 0;
    }
}
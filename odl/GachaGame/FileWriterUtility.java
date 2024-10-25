package GachaGame;
    import java.io.FileWriter;
    import java.io.IOException;
    public class FileWriterUtility {
        static void writeToFile(Toy[] toys, String filename) {
            try {
                FileWriter fileWriter = new FileWriter(filename);
                Lottery lottery = new Lottery(toys);
    
                for (int i = 0; i < 10; i++) {
                    String winnerId = lottery.getWinnerId();
                    Toy winnerToy = toys[Integer.parseInt(winnerId) - 1];
                    String line = "ID: " + winnerId + ", Название: " + winnerToy.name + ", Частота: " + winnerToy.frequency;
                    fileWriter.write(line + "\n");
                }
                fileWriter.close();
                System.out.println("Результаты записаны в файл " + filename);
            } catch (IOException e) {
                System.out.println("Произошла ошибка при записи в файл.");
                e.printStackTrace();
            }
        }
    }
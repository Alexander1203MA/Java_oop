package GachaGame;
public class Main {
    public static void main(String[] args) {
        String[] ids = {"1", "2", "3"};
        String[] names = {"Зеленый слоник", "Хороший парень (Chucky)", "Кукла (Эбигейл)"};
        int[] frequencies = {2, 3, 7};
        Toy[] toys = new Toy[ids.length];

        for (int i = 0; i < ids.length; i++) {
            toys[i] = new Toy(ids[i], names[i], frequencies[i]);
        }

        ToyQueue toyQueue = new ToyQueue(toys);
        System.out.println("Игрушки в порядке убывания частоты:");
        while (!toyQueue.isEmpty()) {
            Toy toy = toyQueue.poll();
            System.out.println("ID: " + toy.id + ", Название: " + toy.name + ", Частота: " + toy.frequency);
        }

        Lottery lottery = new Lottery(frequencies);
        String winnerId = lottery.getWinnerId();
        Toy winnerToy = toys[Integer.parseInt(winnerId) - 1];
        System.out.println("Победитель лотереи: ID: " + winnerId + ", Название: " + winnerToy.name + ", Частота: " + winnerToy.frequency);

        FileWriterUtility.writeToFile(toys, "Gacharesult.txt");
    }
}
package Relayrace;
/*
Домашнее задание:
1) Создайте три класса: Человек, Кот, Робот, которые не наследуются от одного класса но есть
общий класс родитель. Эти классы должны уметь бегать и прыгать, все также с выводом информации
о действии в консоль.
2) Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
(для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
3) Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
списку он препятствий не идет.
 */
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Размер команды для гонки
        int teamSize = 10;
        // Общее количество препятствий
        int obstaclesMaxCount = 5;
        Random rand = new Random();
        int invariant;
        List<Obstacles> obstacles = new ArrayList<>(obstaclesMaxCount);
        for (int i = 0; i < obstaclesMaxCount; i++) {
            // Здесь указывается количество видов препятствий
            //                         ||
            //                         \/
            invariant = rand.nextInt(2);
            switch (invariant) {
                case 0:
                    obstacles.add(new Treadmill());
                    break;
                case 1:
                    obstacles.add(new Barrier());
                    break;
            }

        }
        // Общий список персонажей участвующих в гонке
        List<Creature> athleticsTeam = new ArrayList<>(teamSize);
        for (int i = 0; i < teamSize; i++) {
            // Здест указывается количество видов персонажей
            //                          ||
            //                          \/
            invariant = rand.nextInt(3);
            switch (invariant) {
                case 0:
                    athleticsTeam.add(new Human());
                    break;
                case 1:
                    athleticsTeam.add(new Cat());
                    break;
                case 2:
                    athleticsTeam.add(new Robot());
                    break;
            }
        }
        for (Creature athlete : athleticsTeam) athlete.start();
        // Список race будет уменьшаться по мере выбытия персонажей из гонки
        List<Creature> race = new LinkedList<>(athleticsTeam);
        int count = 1;
        String name;
        String separator = "=========================================================================";
        for (Obstacles obstacle : obstacles) {
            name = switch (obstacle.getDirection()) {
                case horizontal -> "Дорожка длиной";
                case vertical -> "Барьер высотой";
            };
            System.out.println(separator);
            System.out.printf("Этап № %d. %s %d %s%n", count, name, obstacle.getDimension(), obstacle.getUnit());
            if (!race.isEmpty()) {
                int i = 0;
                while (i < race.size()) {
                    Creature athlete = race.get(i);
                    athlete.overcoming(obstacle);
                    if (!athlete.isContinue()) {
                        race.remove(athlete);
                    } else i++;
                }
            } else {
                break;
            }
            count++;

        }
        athleticsTeam.sort(new AthleteComparator());
        int place = 1;
        System.out.println(separator);
        System.out.println("ИТОГОВАЯ ТАБЛИЦА:");
        for (Creature athlete : athleticsTeam) {
            if (athlete.isContinue()) {
                System.out.printf("%s по имени %s занял %d место, пройдя дистанцию за %d сек.%n",
                        athlete.getClass().getTypeName(),
                        athlete.getName(),
                        place++,
                        athlete.finish());
                System.out.println(athlete.getInfo());
            } else System.out.printf("%s по имени %s сошел с дистанции%n",
                    athlete.getClass().getTypeName(),
                    athlete.getName());

        }
        System.out.println(separator);

    }
}

class AthleteComparator implements Comparator<Creature> {
    @Override
    public int compare(Creature a, Creature b) {
        return a.time < b.time ? -1 : a.time == b.time ? 0 : 1;
    }
}
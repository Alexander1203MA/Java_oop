package controller;

import model.Cat;
import model.Dog;
import model.Hamster;
import service.DataPets;
import service.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Requests req;
    private DataPets dp;

    public enum Type {Cat, Dog, Hamster};
    public Controller() {
        req = new Requests();
        dp = new DataPets();
    }

    String menu1 = "\n Меню:" +
            "\n 1. Показать список" +
            "\n 2. Добавить животное" +
            "\n 3. Добавить команду" +
            "\n 4. Показать список команд" +
            "\n 5. Показать количество животных" +
            "\n 6. Выход" +
            "\n " +
            "\n Выберите необходимый пункт: ";

    private Type menuAddPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "\n1. Кошка" +
                        "\n2. Собака" +
                        "\n3. Хомяк" +
                        "\n4. Выход" +
                        "\n " +
                        "\nВыберите необходимый пункт: ");

        while (true) {
            String key = scanner.next();
            switch (key){
                case "1":
                    return Type.Cat;
                case "2":
                    return Type.Dog;
                case "3":
                    return Type.Hamster;
                case "4":
                    return null;
                default:
                    System.out.println("Некорректный ввод.");
                    break;
            }
        }
    }
    String menu3 = "\n1. Да" +
            "\n2. Нет" +
            "\n " +
            "\nВыберите необходимый пункт: ";
    public void start() throws Exception {
        boolean flag = true;

        while (flag) {
            int cmd = req.getInteger(menu1);
            switch (cmd){
                case 1:
                    getAllPets();
                    break;
                case 2:
                    Type type = menuAddPet();
                    if (type != null){
                        addPet(type);
                    }
                    break;
                case 3:
                    Type type1 = menuAddPet();
                    if (type1 != null){
                        addCommand(type1);
                    }
                    break;
                case 4:
                    Type type2 = menuAddPet();
                    if (type2 != null){
                        getPetCommands(type2);
                    }
                    break;
                case 5:
                    countPet();
                    break;
                case 6:
                    System.out.println("До встречи!");
                    flag=false;
                    break;
                default:
                    System.out.println("Такого варианта нет. Попробуйте еще раз.");
                    break;
            }
        }
    }
    public void countPet() throws Exception {
        Counter counter = new Counter();

        System.out.println("В питомнике " + counter.getCount().toString() + "шт животных.");
    }
    public void addPet (Type petType) throws Exception{
        try (Counter counter = new Counter()) {
            counter.add();
        }
        String name = req.getString("Введите имя животного: ");
        int age = req.getInteger("Введите возраст животного: ");
        String color = req.getString("Введите окрас животного: ");


        List<String> commands = new ArrayList<>();
        System.out.println("Добавить команды?");
        int menu = req.getInteger(menu3);
        while (menu == 1) {
            String command = req.getString("Введите команду: ");
            commands.add(command);
            System.out.println("Ввести еще одну команду?");
            menu = req.getInteger(menu3);
        }

        switch (petType) {
            case Cat -> dp.addPet(new Cat(name, age, color, commands));
            case Dog -> dp.addPet(new Dog(name, age, color, commands));
            case Hamster -> dp.addPet(new Hamster(name, age, color, commands));
        }
    }
    public void getAllPets() {
        List<Object> pets = dp.getAllPets();
        for (Object o : pets) {
            System.out.println(o.toString());
        }
    }
    private void addCommand(Type petType) {
        String name = req.getString("Введите имя животного: ");
        Object obj = null;

        switch (petType){
            case Cat -> obj = dp.findCat(name);
            case Dog -> obj = dp.findDog(name);
            case Hamster -> obj = dp.findHamster(name);
        }

        if(obj == null) {
            System.out.println("Такое животное не найдено.");
        }
        else{
            String command = req.getString("Введите новую команду: ");

            switch (petType) {
                case Cat -> ((Cat)obj).addCommand(command);
                case Dog -> ((Dog)obj).addCommand(command);
                case Hamster -> ((Hamster)obj).addCommand(command);
            }
        }
    }
    private void getPetCommands(Type petType) {
        String name = req.getString("Введите имя животного: ");

        Object o = null;

        switch (petType){
            case Cat -> o = dp.findCat(name);
            case Dog -> o = dp.findDog(name);
            case Hamster -> o = dp.findHamster(name);
        }

        if(o == null) {
            System.out.println("Такое животное не найдено.");
            return;
        }

        List<String> commands = null;

        switch (petType) {
            case Cat -> commands = ((Cat)o).getCommandList();
            case Dog -> commands = ((Dog)o).getCommandList();
            case Hamster -> commands = ((Hamster)o).getCommandList();
        }

        System.out.println(commands);
    }
}
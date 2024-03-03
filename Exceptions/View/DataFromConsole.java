package Exceptions.View;

import java.util.Scanner;

public class DataFromConsole implements DataInterface{

    public String dataInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате Фамилия Имя Отчество дата _ рождения номер _ телефона и пол разделенные пробелом:");
        return scanner.nextLine();
    }
}
package controller;
import java.util.Scanner;

public class Requests {
    public String getString(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        return scanner.next();
    }
    public int getInteger(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        return scanner.nextInt();
    }
}
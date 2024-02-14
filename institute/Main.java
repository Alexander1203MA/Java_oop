package institute;

/*Создать package – service. Работу продолжаем в нем
� Создать класс DataService с методами в по управлению сущностями User
        (create, read) и агрегирующий всех пользователей заведенных в системе
� StudentId должны быть созданы по алгоритму – максимальный id в
коллекции + 1. Аналогично и для TeacherId. Здесь решение через перебор
элементов и instanceOf*/

import institute.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
package institute;

/*— Создать класс УчебнаяГруппа, содержащий в себе поля Преподаватель и список Студентов;
— Создать класс УчебнаяГруппаСервис, в котором реализована функция (входные параметры - (Teacher, List<Strudent>)) формирования из Студентов и Преподавателя УчебнойГруппы и возвращения его;
— Создать метод в Контроллере, в котором агрегируются функции получения списка студентов (их id) и преподавателя (его id) и формирования учебной группы, путём вызова метода из сервиса;
— Всё вышеуказанное создать согласно принципам ООП, пройдённым на семинаре.
*/

import institute.controller.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Controller Controller = new Controller();

        Controller.createTeacher("Якушев", "Иван", "Олегович");
        Controller.createTeacher("Калайчук", "Любовь", "Александровна");
        Controller.createStudent("Скоромор", "Иван", "Антонович");
        Controller.createStudent("Крылова", "Анастасия", "Юрьевна");
        Controller.createStudent("Кувичко", "Мария", "Архипова");
        Controller.createStudent("Кузьмин", "Дмитрий", "Иванович");
        Controller.createStudent("Оскаль", "Сергей", "Боловолич");
        Controller.createStudent("Тихонов", "Максим", "Миронович");
        Controller.createStudent("Клейн", "Алекс", "Валивич");

        Controller.printGroupLearn(Controller.createGroupLearn(2, 2, 4, 5, 7));
    
        System.out.println();
    }
}
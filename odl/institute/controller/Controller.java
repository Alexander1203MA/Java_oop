package institute.controller;

import institute.model.*;
import institute.service.DataService;
import institute.service.GroupLearnService;
import institute.view.StudentView;

import java.util.ArrayList;
import java.util.List;

import Calculator.ListView;

public class Controller {
    static DataService service = new DataService();
    static GroupLearnService groupLearnService = new GroupLearnService();
    StudentView studentView = new StudentView();

    public static void createStudent (String secondName, String firstName, String lastName) {
        service.create(Type.STUDENT, secondName, firstName, lastName);
    }

    public static void createTeacher (String secondName, String firstName, String lastName) {
        service.create(Type.TEACHER, secondName, firstName, lastName);
    }

    public static GroupLearn createGroupLearn (int teacherId, int... studentIds) {
        Teacher teacher = getTeacherById(teacherId);
        List<Student> studentsList = getStudentsByIds(studentIds);
        return groupLearnService.createGroupLearn(teacher, studentsList);
    }

    private static Teacher getTeacherById(int teacherId) {
        for (User user: service.getUsersList()) {
            if (user instanceof Teacher && ((Teacher) user).getTeacherId() == teacherId)
                return (Teacher) user;
        }
        return null;
    }

    private static List<Student> getStudentsByIds (int... studentIds) {
        List<Student> studentsListGroup = new ArrayList<>();
        for (int id: studentIds) {
            Student student = getStudentById(id);
            if (student != null) {
                studentsListGroup.add(student);
            }
        }
        return studentsListGroup;
    }

    private static Student getStudentById (int studentId){
        for (Student student: getStudentsList()) {
            if (student.getStudentId() == studentId)
                return student;
        }
        return null;
    }

    public static List<Student> getStudentsList () {
        List<Student> studentsList = new ArrayList<>();

        for (User user: service.getUsersList()) {
            if (user instanceof Student)
                studentsList.add((Student) user);
        }
        return studentsList;
    }

    public void printStudentsList (List<Student> studentsList) {
        for (Student student: studentsList) {
            studentView.printStudent(student);
        }
    }

    public static void printGroupLearn (GroupLearn groupLearn) {
        System.out.println(groupLearn);
    }
    public void runCalc() {
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

 
    }

}
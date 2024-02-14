package institute.view;

import institute.model.Student;

import java.util.List;

public class StudentView {
    public void printListStudents(List<Student> listStudents) {
        System.out.println("Все студенты: \n" + listStudents);
    }
}
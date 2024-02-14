package institute.view;

import institute.model.Teacher;

import java.util.List;

public class TeacherView {
    public void printListTeachers(List<Teacher> listTeachers) {
        System.out.println("Все учителя: \n" + listTeachers);
    }
}
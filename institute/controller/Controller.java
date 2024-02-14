package institute.controller;

import institute.model.Student;
import institute.model.Teacher;
import institute.model.User;
import institute.service.DataStudent;
import institute.service.DataTeacher;
import institute.view.StudentView;
import institute.view.TeacherView;

import java.util.List;

public class Controller {
    private final DataStudent dataStudent;
    private final DataTeacher dataTeacher;
    private final StudentView studentView;
    private final TeacherView teacherView;

    public void start() {
        User u1 = new Student(21, "Александр", 4.5);
        User u2 = new Teacher(45, "Василий", "Математика");
        User u3 = new Student(22, "Иван", 4.5);
        createStudent(u1);
        createTeacher(u2);
        createStudent(u3);
        List<Student> studentList = dataStudent.read();
        List<Teacher> teacherList = dataTeacher.read();
        studentView.printListStudents(studentList);
        teacherView.printListTeachers(teacherList);
    }

    public Student createStudent(User user) {
        return dataStudent.create(user);
    }

    public Teacher createTeacher(User teacher) {
        return dataTeacher.create(teacher);
    }

    public Controller() {
        dataStudent = new DataStudent();
        dataTeacher = new DataTeacher();
        studentView = new StudentView();
        teacherView = new TeacherView();
    }

}
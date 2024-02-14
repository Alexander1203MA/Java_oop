package institute.service;

import institute.model.Student;
import institute.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataStudent implements ServiceStudent{
    List<Student> listStudents = new ArrayList<>();

    @Override
    public Student create(User user) {
        Student student = (Student) user;
        student.setStudentId(listStudents.size() + 1);
        listStudents.add(student);
        return student;
    }

    @Override
    public List<Student> read() {
        return listStudents;
    }
}
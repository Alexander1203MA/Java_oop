package institute.service;

import institute.model.Student;
import institute.model.Teacher;
import institute.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataTeacher implements ServiceTeacher{
    List<Teacher> listTeachers = new ArrayList<>();
    @Override
    public Teacher create(User user) {
        Teacher teacher = (Teacher) user;
        teacher.setTeacherId(listTeachers.size() + 1);
        listTeachers.add(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> read() {
        return listTeachers;
    }
}
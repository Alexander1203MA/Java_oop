package institute.service;

import institute.model.Student;
import institute.model.User;

import java.util.List;

public interface ServiceStudent {
    Student create(User user);
    List<Student> read();
}
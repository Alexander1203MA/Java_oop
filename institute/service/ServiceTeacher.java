package institute.service;

import institute.model.Teacher;
import institute.model.User;

import java.util.List;

public interface ServiceTeacher {
    Teacher create(User user);
    List<Teacher> read();
}
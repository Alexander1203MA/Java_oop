package institute.service;

import institute.model.Student;
import institute.model.GroupLearn;
import institute.model.Teacher;
import java.util.List;

public class GroupLearnService {
    public GroupLearn createGroupLearn (Teacher teacher, List<Student> studentsList) {
        return new GroupLearn(teacher, studentsList);
    }
}
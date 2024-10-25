package institute.model;

import java.util.List;

public class GroupLearn {
    private Teacher teacher;
    private List<Student> studentsList;


    public GroupLearn(Teacher teacher, List<Student> studentsList) {
        this.teacher = teacher;
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "GroupLearn{" +
                "teacher=" + teacher +
                ", studentsList=" + studentsList +
                '}';
    }
}
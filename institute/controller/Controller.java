package institute.controller;

import institute.model.*;
import institute.service.DataService;
import institute.service.GroupLearnService;
import institute.view.StudentView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    DataService service = new DataService();
    GroupLearnService groupLearnService = new GroupLearnService();
    StudentView studentView = new StudentView();

    public void createStudent (String secondName, String firstName, String lastName) {
        service.create(Type.STUDENT, secondName, firstName, lastName);
    }

    public void createTeacher (String secondName, String firstName, String lastName) {
        service.create(Type.TEACHER, secondName, firstName, lastName);
    }

    public GroupLearn createGroupLearn (int teacherId, int... studentIds) {
        Teacher teacher = getTeacherById(teacherId);
        List<Student> studentsList = getStudentsByIds(studentIds);
        return groupLearnService.createGroupLearn(teacher, studentsList);
    }

    private Teacher getTeacherById(int teacherId) {
        for (User user: service.getUsersList()) {
            if (user instanceof Teacher && ((Teacher) user).getTeacherId() == teacherId)
                return (Teacher) user;
        }
        return null;
    }

    private List<Student> getStudentsByIds (int... studentIds) {
        List<Student> studentsListGroup = new ArrayList<>();
        for (int id: studentIds) {
            Student student = getStudentById(id);
            if (student != null) {
                studentsListGroup.add(student);
            }
        }
        return studentsListGroup;
    }

    private Student getStudentById (int studentId){
        for (Student student: getStudentsList()) {
            if (student.getStudentId() == studentId)
                return student;
        }
        return null;
    }

    public List<Student> getStudentsList () {
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

    public void printGroupLearn (GroupLearn groupLearn) {
        System.out.println(groupLearn);
    }
}
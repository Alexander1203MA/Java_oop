package institute.model;

public class Teacher extends User{
    private Integer teacherId;

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    private final String subject;
    public Teacher (Integer age, String name, String subject) {
        super(age, name);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
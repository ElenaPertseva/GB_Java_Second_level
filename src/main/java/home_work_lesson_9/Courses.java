package home_work_lesson_9;

public class Courses extends Course {
    private String courseName;
    private String teacherName;

    public Courses(String courseName, String teacherName) {
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public Courses() {
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }
}

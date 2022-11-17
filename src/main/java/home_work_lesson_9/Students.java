package home_work_lesson_9;

import java.util.List;

public class Students implements Student {
    private String name;
    private List<Course> studentCourses;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }
    public void setStudentCourses(List<Course> studentCourses) { this.studentCourses = studentCourses;}

    public Students(String name) {
        this.name = name;
    }

}

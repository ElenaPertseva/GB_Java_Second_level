package home_work_lesson_9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Courses physicsM = new Courses("Право", "Андреев");
        Courses physicsT = new Courses("Психология", "Пугачева");
        Courses physicsN = new Courses("Экономика","Сидоров");
        Courses chemistry = new Courses("Теория выживания", "Дрелин");
        Courses theoryOfGames = new Courses("Философия", "Агеева");
        Courses notCourse = new Courses("Empty", "Empty");
        Courses math = new Courses("Литература", "Любочкин");

        Students student1 = new Students("Петров");
        List<Course> student1Courses = new ArrayList<>();
        student1Courses.add(physicsM);
        student1Courses.add(chemistry);
        student1Courses.add(math);
        student1.setStudentCourses(student1Courses);

        Students student2 = new Students("Матвеева");
        List<Course> student2Courses = new ArrayList<>();
        student2Courses.add(physicsM);
        student2Courses.add(physicsN);
        student2Courses.add(physicsT);
        student2.setStudentCourses(student2Courses);

        Students student3 = new Students("Киреев");
        List<Course> student3Courses = new ArrayList<>();
        student3Courses.add(theoryOfGames);
        student3Courses.add(math);
        student3Courses.add(physicsM);
        student3Courses.add(physicsT);
        student3.setStudentCourses(student3Courses);
    }
}

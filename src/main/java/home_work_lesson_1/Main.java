package home_work_lesson_1;

import home_work_lesson_1.obstacles.Course;
import home_work_lesson_1.obstacles.Cross;
import home_work_lesson_1.obstacles.Obstacle;
import home_work_lesson_1.obstacles.Water;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Джек"), new Cat("Муся"), new Dog("Тори")};
        Obstacle[] obstacles = {new Cross(100), new Water(50)};

        Team team = new Team("Создаем команду", competitors);
        System.out.println(team.getTeamName());
        team.showResults();
        Course course = new Course(obstacles);
        System.out.println("Команды идут на старт");
        course.doIt(team);
        team.showResults();
        System.out.println("Участники завершили соревнования");
        team.showMembersFinishedCourse();

    }
}

package home_work_lesson_1;

public class Human implements Competitor{
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    boolean onDistance;

    public Human(String джек) {
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void run(int distance) {
        if (distance >= maxRunDistance) {
            System.out.println(name + " " + " успешно справился с забегом");
        } else {
            System.out.println(name + " " + " не смог преодолеть забег");
            onDistance = false;
        }
    }
    public void swim(int distance){
        if (distance <= maxSwimDistance) {
            System.out.println(name + " " + " успешно проплыл дистанцию");
        } else {
            System.out.println(name + " " + " не смог проплыть дистанцию");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {

    }

    public void showResult() {
        System.out.println(name + ": " + onDistance);
    }
}

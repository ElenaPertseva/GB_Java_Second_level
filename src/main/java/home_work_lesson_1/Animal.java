package home_work_lesson_1;

public abstract class Animal implements Competitor {
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public void run(int distance) {
        if (distance >= maxRunDistance) {
            System.out.println("Тип" + " " + type + " " + name + " " + "забег успешо пройден");
        } else {
            System.out.println("Тип" + " " + type + " " + name + " " + "забег завершился неудачно");
            onDistance = false;
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println("Тип" + " " + type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (distance >= maxSwimDistance) {
            System.out.println("Тип" + " " + type + " " + name + " " + " успешно проплыл дистанцию");
        } else {
            System.out.println("Тип" + " " + type + " " + name + " " + " не смог проплыть дистанцию");
            onDistance = false;
        }
    }

    public void showResult() {
        System.out.println("Тип" + " " + type + " " + name + ": " + onDistance);
    }
}

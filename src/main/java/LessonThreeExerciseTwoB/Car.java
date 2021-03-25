package main.java.LessonThreeExerciseTwoB;

public class Car {
    String model;
    int speed;

    public Car(int speed, String model) {
        this.speed = speed;
        this.model = model;
    }

    public void move() {
        System.out.println("Поехали!");
    }

    public void stop() {
        System.out.println("Останавливаемся.");
    }

    public void helloOwner() {
        System.out.println("Приветствую вас, хозяин! Не бейте меня.");
    }
}

package main.java.LessonThreeExerciseTwoB;

public class Wheel {
    int diameter;
    String type;
    String manufacturer;

    public Wheel(int diameter, String type, String manufacturer) {
        this.diameter = diameter;
        this.type = type;
        this.manufacturer = manufacturer;
    }

    // в случайный момент, колесо машины может износиться и программа остановится.
    public void wearOut() {
        int y = (int) (Math.random() * 30);
        if (y < 5) {
            System.out.println("Тревога! Обнаружен износ колес. Движение невозможно.");
            System.out.println("Как жаль.");
            System.exit(0);
        }
    }

    public void leaveAMark() {
        System.out.println("Я оставил след на дороге. Впредь стоит вести аккуратнее.");
    }
}
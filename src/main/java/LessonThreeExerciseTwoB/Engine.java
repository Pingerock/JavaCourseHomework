package main.java.LessonThreeExerciseTwoB;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

public class Engine {
    int power;
    int piston_count;
    int weight;

    public Engine(int power, int piston_count, int weight) {
        this.power = power;
        this.piston_count = piston_count;
        this.weight = weight;
    }

    public void start() {
        System.out.println("*Звук завода мотора*");
    }

    public void work() {
        System.out.println("*Звук рева мотора*");
    }

    //я хотел побаловаться и вместо "sout" вызываю системные звуки.
    public void makeASound() {
        Toolkit.getDefaultToolkit().beep();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toolkit.getDefaultToolkit().beep();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toolkit.getDefaultToolkit().beep();
    }
}
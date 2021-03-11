package main.java;

import java.util.Scanner;

public class LessonOneExersiceOneB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        int x = scanner.nextInt();

        if (x >= 0) {
            System.out.println("Положительное число: " + ++x);
        } else {
            System.out.println("Отрицательное число: " + x);
        }
        scanner.close();
    }
}

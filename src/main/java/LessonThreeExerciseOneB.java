package main.java;

import java.util.Scanner;

public class LessonThreeExerciseOneB {
    public static void main(String[] args) {
        //вкратце: это конвертер длины отрезка в метры
        Scanner scanner = new Scanner(System.in);
        int distance, metric;
        double result = 0;
        System.out.print("Введите длину отрезка: ");
        distance = scanner.nextInt();
        System.out.println("Выберите единицу измерения: ");
        System.out.println("1 - дециметр. ");
        System.out.println("2 - километр. ");
        System.out.println("3 - метр. ");
        System.out.println("4 - милиметр. ");
        System.out.println("5 - сантиметр. ");
        metric = scanner.nextInt();
        switch (metric) {
            case 1 -> {
                result = distance * 0.1;
                System.out.println("Вы ввели длину " + distance + " дм.");
            }
            case 2 -> {
                result = distance * 1000;
                System.out.println("Вы ввели длину " + distance + " км.");
            }
            case 3 -> {
                result = distance;
                System.out.println("Вы ввели длину " + distance + " м.");
            }
            case 4 -> {
                result = distance * 0.0001;
                System.out.println("Вы ввели длину " + distance + " мм.");
            }
            case 5 -> {
                result = distance * 0.01;
                System.out.println("Вы ввели длину " + distance + " см.");
            }
            default -> System.err.println("Неправильный ввод!");
        }
        System.out.println("Введенная длина равна " + result + " м.");
        scanner.close();
    }
}

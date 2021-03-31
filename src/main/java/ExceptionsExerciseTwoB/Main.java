package main.java.ExceptionsExerciseTwoB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На какое число хотите поделить десятку? Не выбирайте ноль.");
        int x = scanner.nextInt();
        try {
            if (x == 0) {
                throw new DivineByZeroException("Дурак. Получится число, стремящееся к бесконечности. Так нельзя.", x);
            }
        } catch (DivineByZeroException dbze) {
            System.err.println(dbze.getMessage());
            System.err.println(dbze.getNumber());
            return;
        }
        int y = 10 / x;
        System.out.println(y);
    }
}

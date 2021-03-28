package main.java.LessonThreeExerciseThreeB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        System.out.println("Введите количество игроков(максимум игроков: 10): ");
        x = scanner.nextInt();
        if (x == 1) {
            System.out.println("Играть одному не весело. Найди себе друзей.");
            return;
        }
        if ((x > 10) || (x <= 0)) {
            System.err.println("Ошибка! Недопустимое кол-во игроков.");
            return;
        }
        System.out.println("Количество игроков: " + x);
        System.out.println("Начинаем раздачу.\n");
        Deal deal = new Deal();
        deal.makeADeck();
        deal.cardDeal(x);
    }
}

package main.java;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CollectionsExerciseOneB {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите вместимость коллекции: ");
        int x = scanner.nextInt();
        for (int i = 0; i < x; i++) {
            int y = random.nextInt() + 99;
            list.add(y);
        }
        long result = 1;
        for (Integer number : list) {
            result *= number;
        }
        System.out.println("Результат произведения элементов коллекции: " + result);
    }
}

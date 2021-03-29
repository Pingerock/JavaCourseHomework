package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CollectionsExerciseThreeB {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(20);
        Random random = new Random();
        //генерируем коллекцию чисел
        for (int i = 0; i < 20; i++) {
            int y = random.nextInt(100);
            list.add(y);
        }
        System.out.print("Сгенерированный список: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        //сортируем по возрастанию
        Collections.sort(list);
        System.out.print("\nОтсортированный список: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        //счётчик повторяющихся чисел
        int duplicateCount = 0;
        //коллекция содержащих себе по образцу повторяющегося числа
        ArrayList<Integer> duplicateNumbers = new ArrayList<>();
        //цикл вычисления повторяющихся чисел
        for (int i = 1; i < list.size() - 1; i++) {
            int x = list.get(i);
            int y = list.get(i + 1);
            int z = list.get(i - 1);
            if ((x == y) || (x == z)) {
                if (((x == z) && (i == 1)) || ((x == y) && (i == list.size() - 2))) {
                    duplicateCount++;
                }
                duplicateCount++;
                if (duplicateNumbers.isEmpty()) {
                    duplicateNumbers.add(x);
                } else {
                    for (int j = 0; j < duplicateNumbers.size(); j++) {
                        int x1 = duplicateNumbers.get(j);
                        if (x == x1) {
                            break;
                        }
                        if ((x != x1) && (j == duplicateNumbers.size() - 1)) {
                            duplicateNumbers.add(x);
                        }
                    }
                }
            }
        }
        //вывод
        System.out.println("\nКоличество повторяющихся чисел: " + duplicateCount);
        System.out.print("Повторяющиеся числа: ");
        if (duplicateNumbers.isEmpty()) {
            System.err.println("Повторяющихся чисел не было сгенерировано.");
            return;
        }
        for (Integer numbers : duplicateNumbers) {
            System.out.print(numbers + " ");
        }
    }
}

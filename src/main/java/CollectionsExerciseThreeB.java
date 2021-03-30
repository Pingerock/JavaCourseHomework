package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

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
        Set<Integer> duplicateNumbers = new HashSet<>();
        //цикл вычисления повторяющихся чисел
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j <list.size() ; j++) {
                if(list.get(i).equals(list.get(j))){
                    duplicateCount++;
                    if(!duplicateNumbers.contains(list.get(j))){
                        duplicateCount++;
                        duplicateNumbers.add(list.get(j));
                    }
                }else {
                    i = j-1;
                    break;
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

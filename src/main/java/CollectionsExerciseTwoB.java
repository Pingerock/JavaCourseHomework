package main.java;

import java.util.ArrayList;
import java.util.Random;

public class CollectionsExerciseTwoB {
    public static void main(String[] args) {
        //коллекция с указанной вместимостью в 20 элементов
        ArrayList<Integer> list = new ArrayList<>(20);
        //коллекция с результатами сложения соседних элементов
        ArrayList<Integer> results = new ArrayList<>();
        Random random = new Random();
        //генерируем элементы коллекции случайным образом
        for (int i = 0; i < 20; i++) {
            int y = random.nextInt(100);
            list.add(y);
        }
        //границы соседних элементов коллекции для сложений
        int startIndex = 0;
        int endIndex = 4;
        //цикл, в котором выполняется сложение элементов
        //с каждой итерацией границы перемещаются на единицу
        //результат сложения сохраняется во второй коллекции
        for (; ; ) {
            int result = 0;
            for (int i = startIndex; i <= endIndex; i++) {
                result += list.get(i);

            }
            results.add(result);
            startIndex++;
            endIndex++;
            if (endIndex == list.size()) {
                break;
            }
        }
        //сравниваем результаты сложения друг с другом, вычисляя максимальный результат
        int maxResult = 0;
        for (Integer result : results) {
            if (result > maxResult) {
                maxResult = result;
            }
        }
        //определяем элементы, поучаствовавшии в сложении максимального результат
        int maxIndex = results.indexOf(maxResult);
        startIndex = maxIndex;
        endIndex = maxIndex + 4;
        System.out.print("Сгенерированный список: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\nПять соседних элементов: ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\nМаксимальное значение: " + maxResult);
    }
}

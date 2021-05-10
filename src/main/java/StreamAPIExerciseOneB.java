package main.java;

import java.util.ArrayList;

public class StreamAPIExerciseOneB {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int y = (int) (Math.random() * 100 + 1);
            list.add(y);
        }
        System.out.println("Результат умножения сгенерированных чисел на 2:");
        list.stream().map(x -> x * 2).forEach(System.out::println);
    }
}

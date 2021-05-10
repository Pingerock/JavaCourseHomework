package main.java;

import java.util.ArrayList;

public class ThreadExerciseTwoB {

    public static void main(String[] args) {
        int[] numbers1 = new int[20];
        System.out.println("Сгенерированный первый массив: ");
        for (int a = 0; a < numbers1.length; a++) {
            numbers1[a] = (int) (Math.random() * 100 + 1);
            System.out.print(numbers1[a] + " ");
        }
        ThreadRepeatNumber t1 = new ThreadRepeatNumber(numbers1);
        try {
            t1.getThread().join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка!");
        }
        System.out.println("\nИндексы четных чисел из первого массива, начиная с нуля: ");
        ArrayList<Integer> numbers2 = t1.indexes;
        for (int i : numbers2) {
            System.out.print(i + " ");
        }
    }
}

class ThreadRepeatNumber implements Runnable {
    private Thread thr;
    private int[] numbers;
    public ArrayList<Integer> indexes = new ArrayList<>();

    public ThreadRepeatNumber(int[] numbers) {
        this.numbers = numbers;
        thr = new Thread(this, "Thread");
        thr.start();
    }

    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                indexes.add(i);
            }
        }
    }

    public Thread getThread() {
        return thr;
    }

}

package main.java;

public class AnonInnerLambdaExerciseTwoB {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int a = 0; a < array.length; a++) {
            array[a] = (int) (Math.random() * 100 + 1);
        }
        int maxEvenNumber = 0;
        System.out.println("Сгенерированный массив: ");
        for (int a = 0; a < array.length; a++) {
            System.out.print(array[a] + " ");
            if (a % 10 == 9) {
                System.out.print("\n");
            }
            if (array[a] > maxEvenNumber && array[a] % 2 == 0) {
                maxEvenNumber = array[a];
            }
        }
        System.out.println("Максимальное четное число в данном массиве = " + maxEvenNumber);
    }
}

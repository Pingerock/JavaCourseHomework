package main.java.ExceptionsExerciseOneB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Представляю вам программу, которую незачем запускать, кроме намеренных разочарований
        //в которых виноват только разработчик(, то есть я :) )
        int x = 0;
        int[] y = new int[2];
        Object z = null;
        String str = "123aef2";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какое исключение хотите вызвать?");
        System.out.println("Непроверяемые исключения: ");
        System.out.println("\t1 - ArithmeticException");
        System.out.println("\t2 - IndexOutOfBoundException");
        System.out.println("\t3 - IllegalArgumentException");
        System.out.println("\t4 - NullPointerException");
        System.out.println("\t5 - NumberFormatException");
        System.out.println("Проверяемые исключения: ");
        System.out.println("\t6 - CloneNotSupportedException");
        System.out.println("\t7 - InterruptedException");
        System.out.println("\t8 - ClassNotFoundException");
        int x1 = scanner.nextInt();
        switch(x1){
            case 1:
                int result = 10/x;
                break;
            case 2:
                int result = y[3];
                break;
            case 3:
                IllegalArgument(x1);
                break;
            case 4:
                boolean x3 = str.equals(z);
                break;
            case 5:
                int x4 = (int)str;
                break;
            case 6:
                Human human = new Human("Chicken");
                Human human1 = (Human)human.clone();
                break;
            case 7:
                Thread.currentThread().interrupt();
                if(Thread.interrupted()){
                    throw new InterruptedException();
                }
                break;
            case 8:
                Class.forName(testing);
                break;
        }
    }

    public static void IllegalArgument(String f){
        System.out.println("F");
    }
}

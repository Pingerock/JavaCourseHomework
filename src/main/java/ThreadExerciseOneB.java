package main.java;

import java.util.Arrays;

public class ThreadExerciseOneB {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 3, 4, 5, 6, 1, 1, 7, 3, 8, 9, 0, 1};
        ThreadRepeatNumber t1 = new ThreadRepeatNumber(numbers);
        try{
            t1.getThread().join();
        } catch (InterruptedException e){
            System.err.println("Ошибка!");
        }

        System.out.println("Число с максимальным количеством повторений: " + t1.getNumberWithMaxRepeats());
        System.out.println("Количество повторений: " + t1.getMaxRepeats());
    }
}

class ThreadRepeatNumber implements Runnable {
    private Thread thr;
    private int[] numbers;
    private int maxRepeat=0;
    private int numberWithMaxRepeats = 0;
    private int repeatCount=1;

    public ThreadRepeatNumber(int[] numbers) {
        this.numbers = numbers;
        thr = new Thread(this, "ThreadRepeater");
        thr.start();
    }

    public void run() {
        Arrays.sort(numbers);
        numberWithMaxRepeats = numbers[0];
        for(int i = 0; i < numbers.length;i++){
            if(i+1 == numbers.length){
                break;
            }
            if(numbers[i] == numbers[i+1]){
                repeatCount++;
            } else {
                if(repeatCount > maxRepeat){
                    maxRepeat = repeatCount;
                    numberWithMaxRepeats = numbers[i];
                }
                repeatCount = 1;
            }
        }
    }

    public Thread getThread(){
        return thr;
    }

    public int getNumberWithMaxRepeats(){
        return numberWithMaxRepeats;
    }

    public int getMaxRepeats(){
        return maxRepeat;
    }
}

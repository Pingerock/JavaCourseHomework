package main.java.ExceptionsExerciseTwoB;

public class DivineByZeroException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public DivineByZeroException(String message, int num) {
        super(message);
        number = num;
    }
}
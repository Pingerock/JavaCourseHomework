package main.java;

public class StringsExerciseTwoB {
    public static void main(String[] args) {
        String str = "1j2h5oj24nyiubdonvh2o3in8ehrfv0ijk3[2o08efj";
        int count = 0;
        char letter;
        for (int i = 0; i < str.length(); i++) {
            letter = str.charAt(i);
            if (Character.isDigit(letter)) {
                count++;
            }
        }
        System.out.println("Кол-во цифр: " + count);
    }
}

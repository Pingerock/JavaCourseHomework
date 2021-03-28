package main.java;

public class StringsExerciseThreeB {
    public static void main(String[] args) {
        String str1 = "Программирование";
        String str2 = "Микрокомпьютер";
        String arrayOfLetters = " ";
        String result = "";
        //Цикл, который создает строку символов в str1 без повторений
        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i);
            for (int j = 0; j < arrayOfLetters.length(); j++) {
                char b = arrayOfLetters.charAt(j);
                if (a == b) {
                    break;
                }
                if ((j == arrayOfLetters.length() - 1) && (a != b)) {
                    arrayOfLetters = arrayOfLetters.concat(Character.toString(a));
                }
            }
        }
        //Переводим все символы строки символов в нижний регистр, чтобы не было проблем со сравнением
        //символов с разными регистрами
        arrayOfLetters = arrayOfLetters.toLowerCase();
        //Цикл, который проверяет совпадение символов первой строки с символами второй строки
        for (int i = 1; i < arrayOfLetters.length(); i++) {
            char a = arrayOfLetters.charAt(i);
            for (int j = 0; j < str2.length(); j++) {
                char b = str2.charAt(j);
                if (a == b) {
                    result = result.concat("Да ");
                    break;
                }
                if ((j == str2.length() - 1) && (a != b)) {
                    result = result.concat("Нет ");
                }
            }
        }
        System.out.println("Первое слово: " + str1);
        System.out.println("Второе слово: " + str2);
        System.out.println("Символы первого слова:" + arrayOfLetters);
        System.out.println("Повторения символов: " + result);
    }
}

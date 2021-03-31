package main.java.FilesExerciseThreeB;

public class FileLine {
    //строка
    public String line;
    //номер строки
    private int lineNumber;
    //повторяющийся символ
    private char duplicateLetter = ' ';
    //счётчик одинаковых символов в подстроке
    public int duplicateLetterCount = 1;

    FileLine(String line, int lineNumber) {
        this.line = line;
        this.lineNumber = lineNumber;
    }

    //геттер для компаратора(Main.java : 26 строка)
    public int getDuplicateLetterCount() {
        return this.duplicateLetterCount;
    }

    //алгоритм поиска и вычисления одинаковых символов в строке
    public void checkForDuplicates(String line) {
        for (int i = 0; i < line.length() - 1; i++) {
            char y = line.charAt(i);
            char z = line.charAt(i + 1);
            //Сравнивает схожесть соседних символов и проверяет, чтобы они не были числами
            if ((Character.toString(y).equalsIgnoreCase(Character.toString(z))) && (Character.isLetter(y))) {
                duplicateLetter = y;
                duplicateLetterCount++;
            }
        }
    }

    public void result(int index) {
        System.out.println(index + "-е место:");
        System.out.println(this.line);
        System.out.println("Строка: " + this.lineNumber);
        if (this.duplicateLetter == ' ') {
            System.out.println("Повторяющихся символов нет.");
        } else {
            System.out.println("Повторяющийся символ: " + (Character.toString(this.duplicateLetter)));
            System.out.println("Количество повторений: " + this.duplicateLetterCount);
        }
        System.out.println("--------------------------");
    }
}

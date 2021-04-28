package main.java.OOPCarShop;

public class ASCIIGraphics {
    //Класс, отвечающий за просчитывание ширины и отрисовки таблицы с использованием ASCII-элементов.

    private char line = '\u2500'; //ASCII-code box drawings light horizontal ─
    private char equal = '\u2550';   //ASCII-code box drawings double horizontal ═
    private char cross = '\u256C';  //ASCII-code box drawings double vertical and horizontal ╬
    private char border = '\u2563'; //ASCII-code box drawings double vertical and left ╣
    private char bottom = '\u2569'; //ASCII-code box drawings double up and horizontal ╩
    private char corner = '\u255D'; //ASCII-code box drawings double up and left ╝
    private char bar = '\u2551'; //ASCII-code box drawings double vertical ║

    //divideHorizontalLine() - метод отрисовки длинной горизонтальной линии для создания границы между двумя
    //несвязанными текстами
    public void divideHorizontalLine() {
        for (int i = 0; i < 100; i++) {
            System.out.print(line);
        }
        System.out.println("");
    }

    //методы, которые выводят один определенный ASCII-символ
    public void equal() {
        System.out.print(equal);
    }

    public void line() {
        System.out.print(line);
    }

    public void cross() {
        System.out.print(cross);
    }

    public void border() {
        System.out.println(border);
    }

    public void bottom() {
        System.out.print(bottom);
    }

    public void corner() {
        System.out.println(corner);
    }

    public void bar() {
        System.out.print(bar);
    }

    //findAMiddle() - вспомогательный метод для постройки таблицы. Прописывает слова и числа ровно по середине
    // элементов строки таблицы.
    public void findAMiddle(int X, int Y, String Z) {
        int distance = Y - X;
        int openSpace = distance - Z.length();
        int side = openSpace / 2;
        for (int i = 0; i < side; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < Z.length(); i++) {
            System.out.print(Z.charAt(i));
        }
        for (int i = 0; i < distance - side - Z.length(); i++) {
            System.out.print(" ");
        }
    }

    //roundUpNumber() - вспомогательный метод для постройки таблицы. Округляет ширину столбцов таблицы, что бы между
    //словами и числами был хотя бы минимальный отступ в один пустой символ(" ")
    public int roundUpNumber(int a) {
        if (a % 2 != 0) {
            a++;
        }
        if (a == 0) {
            a = 2;
        }
        return a;
    }
}

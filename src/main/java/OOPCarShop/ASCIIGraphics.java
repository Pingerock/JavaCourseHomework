package main.java.OOPCarShop;

public class ASCIIGraphics {
    //Класс, отвечающий за графику таблицы с использованием ASCII-элементов.

    private char line = '\u2500'; //ASCII-code box drawings light horizontal ─
    private char equal = '\u2550';   //ASCII-code box drawings double horizontal ═
    private char cross = '\u256C';  //ASCII-code box drawings double vertical and horizontal ╬
    private char border = '\u2563'; //ASCII-code box drawings double vertical and left ╣
    private char bottom = '\u2569'; //ASCII-code box drawings double up and horizontal ╩
    private char corner = '\u255D'; //ASCII-code box drawings double up and left ╝
    private char bar = '\u2551'; //ASCII-code box drawings double vertical ║

    public void divideHorizontalLine() {
        for (int i = 0; i < 100; i++) {
            System.out.print(line);
        }
        System.out.println("");
    }

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
}

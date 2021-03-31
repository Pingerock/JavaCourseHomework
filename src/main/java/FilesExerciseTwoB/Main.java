package main.java.FilesExerciseTwoB;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8);
        int x;
        String word = "";
        ArrayList<String> list = new ArrayList<>();
        do {
            x = inputStream.read();
            if (((char) x == ' ') || (x == -1)) {
                list.add(word);
                word = "";
                continue;
            }
            word += (char) x;
        } while (x != -1);
        String longestWord = "";
        for (String x1 : list) {
            if (x1.length() > longestWord.length()) {
                longestWord = x1;
            }
        }
        OutputStream outputStream = new FileOutputStream("output.txt");
        outputStream.write(longestWord.getBytes());
        outputStream.close();
        while ((x = inputStream.read()) != -1) {
            System.out.print((char) x);
        }
        inputStream.close();
    }
}

package main.java.FilesExerciseOneB;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "Documents";
        File file = new File(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите фильтр по расширению: ");
        System.out.println("1 - .txt");
        System.out.println("2 - .html");
        int x = scanner.nextInt();
        switch (x) {
            case 1:
                String[] files1 = file.list(new FilenameFilter() {
                    public boolean accept(File directory, String fileName) {
                        return fileName.endsWith(".txt");
                    }
                });
                for (String x1 : files1) {
                    System.out.println(x1);
                }
                break;
            case 2:
                String[] files2 = file.list(new FilenameFilter() {
                    public boolean accept(File directory, String fileName) {
                        return fileName.endsWith(".html");
                    }
                });
                for (String x2 : files2) {
                    System.out.println(x2);
                }
                break;
            default:
                System.err.println("Неверный ввод!");
                return;
        }
    }
}

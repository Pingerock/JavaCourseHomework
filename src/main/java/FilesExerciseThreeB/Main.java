package main.java.FilesExerciseThreeB;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<FileLine> list = new ArrayList<>();
        int lineNumber = 0;
        //читаем файл
        while(scanner.hasNextLine()){
            lineNumber++;
            String line = scanner.nextLine();
            list.add(new FileLine(line, lineNumber));
        }
        //создаем объекты класса строки файла
        //и сразу вычисляем в нем наличие подстрок,
        //содержащих одинаковые символы
        for(FileLine fl : list){
            fl.checkForDuplicates(fl.line);
        }
        //сортируем список объектов по количеству одинаковых букв в подстроке
        list.sort(Comparator.comparing(FileLine::getDuplicateLetterCount));
        Collections.reverse(list);
        //вывод
        int index = 1;
        for(FileLine fl : list){
            fl.result(index);
            index++;
            if(index == 11){
                break;
            }
        }
    }
}

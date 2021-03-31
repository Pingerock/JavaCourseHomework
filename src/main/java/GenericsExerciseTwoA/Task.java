package main.java.GenericsExerciseTwoA;

import java.util.ArrayList;
import java.util.List;

public class Task<T> {
    List<T> list = new ArrayList<T>();

    public void addObject(T t) {
        list.add(t);
    }

    public void deleteDuplicates(T t) {
        while (list.contains(t)) {
            list.remove(t);
        }
    }

    public void printList() {
        for (T t2 : list) {
            System.out.print(t2 + " ");
        }
        System.out.println("\n");
    }
}

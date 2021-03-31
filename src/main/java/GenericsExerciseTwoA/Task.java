package main.java.GenericsExerciseTwoA;

import java.util.ArrayList;
import java.util.List;

public class Task<T> {
    List<T> list = new ArrayList<T>();

    public void addObject(T t) {
        list.add(t);
    }

    public void deleteDuplicates(T t) {
        int index = 0;
        for (T t1 : list) {
            if (t1.equals(t)) {
                list.set(index, null);
            }
            index++;
        }
    }

    public void printList() {
        for (T t2 : list) {
            try {
                if (t2.equals(null)) {
                    continue;
                }
            } catch (NullPointerException e) {
                continue;
            }
            System.out.print(t2 + " ");
        }
        System.out.println("\n");
    }
}

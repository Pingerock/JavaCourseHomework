package main.java.GenericsExerciseThreeB;

public class MyArrayList<T> {
    T[] myArrayList;

    public MyArrayList(T[] myArrayList) {
        this.myArrayList = myArrayList;
    }

    public void addItem(int index, T item) {
        myArrayList[index] = item;
    }

    public void deleteItem(int index) {
        myArrayList[index] = null;
    }

    public void printArray() {
        for (T t : myArrayList) {
            System.out.print(t + " ");
        }
        System.out.print("\n");
    }
}

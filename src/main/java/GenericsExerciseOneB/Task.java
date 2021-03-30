package main.java.GenericsExerciseOneB;

public class Task {
    //универсальный метод isEqualTo. Сравнивает два аргумента методом equals()
    public <T, N> boolean isEqualTo(T object1, N object2){
        boolean x = object1.equals(object2);
        return x;
    }
}

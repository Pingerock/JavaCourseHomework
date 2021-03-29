package main.java.GenericsExerciseThreeB;

public class Main {
    public static void main(String[] args) {
        //создаем массив объектов, переносим его в обобщенную коллекцию
        Object[] testArray = {552, "test", 0.00, 8312023, "bad"};
        MyArrayList<Object> a = new MyArrayList<>(testArray);
        //выводим изначальный массив
        a.printArray();
        //меняем в нем элементы 1-го и 4-го индекса
        a.deleteItem(1);
        a.deleteItem(4);
        a.addItem(1, 1234);
        a.addItem(4, 5678);
        //выводим изменения
        a.printArray();
    }
}

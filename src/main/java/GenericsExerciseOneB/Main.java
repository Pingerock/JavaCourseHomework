package main.java.GenericsExerciseOneB;

public class Main {
    public static void main(String[] args) {
        //создаем объект класса Task в котором находится универсальный метод isEqualTo
        Task task = new Task();
        //создаем числа и объекты для испытания метода
        int x = 550;
        int x1 = 552;
        Object z = 550;
        Object z1 = 550;
        //применяем созданный универсальный метод isEqualTo
        boolean test1, test2, test3, test4, test5;
        test1 = task.isEqualTo(x, z);
        test2 = task.isEqualTo(x, x1);
        test3 = task.isEqualTo(z, x);
        test4 = task.isEqualTo(z, z1);
        test5 = task.isEqualTo(z, x1);
        //вывод
        System.out.println(test1); //true
        System.out.println(test2); //false
        System.out.println(test3); //true
        System.out.println(test4); //true
        System.out.println(test5); //false
    }
}

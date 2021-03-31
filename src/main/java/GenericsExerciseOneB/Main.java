package main.java.GenericsExerciseOneB;

public class Main {
    public static void main(String[] args) {
        //создаем объект класса Task в котором находится универсальный метод isEqualTo
        Task task = new Task();
        //создаем числа и объекты для испытания метода
        int x = 550;
        int x1 = 552;
        Object z = null;
        Object z1 = 550;
        Object z2 = 550;
        //применяем созданный универсальный метод isEqualTo
        boolean test1, test2, test3, test4, test5, test6, test7, test8, test9;
        test1 = task.isEqualTo(x, z);
        test2 = task.isEqualTo(x, x1);
        test3 = task.isEqualTo(z, x);
        test4 = task.isEqualTo(z, z1);
        test5 = task.isEqualTo(z, x1);
        test6 = task.isEqualTo(x, z2);
        test7 = task.isEqualTo(z2, x);
        test8 = task.isEqualTo(z2, z1);
        test9 = task.isEqualTo(z2, x1);
        //вывод
        System.out.println(test1); //false (NullPointerException)
        System.out.println(test2); //false
        System.out.println(test3); //false (NullPointerException)
        System.out.println(test4); //false (NullPointerException)
        System.out.println(test5); //false (NullPointerException)
        System.out.println(test6); //true
        System.out.println(test7); //true
        System.out.println(test8); //true
        System.out.println(test9); //false
    }
}

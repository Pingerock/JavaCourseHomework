package main.java.LessonThreeExerciseTwoB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y, z;
        String a, b;
        boolean check = true;
        System.out.println("Соберите себе машину!");
        System.out.println("Какую скорость вы бы предпочли?");
        x = scanner.nextInt();
        System.out.println("Хорошо. А как вы бы назвали модель своей машины?");
        a = scanner.nextLine();
        Car car = new Car(x, a);
        System.out.println("Теперь собираем движок!");
        System.out.println("Введите предполагаемую мощность:");
        x = scanner.nextInt();
        System.out.println("Понятно. Сколько поршней нужно?");
        y = scanner.nextInt();
        System.out.println("На сколько тяжелым должен быть двигатель? Ответ выдать в количестве кг.");
        z = scanner.nextInt();
        Engine engine = new Engine(x, y, z);
        System.out.println("Допустим. Это нечто будет работать. Приступим к колесам.");
        System.out.println("Введите диаметр колеса.");
        x = scanner.nextInt();
        System.out.println("Введите тип колес.");
        a = scanner.nextLine();
        System.out.println("Последний штрих. Как будем звать производителя колес(вас)?");
        b = scanner.nextLine();
        Wheel[] wheel = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheel[i] = new Wheel(x, a, b);
        }
        System.out.println("Поздравляем! Вы успешно собрали машину. Присаживайтесь и отправляйтесь в путь.");
        System.out.println("Нажмите Enter, чтобы продолжить...");
        scanner.next();
        while (check) {
            wheel[0].wearOut();
            System.out.println("Выберите действие:");
            System.out.println("1 - Ехать.");
            System.out.println("2 - Остановиться.");
            System.out.println("3 - Напомнить машине, кто её владелец.");
            System.out.println("4 - Завести машину.");
            System.out.println("5 - Прислущаться к работе двигателя.");
            System.out.println("6 - Сделать несоответствующий машине звук.");
            System.out.println("7 - Сделать дрифт.");
            System.out.println("8 - Выйти из машины.");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                    car.move();
                case 2:
                    car.stop();
                case 3:
                    car.helloOwner();
                case 4:
                    engine.start();
                case 5:
                    engine.work();
                case 6:
                    engine.makeASound();
                case 7:
                    wheel[0].leaveAMark();
                case 8:
                    System.out.println("Пешком ходить лучше.");
                    System.out.println("Пока-пока.");
                    check = false;
                default:
                    System.out.println("Ошибка. Неизвестная команда.");
            }
        }
    }
}


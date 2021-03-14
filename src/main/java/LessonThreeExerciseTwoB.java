package main.java;

import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LessonThreeExerciseTwoB {
    public static void main(String[] args) {
        //описание: мне кажется, я сделал больше, чем нужно было. Простите.
        Scanner scanner = new Scanner(System.in);
        int x;
        Car car;
        System.out.println("Какую машинку хотите?");
        System.out.println("1 - быстрый автомобиль.");
        System.out.println("2 - для езды по бездорожью.");
        System.out.println("3 - семейный хэтчбек.");
        loop:
        while (true) {
            x = scanner.nextInt();
            switch (x) {
                case 1, 2, 3 -> {
                    car = new Car(x);
                    break loop;
                }
                default -> System.out.println("Ошибка. Неверный ввод.");
            }
        }
        System.out.println("Поздравляем с новой машиной. Присаживайтесь и отправляйтесь в путь.");
        System.out.println("Нажмите Enter, чтобы продолжить...");
        //у меня было в планах после нажатия клавиши Enter приступить к управлению машины, стирая уже ненужный текст в
        //консоли. "Press Enter to continue..." я нашел как сделать, а вот стирание текста из консоли - нет.
        // Гугл не помог. Help me. Т_Т
        try {
            System.in.read();
            //Единственный warning, который я не могу решить. (Result of 'InputStream.read()' is ignored)
            //А мне эта функция необходима.
        } catch (Exception e) {
            e.printStackTrace();
        }
        int y;
        loop:
        while (true) {
            //каждый раз перед действием пользователя программа "бросает кости" в надежде, что прога закончит работу.
            y = (int) (Math.random() * 30);
            car.wheels[0].wear_out(y);
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
                case 1 -> car.move();
                case 2 -> car.stop();
                case 3 -> car.hello_owner();
                case 4 -> car.engine.start();
                case 5 -> car.engine.work();
                case 6 -> car.engine.make_a_sound();
                case 7 -> car.wheels[0].leave_a_mark();
                case 8 -> {
                    System.out.println("Пешком ходить лучше.");
                    System.out.println("Пока-пока.");
                    break loop;
                }
                default -> System.out.println("Ошибка. Неизвестная команда.");
            }
        }
    }

    //Класс машины, включающий в себя несколько полей и методов и пару внутренних классов(двигатель и колес)
    public static class Car {
        //поля для данных абсолютно бесполезны в этой проге, но их наличие необходимо для задачи
        String model;
        int speed;
        Engine engine;
        Wheel[] wheels = new Wheel[4];

        public Car(int car_type) {
            switch (car_type) {
                case 1 -> {
                    model = "Fast_car";
                    speed = 100;
                    engine = new Engine(1);
                    for (int i = 0; i < 4; i++) {
                        wheels[i] = new Wheel(1);
                    }
                }
                case 2 -> {
                    model = "Durable_car";
                    speed = 50;
                    engine = new Engine(2);
                    for (int i = 0; i < 4; i++) {
                        wheels[i] = new Wheel(2);
                    }
                }
                case 3 -> {
                    model = "Family_car";
                    speed = 25;
                    engine = new Engine(3);
                    for (int i = 0; i < 4; i++) {
                        wheels[i] = new Wheel(3);
                    }
                }
            }
        }

        public void move() {
            System.out.println("Поехали!");
        }

        public void stop() {
            System.out.println("Останавливаемся.");
        }

        public void hello_owner() {
            System.out.println("Приветствую вас, хозяин! Не бейте меня.");
        }

        public static class Engine {
            //поля для данных абсолютно бесполезны в этой проге, но их наличие необходимо для задачи
            int power;
            int piston_count;
            int weight;

            public Engine(int car_type) {
                switch (car_type) {
                    case 1 -> {
                        power = 100;
                        piston_count = 6;
                        weight = 100;
                    }
                    case 2 -> {
                        power = 75;
                        piston_count = 4;
                        weight = 150;
                    }
                    case 3 -> {
                        power = 50;
                        piston_count = 2;
                        weight = 50;
                    }
                }
            }

            public void start() {
                System.out.println("*Звук завода мотора*");
            }

            public void work() {
                System.out.println("*Звук рева мотора*");
            }

            //я хотел побаловаться и вместо "sout" вызываю системные звуки.
            public void make_a_sound() {
                Toolkit.getDefaultToolkit().beep();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toolkit.getDefaultToolkit().beep();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Toolkit.getDefaultToolkit().beep();
            }
        }

        public static class Wheel {
            //поля для данных абсолютно бесполезны в этой проге, но их наличие необходимо для задачи
            int diameter;
            String type;
            String manufacturer;

            public Wheel(int car_type) {
                switch (car_type) {
                    case 1 -> {
                        diameter = 50;
                        type = "Для больших скоростей";
                        manufacturer = "CarBuilder";
                    }
                    case 2 -> {
                        diameter = 75;
                        type = "Устойчивые к повреждениям";
                        manufacturer = "SummerTripDriving";
                    }
                    case 3 -> {
                        diameter = 45;
                        type = "Для долгих поездок по шоссе";
                        manufacturer = "UrbanMobile";
                    }
                }
            }

            // в случайный момент, колесо машины может износиться и программа остановится.
            public void wear_out(int chance) {
                if (chance > 20) {
                    System.out.println("Тревога! Обнаружен износ колес. Движение невозможно.");
                    System.out.println("Как жаль.");
                    System.exit(0);
                }
            }

            public void leave_a_mark() {
                System.out.println("Я оставил след на дороге. Впредь стоит вести аккуратнее.");
            }
        }
    }
}



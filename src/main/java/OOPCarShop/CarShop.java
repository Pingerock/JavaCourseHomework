package main.java.OOPCarShop;

import main.java.OOPCarShop.enums.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CarShop {

    static Scanner scanner = new Scanner(System.in);
    //список клиентов действующих клиентов
    static ArrayList<Client> clients = new ArrayList<>();
    //список сотрудников
    static ArrayList<Employee> employees = new ArrayList<>();
    //объект класса для отрисовки ASCII-графики в таблице
    static ASCIIGraphics ascii = new ASCIIGraphics();

    private static String CarShopName;

    CarShop(String CarShopName) {
        this.CarShopName = CarShopName.toUpperCase(Locale.ROOT);
    }

    public static void ShopInWork() {
        int x;
        clients.add(new Client("Игорь", "Киселев", 21, "Смирнова, 84", true));
        employees.add(new Employee("Николай", "Простой", 42, "Развивающийся", "Продавец-консультант"));
        employees.add(new Employee("Мария", "Стругановская", 25, "Нетвоёдело", "Продавец-администратор"));
        employees.add(new Employee("Кагор", "Урбанштарбанфюрер", 104, "СынНачальника", "Директор-Продавец-администратор"));
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В АВТОСАЛОН " + CarShopName);
        while (true) {
            ascii.divideHorizontalLine();
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить сотрудника");
            System.out.println("2 - Добавить клиента");
            System.out.println("3 - Добавить машину");
            System.out.println("4 - Вывести таблицу сотрудников автосалона");
            System.out.println("5 - Вывести таблицу клиентов");
            System.out.println("6 - Вывести список машин в наличии");
            System.out.println("7 - Уволить сотрудника");
            System.out.println("8 - Выдать сотрудникам салона зарплату");
            System.out.println("9 - Продать машину клиенту");
            System.out.println("10 - Выйти из управления автосалоном.");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                    CarShop.addEmployee();
                    break;
                case 2:
                    CarShop.addClient();
                    break;
                case 3:
                    CarShop.addCar();
                    break;
                case 4:
                    CarShop.checkEmployees();
                    break;
                case 5:
                    CarShop.checkClients();
                    break;
                case 6:
                    CarShop.checkCars();
                    break;
                case 7:
                    CarShop.fireAnEmployee();
                    break;
                case 8:
                    CarShop.payday();
                    break;
                case 9:
                    CarShop.clientSellCar();
                    break;
                case 10:
                    System.out.println("До скоро встречи, хозяин! Приходите ещё!");
                    break;
                default:
                    System.err.println("Ошибка. Неизвестная команда.");
                    break;
            }
        }

    }

    //метод, который собирает машину и присваивает его сотруднику автосалона. Добавляет его в список
    public static void addCar() {
        String brand, model, type, engine, transmission;
        int dateOfRelease, price;
        int x;
        System.out.println("Запускаем программу сборки автомобиля...");
        ascii.divideHorizontalLine();
        System.out.println("Тип транспорта");
        for (int i = 0; i < Transport.values().length; i++) {
            System.out.println((i + 1) + ". " + Transport.values()[i].getName());
        }
        ascii.divideHorizontalLine();
        System.out.print("Выберите тип транспорта: ");
        x = infoInput(Transport.values().length);
        type = Transport.values()[x].getName();
        ascii.divideHorizontalLine();
        System.out.println("Производители:");
        for (int i = 0; i < CarBrand.values().length; i++) {
            System.out.println((i + 1) + ". " + CarBrand.values()[i].getName());
        }
        System.out.print("Выберите проивзодителя: ");
        x = infoInput(CarBrand.values().length);
        brand = CarBrand.values()[x].getName();
        ascii.divideHorizontalLine();
        System.out.println("Доступные модели:");
        for (int i = 0; i < CarModel.values().length; i++) {
            System.out.println((i + 1) + ". " + CarModel.values()[i].getName());
        }
        System.out.print("Выберите модель транспорта: ");
        x = infoInput(CarModel.values().length);
        model = CarModel.values()[x].getName();
        ascii.divideHorizontalLine();
        System.out.println("Типы двигателей:");
        for (int i = 0; i < Engine.values().length; i++) {
            System.out.println((i + 1) + ". " + Engine.values()[i].getName());
        }
        System.out.print("Выберите тип двигателя: ");
        x = infoInput(Engine.values().length);
        engine = Engine.values()[x].getName();
        ascii.divideHorizontalLine();
        System.out.println("Типы коробки передач:");
        for (int i = 0; i < Transmission.values().length; i++) {
            System.out.println((i + 1) + ". " + Transmission.values()[i].getName());
        }
        System.out.print("Выберите тип коробки передач: ");
        x = infoInput(Transmission.values().length);
        transmission = Transmission.values()[x].getName();
        ascii.divideHorizontalLine();
        System.out.print("Укажите год выпуска: ");
        x = scanner.nextInt();
        if (x <= 1980 || x >= Calendar.getInstance().get(Calendar.YEAR)) {
            System.out.println("Такую машину никто не купит. Потому что таких нет, идиот! Введи другую дату.");
            while (true) {
                x = scanner.nextInt();
                if (x <= 1980 || x >= Calendar.getInstance().get(Calendar.YEAR)) {
                    System.err.println("Неправильный ввод! Попробуй ещё раз:");
                } else {
                    break;
                }
            }
        }
        dateOfRelease = x;
        ascii.divideHorizontalLine();
        System.out.print("Введите стоимость транспорта: ");
        x = scanner.nextInt();
        price = x;
        ascii.divideHorizontalLine();
        System.out.println("Машина заказана. Осталось закрепить её определенному продавцу.");
        ascii.divideHorizontalLine();
        System.out.println("Сотрудники автосалона: ");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).name + " " + employees.get(i).familyName);
        }
        if (employees.isEmpty()) {
            System.out.println("В вашем автосалоне нет сотрудников. ТАК НАЙМИТЕ! Че как баклан?");
        } else {
            x = infoInput(employees.size());
            Car a = new Car(brand, model, type, engine, transmission, dateOfRelease, price);
            employees.get(x).addCar(a);
        }
    }

    //метод проверки корректности введенного ввода
    public static int infoInput(int size) {
        int x = scanner.nextInt() - 1;
        if (x > size || x < 0) {
            System.err.println("\nНеправильный ввод! Попробуй ещё раз:");
            while (true) {
                x = scanner.nextInt();
                if (x > size || x < 0) {
                    System.err.println("Неправильный ввод! Попробуй ещё раз:");
                } else {
                    break;
                }
            }
        }
        return x;
    }

    //метод, который собирает клиента и добавляет его в список клиентов
    public static void addClient() {
        String name, familyName, address;
        boolean Sex = true;
        int age;
        System.out.println("Приступаем к сборке клиента: ");
        ascii.divideHorizontalLine();
        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        ascii.divideHorizontalLine();
        System.out.print("Введите фамилию: ");
        familyName = scanner.nextLine();
        ascii.divideHorizontalLine();
        System.out.print("Введите адрес: ");
        address = scanner.nextLine();
        ascii.divideHorizontalLine();
        boolean check = true;
        do {
            System.out.print("Выберите пол клиента: Мальчик или Девочка. M/F ");
            String sex = scanner.nextLine();
            switch (sex) {
                case "M":
                case "m":
                    Sex = true;
                    check = false;
                    break;
                case "F":
                case "f":
                    Sex = false;
                    check = false;
                    break;
                default:
                    System.err.println("Неправильный ввод!Попробуй ещё раз.");
                    break;
            }
        } while (check);
        ascii.divideHorizontalLine();
        System.out.print("Введите возраст клиента: ");
        while (true) {
            age = scanner.nextInt();
            if (age < 18 || age > 80) {
                System.out.println("Неподходящий возраст.");
            } else {
                break;
            }
        }
        ascii.divideHorizontalLine();
        System.out.println("Покупатель зарегестрирован. Ожидаем, когда этот придурок выберет себе машину.");
        Client c = new Client(name, familyName, age, address, Sex);
        clients.add(c);
    }

    //метод, который собираем сотрудника автосалона и добавляет его в список сотрудников
    public static void addEmployee() {
        String name, familyName, fatherName, job;
        int age, salary;
        System.out.println("Приступаем к сборке сотрудника: ");
        ascii.divideHorizontalLine();
        System.out.print("Введите имя: ");
        name = scanner.nextLine();
        ascii.divideHorizontalLine();
        System.out.print("Введите фамилию: ");
        familyName = scanner.nextLine();
        ascii.divideHorizontalLine();
        System.out.print("Введите отчество: ");
        fatherName = scanner.nextLine();
        ascii.divideHorizontalLine();
        System.out.print("Введите долность: ");
        job = scanner.nextLine();
        ascii.divideHorizontalLine();
        System.out.print("Введите возраст клиента: ");
        while (true) {
            age = scanner.nextInt();
            if (age < 18 || age > 80) {
                System.out.println("Неподходящий возраст.");
            } else {
                break;
            }
        }
        ascii.divideHorizontalLine();
        System.out.println("Покупатель зарегестрирован. Ожидаем, когда этот бездельник заработает нам денег.");
        Employee e = new Employee(name, familyName, age, fatherName, job);
        employees.add(e);
    }

    //одно из моих главных творений: ASCII-таблица, которая адаптируется по ширине строк полей объектов класса.
    //checkEmployees() - первая ступень постройки таблицы: прописывает столбцы. В конце запускает printRows().
    public static void checkEmployees() {
        if (employees.isEmpty()) {
            System.out.println("В вашем автосалоне нет сотрудников. ТАК НАЙМИТЕ! Че как баклан?");
        } else {
            int FIOSize = 0;
            int maxJobSize = 0;

            int numberSize = Integer.toString(employees.size()).length();

            for (Employee employee : employees) {
                if (employee.getFIO().length() > FIOSize) {
                    FIOSize = employee.getFIO().length();
                }
                if (employee.getJob().length() > maxJobSize) {
                    maxJobSize = employee.getJob().length();
                }
            }
            numberSize = roundUpNumber(numberSize);
            FIOSize = roundUpNumber(FIOSize);
            maxJobSize = roundUpNumber(maxJobSize);

            findAMiddle(0, (numberSize + 1), "№");
            ascii.bar();
            findAMiddle(0, (FIOSize + 1), "ФИО");
            ascii.bar();
            findAMiddle(0, 9, "Возраст");
            ascii.bar();
            findAMiddle(0, (maxJobSize + 1), "Должность");
            ascii.bar();
            findAMiddle(0, 24, "Кол-во проданных машин");
            ascii.bar();
            findAMiddle(0, 23, "Сумма проданных машин");
            ascii.bar();
            findAMiddle(0, 18, "Базовая зарплата");
            ascii.bar();
            findAMiddle(0, 19, "Итоговая зарплата");
            ascii.bar();
            System.out.println("");
            printRows(FIOSize, maxJobSize, numberSize);
        }
    }

    //printRows() - вторая ступень постройки таблицы: прописывает строки и завершает прорисовку таблицы
    public static void printRows(int FIO, int Job, int Number) {
        int firstColumn = Number + 1;
        int secondColumn = firstColumn + FIO + 2;
        int thirdColumn = secondColumn + 10;
        int fourthColumn = thirdColumn + Job + 2;
        int fifthColumn = fourthColumn + 25;
        int sixthColumn = fifthColumn + 24;
        int seventhColumn = sixthColumn + 19;
        int eightColumn = seventhColumn + 20;
        for (int i = 0; i <= eightColumn; i++) {
            if (i == eightColumn) {
                ascii.border();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn ||
                    i == sixthColumn || i == seventhColumn) {
                ascii.cross();
                continue;
            }
            ascii.equal();
        }
        for (Employee employee : employees) {
            findAMiddle(0, firstColumn, Integer.toString(employees.indexOf(employee) + 1));
            ascii.bar();
            findAMiddle(firstColumn, secondColumn - 1, employee.getFIO());
            ascii.bar();
            findAMiddle(secondColumn, thirdColumn - 1, Integer.toString(employee.getAge()));
            ascii.bar();
            findAMiddle(thirdColumn, fourthColumn - 1, employee.getJob());
            ascii.bar();
            findAMiddle(fourthColumn, fifthColumn - 1, Integer.toString(employee.getAmountOfCarsSoldThisPeriod()));
            ascii.bar();
            findAMiddle(fifthColumn, sixthColumn - 1, Integer.toString(employee.getProfitOfSoldCars()));
            ascii.bar();
            findAMiddle(sixthColumn, seventhColumn - 1, Integer.toString(employee.getSalary()));
            ascii.bar();
            findAMiddle(seventhColumn, eightColumn - 1, Integer.toString(employee.setFinalSalary()));
            ascii.bar();
            System.out.println("");
        }
        for (int i = 0; i <= eightColumn; i++) {
            if (i == eightColumn) {
                ascii.corner();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn ||
                    i == sixthColumn || i == seventhColumn) {
                ascii.bottom();
                continue;
            }
            ascii.equal();
        }
    }

    //findAMiddle() - вспомогательный метод для постройки таблицы. Прописывает слова и числа ровно по середине
    // элементов строки таблицы.
    public static void findAMiddle(int X, int Y, String Z) {
        int distance = Y - X;
        int openSpace = distance - Z.length();
        int side = openSpace / 2;
        for (int i = 0; i < side; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < Z.length(); i++) {
            System.out.print(Z.charAt(i));
        }
        for (int i = 0; i < distance - side - Z.length(); i++) {
            System.out.print(" ");
        }
    }

    //roundUpNumber() - вспомогательный метод для постройки таблицы. Округляет ширину столбцов таблицы, что бы между
    //словами и числами был хотя бы минимальный отступ в один пустой символ(" ")
    public static int roundUpNumber(int a) {
        if (a % 2 != 0) {
            a++;
        }
        if (a == 0) {
            a = 2;
        }
        return a;
    }

    //fireAnEmployee() - увольняет сотрудника автосалона. Удаляет его из списка.
    public static void fireAnEmployee() {
        System.out.println("Кого хотите уволить?");
        for (Employee employee : employees) {
            System.out.println((employees.indexOf(employee) + 1) + ". " + employee.getFIO());
        }
        int listSize = employees.size();
        int choice = infoInput(listSize);
        System.out.println("Ха-ха! Мне он всегда не нравился. УВОЛЕН!");
        employees.remove(choice);
    }

    //payday() - выдает зарплату сотрудникам. Обнуляет итоговую зарплату.
    public static void payday() {
        System.out.println("Выдача зарплат сотрудникам: ");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getFIO() + " - " + employees.get(i).setFinalSalary() + " рублей.");
            employees.get(i).setAmountOfCarsSoldThisPeriod(0);
            employees.get(i).setProfitOfSoldCars(0);
        }
        System.out.println("Зарплата выдана. Статистика прибыли, продаж автомобилей сброшена у сотрудников.");
    }

    //checkClients() - аналогичные метод checkEmployees(). ASCII-таблица, но для списка клиентов.
    // Первая ступень: прописывание столбцов
    public static void checkClients() {
        if (clients.isEmpty()) {
            System.out.println("В вашем автосалоне нет клиентов. ТАК НАЙДИТЕ! Воровство никто не отменял!");
        } else {
            int FISize = 0;
            int maxAddressSize = 0;
            int numberSize = Integer.toString(clients.size()).length();

            for (Client client : clients) {
                if (client.getFI().length() > FISize) {
                    FISize = client.getFI().length();
                }
                if (client.getAddress().length() > maxAddressSize) {
                    maxAddressSize = client.getAddress().length();
                }
            }
            numberSize = roundUpNumber(numberSize);
            FISize = roundUpNumber(FISize);
            maxAddressSize = roundUpNumber(maxAddressSize);
            findAMiddle(0, (numberSize + 1), "№");
            ascii.bar();
            findAMiddle(0, (FISize + 1), "Имя");
            ascii.bar();
            findAMiddle(0, 9, "Возраст");
            ascii.bar();
            findAMiddle(0, (maxAddressSize + 1), "Адрес");
            ascii.bar();
            findAMiddle(0, 9, "Пол");
            ascii.bar();
            findAMiddle(0, 44, "Находится клиент на территории автосалона?");
            ascii.bar();
            System.out.println("");
            printRowsClients(FISize, maxAddressSize, numberSize);
        }
    }

    //printRowsClients() - вторая ступень постройки таблицы списка клиентов. Прописывание строк и окончание таблицы.
    public static void printRowsClients(int FI, int Address, int Number) {
        int firstColumn = Number + 1;
        int secondColumn = firstColumn + FI + 2;
        int thirdColumn = secondColumn + 10;
        int fourthColumn = thirdColumn + Address + 2;
        int fifthColumn = fourthColumn + 10;
        int sixthColumn = fifthColumn + 45;
        for (int i = 0; i <= sixthColumn; i++) {
            if (i == sixthColumn) {
                ascii.border();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn) {
                ascii.cross();
                continue;
            }
            ascii.equal();
        }
        for (Client client : clients) {
            findAMiddle(0, firstColumn, Integer.toString(clients.indexOf(client) + 1));
            ascii.bar();
            findAMiddle(firstColumn, secondColumn - 1, client.getFI());
            ascii.bar();
            findAMiddle(secondColumn, thirdColumn - 1, Integer.toString(client.getAge()));
            ascii.bar();
            findAMiddle(thirdColumn, fourthColumn - 1, client.getAddress());
            ascii.bar();
            String Sex;
            if (client.isSex()) {
                Sex = "Мужской";
            } else {
                Sex = "Женский";
            }
            findAMiddle(fourthColumn, fifthColumn - 1, Sex);
            ascii.bar();
            String inside;
            if (client.isInsideShop()) {
                inside = "Да";
            } else {
                inside = "Нет";
            }
            findAMiddle(fifthColumn, sixthColumn - 1, inside);
            ascii.bar();
            System.out.println("");
        }
        for (int i = 0; i <= sixthColumn; i++) {
            if (i == sixthColumn) {
                ascii.corner();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn) {
                ascii.bottom();
                continue;
            }
            ascii.equal();
        }
    }

    //clientSellCar() - метод продажи автомобиля клиенту. Алгоритм такой:
    // 1. Выбираем клиента
    // 2. Показывает список доступных автомобилей, и к какому сотруднику они закреплены.
    // 3. Выбираем автомобиль для продажи
    // 4. Конкретный объект класса сотрудника автосалона(Employee), приступает к выполнению своего метода продажи
    // и удаление его из списка, прибавки к зарплате сотрудника и прибавление его к счётчику проданных автомобилей.
    // 5. Успех
    public static void clientSellCar() {
        System.out.println("Выберите клиента, желающего купить машину?ВАЖНО: клиент должен быть на территории автосалона");
        for (Client client : clients) {
            if (client.isInsideShop()) {
                System.out.println((clients.indexOf(client) + 1) + ". " + client.getFI());
            }
        }
        int chosenClient = infoInput(clients.size());
        checkCars();
        ascii.line();
        System.out.println("Выберите сотрудника автосалона, чей автомобиль вы бы хотели купить?");
        int chosenEmployee;
        for (int i = 0; i < employees.size(); i++) {
            if (!employees.get(i).getCarList().isEmpty()) {
                System.out.println((i + 1) + ". " + employees.get(i).getFIO());
            } else {
                System.err.println((i + 1) + ". " + employees.get(i).getFIO() + " [НЕДОСТУПНО]");
            }
        }
        while (true) {
            chosenEmployee = infoInput(employees.size());
            if (employees.get(chosenEmployee).getCarList().isEmpty()) {
                System.err.println("НЕПРАВИЛЬНЫЙ ВВОД, ТУПИЦА. ВЫБЕРИ ДРУГОГО!");
            } else {
                break;
            }
        }
        System.out.println("Выберите машину, которую вы хотите купить у " + employees.get(chosenEmployee).getFIO());
        employees.get(chosenEmployee).showCars();
        int chosenCar = infoInput(employees.get(chosenEmployee).getCarList().size());
        employees.get(chosenEmployee).sellCar(employees.get(chosenEmployee).getCarList().get(chosenCar), clients.get(chosenCar));
        clients.remove(clients.get(chosenClient));
    }

    // checkCars() - просто выводит список всех машин, которые сейчас находятся в автосалоне.
    public static void checkCars() {
        System.out.println("Список машин доступных в автосалоне:");
        for (Employee employee : employees) {
            employee.showCars();
        }
    }
}




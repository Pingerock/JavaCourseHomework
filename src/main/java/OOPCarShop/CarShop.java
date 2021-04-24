package main.java.OOPCarShop;

import main.java.OOPCarShop.enums.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class CarShop {

    Scanner scanner = new Scanner(System.in);
    //список клиентов действующих клиентов
    ArrayList<Client> clients = new ArrayList<>();
    //список сотрудников
    ArrayList<Employee> employees = new ArrayList<>();
    //объект класса для отрисовки ASCII-графики в таблице
    ASCIIGraphics ascii = new ASCIIGraphics();

    private String carShopName;

    CarShop(String carShopName) {
        this.carShopName = carShopName.toUpperCase(Locale.ROOT);
    }

    public void ShopInWork() {
        int x;
        clients.add(new Client("Игорь", "Киселев", 21, "Смирнова, 84", "Мужской"));
        employees.add(new Employee("Николай", "Простой", 42, "Развивающийся", "Продавец-консультант"));
        employees.add(new Employee("Мария", "Стругановская", 25, "Нетвоёдело", "Продавец-администратор"));
        employees.add(new Employee("Кагор", "Урбанштарбанфюрер", 104, "СынНачальника", "Директор-Продавец-администратор"));
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В АВТОСАЛОН " + carShopName);
        while (true) {
            ascii.divideHorizontalLine();
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
            ascii.divideHorizontalLine();
            System.out.print("Выберите действие: ");
            x = scanner.nextInt();
            switch (x) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addClient();
                    break;
                case 3:
                    addCar();
                    break;
                case 4:
                    checkEmployees();
                    break;
                case 5:
                    checkClients();
                    break;
                case 6:
                    checkCars();
                    break;
                case 7:
                    fireAnEmployee();
                    break;
                case 8:
                    payday();
                    break;
                case 9:
                    clientSellCar();
                    break;
                case 10:
                    System.out.println("До скоро встречи, хозяин! Приходите ещё!");
                    break;
                default:
                    System.err.println("Ошибка. Неизвестная команда.");
                    break;
            }
            if (x == 10) {
                break;
            }
        }
    }

    //метод, который собирает машину и присваивает его сотруднику автосалона. Добавляет его в список
    public void addCar() {
        String brand, model, type, engine, transmission;
        int dateOfRelease, price;
        int userChoice;
        System.out.println("Запускаем программу сборки автомобиля...");
        ascii.divideHorizontalLine();
        System.out.println("Тип транспорта");
        for (int i = 0; i < Transport.values().length; i++) {
            System.out.println((i + 1) + ". " + Transport.values()[i].getName());
        }
        ascii.divideHorizontalLine();
        System.out.print("Выберите тип транспорта: ");
        userChoice = infoInput(Transport.values().length);
        type = Transport.values()[userChoice].getName();
        ascii.divideHorizontalLine();
        System.out.println("Производители:");
        for (int i = 0; i < CarBrand.values().length; i++) {
            System.out.println((i + 1) + ". " + CarBrand.values()[i].getName());
        }
        System.out.print("Выберите проивзодителя: ");
        userChoice = infoInput(CarBrand.values().length);
        brand = CarBrand.values()[userChoice].getName();
        ascii.divideHorizontalLine();
        System.out.println("Доступные модели:");
        for (int i = 0; i < CarModel.values().length; i++) {
            System.out.println((i + 1) + ". " + CarModel.values()[i].getName());
        }
        System.out.print("Выберите модель транспорта: ");
        userChoice = infoInput(CarModel.values().length);
        model = CarModel.values()[userChoice].getName();
        ascii.divideHorizontalLine();
        System.out.println("Типы двигателей:");
        for (int i = 0; i < Engine.values().length; i++) {
            System.out.println((i + 1) + ". " + Engine.values()[i].getName());
        }
        System.out.print("Выберите тип двигателя: ");
        userChoice = infoInput(Engine.values().length);
        engine = Engine.values()[userChoice].getName();
        ascii.divideHorizontalLine();
        System.out.println("Типы коробки передач:");
        for (int i = 0; i < Transmission.values().length; i++) {
            System.out.println((i + 1) + ". " + Transmission.values()[i].getName());
        }
        System.out.print("Выберите тип коробки передач: ");
        userChoice = infoInput(Transmission.values().length);
        transmission = Transmission.values()[userChoice].getName();
        ascii.divideHorizontalLine();
        System.out.print("Укажите год выпуска: ");
        userChoice = scanner.nextInt();
        if (userChoice <= 1980 || userChoice >= Calendar.getInstance().get(Calendar.YEAR)) {
            System.out.println("Такую машину никто не купит. Потому что таких нет, идиот! Введи другую дату.");
            while (true) {
                userChoice = scanner.nextInt();
                if (userChoice <= 1980 || userChoice >= Calendar.getInstance().get(Calendar.YEAR)) {
                    System.err.println("Неправильный ввод! Попробуй ещё раз:");
                } else {
                    break;
                }
            }
        }
        dateOfRelease = userChoice;
        ascii.divideHorizontalLine();
        System.out.print("Введите стоимость транспорта: ");
        userChoice = scanner.nextInt();
        price = userChoice;
        ascii.divideHorizontalLine();
        System.out.println("Машина заказана. Осталось закрепить её определенному продавцу.");
        ascii.divideHorizontalLine();
        System.out.println("Сотрудники автосалона: ");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getName() + " " + employees.get(i).getFamilyName());
        }
        if (employees.isEmpty()) {
            System.out.println("В вашем автосалоне нет сотрудников. ТАК НАЙМИТЕ! Че как баклан?");
        } else {
            userChoice = infoInput(employees.size());
            Car a = new Car(brand, model, type, engine, transmission, dateOfRelease, price);
            employees.get(userChoice).addCar(a);
        }
    }

    //метод проверки корректности введенного ввода
    public int infoInput(int size) {
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
    public void addClient() {
        String name, familyName, address;
        String sex;
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
            System.out.print("Выберите пол клиента: Мужской или Женский. M/F ");
            sex = scanner.nextLine();
            switch (sex) {
                case "M":
                case "m":
                    sex = "Мужской";
                    check = false;
                    break;
                case "F":
                case "f":
                    sex = "Женский";
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
        Client c = new Client(name, familyName, age, address, sex);
        clients.add(c);
    }

    //метод, который собираем сотрудника автосалона и добавляет его в список сотрудников
    public void addEmployee() {
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
    //checkEmployees() - постройка таблицы переклички сотрудников автосалона.
    public void checkEmployees() {
        if (employees.isEmpty()) {
            System.out.println("В вашем автосалоне нет сотрудников. ТАК НАЙМИТЕ! Че как баклан?");
        } else {
            int FIOSize = 0;
            int maxJobSize = 0;

            int numberSize = Integer.toString(employees.size()).length();

            for (Employee employee : employees) {
                if (employee.FIO().length() > FIOSize) {
                    FIOSize = employee.FIO().length();
                }
                if (employee.getJob().length() > maxJobSize) {
                    maxJobSize = employee.getJob().length();
                }
            }
            numberSize = ascii.roundUpNumber(numberSize);
            FIOSize = ascii.roundUpNumber(FIOSize);
            maxJobSize = ascii.roundUpNumber(maxJobSize);

            ascii.findAMiddle(0, (numberSize + 1), "№");
            ascii.bar();
            ascii.findAMiddle(0, (FIOSize + 1), "ФИО");
            ascii.bar();
            ascii.findAMiddle(0, 9, "Возраст");
            ascii.bar();
            ascii.findAMiddle(0, (maxJobSize + 1), "Должность");
            ascii.bar();
            ascii.findAMiddle(0, 24, "Кол-во проданных машин");
            ascii.bar();
            ascii.findAMiddle(0, 23, "Сумма проданных машин");
            ascii.bar();
            ascii.findAMiddle(0, 18, "Базовая зарплата");
            ascii.bar();
            ascii.findAMiddle(0, 19, "Итоговая зарплата");
            ascii.bar();
            System.out.println("");
            int firstColumn = numberSize + 1;
            int secondColumn = firstColumn + FIOSize + 2;
            int thirdColumn = secondColumn + 10;
            int fourthColumn = thirdColumn + maxJobSize + 2;
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
                ascii.findAMiddle(0, firstColumn, Integer.toString(employees.indexOf(employee) + 1));
                ascii.bar();
                ascii.findAMiddle(firstColumn, secondColumn - 1, employee.FIO());
                ascii.bar();
                ascii.findAMiddle(secondColumn, thirdColumn - 1, Integer.toString(employee.getAge()));
                ascii.bar();
                ascii.findAMiddle(thirdColumn, fourthColumn - 1, employee.getJob());
                ascii.bar();
                ascii.findAMiddle(fourthColumn, fifthColumn - 1, Integer.toString(employee.getAmountOfCarsSoldThisPeriod()));
                ascii.bar();
                ascii.findAMiddle(fifthColumn, sixthColumn - 1, Integer.toString(employee.getProfitOfSoldCars()));
                ascii.bar();
                ascii.findAMiddle(sixthColumn, seventhColumn - 1, Integer.toString(employee.getSalary()));
                ascii.bar();
                ascii.findAMiddle(seventhColumn, eightColumn - 1, Integer.toString(employee.setFinalSalary()));
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
    }

    //fireAnEmployee() - увольняет сотрудника автосалона. Удаляет его из списка.
    public void fireAnEmployee() {
        System.out.println("Кого хотите уволить?");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).FIO());
        }
        int listSize = employees.size();
        int choice = infoInput(listSize);
        System.out.println("Ха-ха! Мне он всегда не нравился. УВОЛЕН!");
        employees.remove(choice);
    }

    //payday() - выдает зарплату сотрудникам. Обнуляет итоговую зарплату.
    public void payday() {
        System.out.println("Выдача зарплат сотрудникам: ");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).FIO() + " - " + employees.get(i).setFinalSalary() + " рублей.");
            employees.get(i).setAmountOfCarsSoldThisPeriod(0);
            employees.get(i).setProfitOfSoldCars(0);
        }
        System.out.println("Зарплата выдана. Статистика прибыли, продаж автомобилей сброшена у сотрудников.");
    }

    //checkClients() - аналогичные метод checkEmployees(). ASCII-таблица, но для списка клиентов.
    public void checkClients() {
        if (clients.isEmpty()) {
            System.out.println("В вашем автосалоне нет клиентов. ТАК НАЙДИТЕ! Воровство никто не отменял!");
        } else {
            int FISize = 0;
            int maxAddressSize = 0;
            int numberSize = Integer.toString(clients.size()).length();

            for (Client client : clients) {
                if (client.FI().length() > FISize) {
                    FISize = client.FI().length();
                }
                if (client.getAddress().length() > maxAddressSize) {
                    maxAddressSize = client.getAddress().length();
                }
            }
            numberSize = ascii.roundUpNumber(numberSize);
            FISize = ascii.roundUpNumber(FISize);
            maxAddressSize = ascii.roundUpNumber(maxAddressSize);
            ascii.findAMiddle(0, (numberSize + 1), "№");
            ascii.bar();
            ascii.findAMiddle(0, (FISize + 1), "Имя");
            ascii.bar();
            ascii.findAMiddle(0, 9, "Возраст");
            ascii.bar();
            ascii.findAMiddle(0, (maxAddressSize + 1), "Адрес");
            ascii.bar();
            ascii.findAMiddle(0, 9, "Пол");
            ascii.bar();
            ascii.findAMiddle(0, 44, "Находится клиент на территории автосалона?");
            ascii.bar();
            System.out.println("");
            int firstColumn = numberSize + 1;
            int secondColumn = firstColumn + FISize + 2;
            int thirdColumn = secondColumn + 10;
            int fourthColumn = thirdColumn + maxAddressSize + 2;
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
                ascii.findAMiddle(0, firstColumn, Integer.toString(clients.indexOf(client) + 1));
                ascii.bar();
                ascii.findAMiddle(firstColumn, secondColumn - 1, client.FI());
                ascii.bar();
                ascii.findAMiddle(secondColumn, thirdColumn - 1, Integer.toString(client.getAge()));
                ascii.bar();
                ascii.findAMiddle(thirdColumn, fourthColumn - 1, client.getAddress());
                ascii.bar();
                ascii.findAMiddle(fourthColumn, fifthColumn - 1, client.getSex());
                ascii.bar();
                String inside;
                if (client.isInsideShop()) {
                    inside = "Да";
                } else {
                    inside = "Нет";
                }
                ascii.findAMiddle(fifthColumn, sixthColumn - 1, inside);
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
    }

    //clientSellCar() - метод продажи автомобиля клиенту. Алгоритм такой:
    // 1. Выбираем клиента
    // 2. Показывает список доступных автомобилей, и к какому сотруднику они закреплены.
    // 3. Выбираем автомобиль для продажи
    // 4. Конкретный объект класса сотрудника автосалона(Employee), приступает к выполнению своего метода продажи
    // и удаление его из списка, прибавки к зарплате сотрудника и прибавление его к счётчику проданных автомобилей.
    // 5. Успех
    public void clientSellCar() {
        System.out.println("Выберите клиента, желающего купить машину?ВАЖНО: клиент должен быть на территории автосалона");
        int chosenClient;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).isInsideShop()) {
                System.out.println((i + 1) + ". " + clients.get(i).FI());
            } else {
                System.err.println((i + 1) + ". " + clients.get(i).FI() + " [НЕДОСТУПНО]");
            }
        }
        while (true) {
            chosenClient = infoInput(clients.size());
            if (employees.get(chosenClient).getCarList().isEmpty()) {
                System.err.println("НЕПРАВИЛЬНЫЙ ВВОД, ТУПИЦА. ВЫБЕРИ ДРУГОГО!");
            } else {
                break;
            }
        }
        checkCars();
        ascii.line();
        System.out.println("Выберите сотрудника автосалона, чей автомобиль вы бы хотели купить?");
        int chosenEmployee;
        for (int i = 0; i < employees.size(); i++) {
            if (!employees.get(i).getCarList().isEmpty()) {
                System.out.println((i + 1) + ". " + employees.get(i).FIO());
            } else {
                System.err.println((i + 1) + ". " + employees.get(i).FIO() + " [НЕДОСТУПНО]");
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
        System.out.println("Выберите машину, которую вы хотите купить у " + employees.get(chosenEmployee).FIO());
        employees.get(chosenEmployee).showCars();
        int chosenCar = infoInput(employees.get(chosenEmployee).getCarList().size());
        employees.get(chosenEmployee).sellCar(employees.get(chosenEmployee).getCarList().get(chosenCar), clients.get(chosenCar));
        clients.remove(clients.get(chosenClient));
    }

    // checkCars() - просто выводит список всех машин, которые сейчас находятся в автосалоне.
    public void checkCars() {
        System.out.println("Список машин доступных в автосалоне:");
        for (Employee employee : employees) {
            employee.showCars();
        }
    }
}




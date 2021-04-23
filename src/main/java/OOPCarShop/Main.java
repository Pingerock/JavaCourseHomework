package main.java.OOPCarShop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main{

    static Scanner scanner = new Scanner(System.in);
    //список клиентов действующих клиентов
    static ArrayList<Client> clients = new ArrayList<>();
    //список сотрудников
    static ArrayList<Employee> employees = new ArrayList<>();
    //объект класса для отрисовки ASCII-графики в таблице
    static ASCIIGraphics ascii = new ASCIIGraphics();

    public static void main(String[] args) {
        clients.add(new Client("Игорь", "Киселев", 21, "Смирнова, 84", true));
        employees.add(new Employee("Николай", "Простой", 42, "Развивающийся", "Продавец-консультант"));
        employees.add(new Employee("Мария", "Стругановская", 25, "Нетвоёдело", "Продавец-администратор"));
        employees.add(new Employee("Кагор", "Урбанштарбанфюрер", 104, "СынНачальника", "Директор-Продавец-администратор"));

        checkEmployees();
    }

    //метод, который собирает машину и присваивает его сотруднику автосалона. Добавляет его в список
    public static void addCar() {
        String brand, model, type, engine, transmission;
        int dateOfRelease, price;
        int x, size;
        String[] transportType = {"Грузовой транспорт", "Легковой транспорт", "Автобус", "Мотоцикл"};
        String[] transmissionType = {"Ступенчатая", "Бесступенчатая", "Комбинированная"};
        String[] engineType = {"Бензиновый", "Дизельный", "Электрический", "Гибридный"};
        String[] carBrand = {"Audi", "BMW", "Ford", "Nissan", "Subaru"};
        String[] carModel = {"Masquerade", "Salvation", "Moscow", "Entropy"};
        System.out.println("Запускаем программу сборки автомобиля...");
        ascii.divideHorizontalLine();
        System.out.println("Тип транспорта");
        for (int i = 0; i < transportType.length; i++) {
            System.out.println((i + 1) + ". " + transportType[i]);
        }
        size = transportType.length;
        ascii.divideHorizontalLine();
        System.out.print("Выберите тип транспорта: ");
        x = infoInput(size);
        type = transportType[x];
        ascii.divideHorizontalLine();
        System.out.println("Производители:");
        for (int i = 0; i < carBrand.length; i++) {
            System.out.println((i + 1) + ". " + carBrand[i]);
        }
        size = carBrand.length;
        System.out.print("Выберите проивзодителя: ");
        x = infoInput(size);
        brand = carBrand[x];
        ascii.divideHorizontalLine();
        System.out.println("Доступные модели:");
        for (int i = 0; i < carModel.length; i++) {
            System.out.println((i + 1) + ". " + carModel[i]);
        }
        size = carModel.length;
        System.out.print("Выберите модель транспорта: ");
        x = infoInput(size);
        model = carBrand[x];
        ascii.divideHorizontalLine();
        System.out.println("Типы двигателей:");
        for (int i = 0; i < engineType.length; i++) {
            System.out.println((i + 1) + ". " + engineType[i]);
        }
        size = engineType.length;
        System.out.print("Выберите тип двигателя: ");
        x = infoInput(size);
        engine = engineType[x];
        ascii.divideHorizontalLine();
        System.out.println("Типы коробки передач:");
        for (int i = 0; i < transmissionType.length; i++) {
            System.out.println((i + 1) + ". " + transmissionType[i]);
        }
        size = transmissionType.length;
        System.out.print("Выберите тип коробки передач: ");
        x = infoInput(size);
        transmission = engineType[x];
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
        ascii.line();
        System.out.println("Машина заказана. Осталось закрепить её определенному продавцу.");
        ascii.divideHorizontalLine();
        System.out.println("Сотрудники автосалона: ");
        int i = 1;
        for (Employee e : employees) {
            System.out.println(i + ". " + e.name + " " + e.familyName);
            i++;
        }
        if (i == 1) {
            System.out.println("В вашем автосалоне нет сотрудников. ТАК НАЙМИТЕ! Че как баклан?");
        } else {
            x = scanner.nextInt() - 1;
            if (x > employees.size() || x < 0) {
                System.err.println("\nНеправильный ввод! Попробуй ещё раз:");
                while (true) {
                    x = scanner.nextInt();
                    if (x > employees.size() || x < 0) {
                        System.err.println("Неправильный ввод! Попробуй ещё раз:");
                    } else {
                        break;
                    }
                }
            }
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
        String name, familyName, address, fatherName;
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

    //одно из моих главных творений: ASCII-таблица, которая адаптируется по ширине строк полей объектов класса
    //checkEmloyees() - первая ступень постройки таблицы: прописывает столбцы. В конце запускает printRows().
    public static void checkEmployees() {
        int number = 0;

        for (Employee e : employees) {
            number++;
        }

        if (number == 0) {
            System.out.println("В вашем автосалоне нет сотрудников. ТАК НАЙМИТЕ! Че как баклан?");
        } else {
            int FIOSize = 0;
            int maxJobSize = 0;

            int numberSize = Integer.toString(number).length();

            for (Employee e : employees) {
                if (e.FIO.length() > FIOSize) {
                    FIOSize = e.FIO.length();
                }
                if (e.job.length() > maxJobSize) {
                    maxJobSize = e.job.length();
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
        int i = 0;
        while (true) {
            if (i == eightColumn) {
                ascii.border();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn ||
                    i == sixthColumn || i == seventhColumn) {
                ascii.cross();
                i++;
                continue;
            }
            ascii.equal();
            i++;
        }
        for (Employee e : employees) {
            findAMiddle(0, firstColumn, Integer.toString(employees.indexOf(e) + 1));
            ascii.bar();
            findAMiddle(firstColumn, secondColumn - 1, e.FIO);
            ascii.bar();
            findAMiddle(secondColumn, thirdColumn - 1, Integer.toString(e.age));
            ascii.bar();
            findAMiddle(thirdColumn, fourthColumn - 1, e.job);
            ascii.bar();
            findAMiddle(fourthColumn, fifthColumn - 1, Integer.toString(e.amountOfCarsSoldThisPeriod));
            ascii.bar();
            findAMiddle(fifthColumn, sixthColumn - 1, Integer.toString(e.profitOfSoldCars));
            ascii.bar();
            findAMiddle(sixthColumn, seventhColumn - 1, Integer.toString(e.salary));
            ascii.bar();
            findAMiddle(seventhColumn, eightColumn - 1, Integer.toString(e.finalOutcome));
            ascii.bar();
            System.out.println("");
        }
        i = 0;

        while (true) {
            if (i == eightColumn) {
                ascii.corner();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn ||
                    i == sixthColumn || i == seventhColumn) {
                ascii.bottom();
                i++;
                continue;
            }
            ascii.equal();
            i++;
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
        int y = 0;
        for (int i = side; i < side + Z.length(); i++) {
            System.out.print(Z.charAt(y));
            y++;
        }
        for (int i = side + Z.length(); i < distance; i++) {
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
        for (Employee e : employees) {
            System.out.println((employees.indexOf(e) + 1) + ". " + e.FIO);
        }
        int listSize = employees.size();
        int choice = infoInput(listSize);
        System.out.println("Ха-ха! Мне он всегда не нравился. УВОЛЕН!");
        employees.remove(choice);
    }

    //payday() - выдает зарплату сотрудникам. Обнуляет итоговую зарплату.
    public static void payday() {
        System.out.println("Зарплата выдана. Статистика прибыли, продаж автомобилей сброшена у сотрудников.");
        for (Employee e : employees) {
            e.profitOfSoldCars = 0;
            e.amountOfCarsSoldThisPeriod = 0;
        }
    }

    //checkClients() - аналогичные метод checkEmployees(). ASCII-таблица, но для списка клиентов.
    // Первая ступень: прописывание столбцов
    public static void checkClients() {
        int number = 0;

        for (Client e : clients) {
            number++;
        }

        if (number == 0) {
            System.out.println("В вашем автосалоне нет клиентов. ТАК НАЙДИТЕ! Воровство никто не отменял!");
        } else {
            int FISize = 0;
            int maxAddressSize = 0;
            int numberSize = Integer.toString(number).length();

            for (Client e : clients) {
                if (e.FI.length() > FISize) {
                    FISize = e.FI.length();
                }
                if (e.address.length() > maxAddressSize) {
                    maxAddressSize = e.address.length();
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
        int i = 0;
        while (true) {
            if (i == sixthColumn) {
                ascii.border();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn) {
                ascii.cross();
                i++;
                continue;
            }
            ascii.equal();
            i++;
        }
        for (Client e : clients) {
            findAMiddle(0, firstColumn, Integer.toString(clients.indexOf(e) + 1));
            ascii.bar();
            findAMiddle(firstColumn, secondColumn - 1, e.FI);
            ascii.bar();
            findAMiddle(secondColumn, thirdColumn - 1, Integer.toString(e.age));
            ascii.bar();
            findAMiddle(thirdColumn, fourthColumn - 1, e.address);
            ascii.bar();
            String Sex;
            if (e.Sex) {
                Sex = "Мужской";
            } else {
                Sex = "Женский";
            }
            findAMiddle(fourthColumn, fifthColumn - 1, Sex);
            ascii.bar();
            String inside;
            if (e.insideShop) {
                inside = "Да";
            } else {
                inside = "Нет";
            }
            findAMiddle(fifthColumn, sixthColumn - 1, inside);
            ascii.bar();
            System.out.println("");
        }
        i = 0;
        while (true) {
            if (i == sixthColumn) {
                ascii.corner();
                break;
            }
            if (i == firstColumn || i == secondColumn || i == thirdColumn || i == fourthColumn || i == fifthColumn) {
                ascii.bottom();
                i++;
                continue;
            }
            ascii.line();
            i++;
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
        for(Client e : clients){
            if(e.insideShop) {
                System.out.println((clients.indexOf(e) + 1) + ". " + e.FI);
            }
        }
        int size = clients.size();
        int chosenClient = infoInput(size);
        checkCars();
        ascii.line();
        System.out.println("Выберите сотрудника автосалона, чей автомобиль вы бы хотели купить?");
        int chosenEmployee;
        while(true) {
            for (Employee e : employees) {
                if (!e.carList.isEmpty()) {
                    System.out.println((employees.indexOf(e) + 1) + ". " + e.FIO);
                } else {
                    System.err.println((employees.indexOf(e) + 1) + ". " + e.FIO + " [НЕДОСТУПНО]");
                }
            }
            size = employees.size();
            chosenEmployee = infoInput(size);
            if(employees.get(chosenEmployee).carList.isEmpty()){
                System.err.println("НЕПРАВИЛЬНЫЙ ВВОД, ТУПИЦА. ВЫБЕРИ ДРУГОГО!");
            } else {
                break;
            }
        }
        System.out.println("Выберите машину, которую вы хотите купить у " + employees.get(chosenEmployee).FIO);
        employees.get(chosenEmployee).showCars();
        int chosenCar = infoInput(employees.get(chosenEmployee).carList.size());
        employees.get(chosenEmployee).sellCar(employees.get(chosenEmployee).carList.get(chosenCar), clients.get(chosenCar));
        clients.remove(clients.get(chosenClient));
    }

    // checkCars() - просто выводит список всех машин, которые сейчас находятся в автосалоне.
    public static void checkCars(){
        System.out.println("Список машин доступных в автосалоне:");
        for(Employee e : employees){
            e.showCars();
        }
    }
}




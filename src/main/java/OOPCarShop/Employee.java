package main.java.OOPCarShop;

import java.util.ArrayList;

public class Employee extends Person {
    //бесполезный класс сотрудника автосалона, содержит в себе бесполезные поля и функции
    private String fatherName;
    private String job;
    private ArrayList<Car> carList = new ArrayList<>();
    private int amountOfCarsSoldThisPeriod = 0;
    private int profitOfSoldCars = 0;
    private int salary = 20000;
    private int finalOutcome;

    //конструктор
    public Employee(String name, String familyName, int age, String fatherName, String job) {
        super(name, familyName, age);
        this.fatherName = fatherName;
        this.job = job;
    }

    public String FIO() {
        return getFamilyName() + " " + Character.toString(getName().charAt(0)) + ". " + Character.toString(fatherName.charAt(0)) + ".";
    }

    //бесполезный метод
    public void move() {
        System.out.println(getName() + "сделал несколько шагов.");
    }

    //бесполезный метод
    public void sell() {
        System.out.println("Работник " + getName() + " пытается продать машину клиентам.");
    }

    //метод, который удаляет машину из списка
    public void deleteCar(Car car) {
        int x = carList.indexOf(car);
        System.out.println("Машина " + car + " была удалена успешно.");
        carList.remove(x);
    }

    //метод, который добавляет машину в список
    public void addCar(Car car) {
        carList.add(car);
        System.out.println("Машина " + car + " была добавлена успешно.");
    }

    //метод, который отображает машины, которые имеются у данного сотрудника
    public void showCars() {
        if (!carList.isEmpty()) {
            System.out.println("За сотрудник автосалона " + getName() + " " + getFamilyName() + " закреплены машины:");
            for (int i = 0; i < carList.size(); i++) {
                System.out.println((i + 1) + ". " + carList.get(i) + ";");
            }
        } else {
            System.out.println("За сотрудником автосалона " + getName() + " " + getFamilyName() + " не закреплено машин в данный момент.");
        }
    }

    //Продолжение метода clientSellCar() - финал: машина продается(удаляется из списка), начисляется прибавка к зарплате
    //добавляется +1 к счётчику проданных машин за определенный период.
    public void sellCar(Car carForSale, Client buyer) {
        System.out.println("Поздравляю! Покупатель " + buyer.getFamilyName() + " " + buyer.getName() + " стал обладателем " +
                "небитого и точно неукраденного " + carForSale);
        amountOfCarsSoldThisPeriod++;
        profitOfSoldCars += carForSale.getPrice();
        buyer.setHasACar(true);
        buyer.setInsideShop(false);
        System.out.println("Клиент теперь имеет машину и с радостью уехал из автосалона.");
        deleteCar(carForSale);
        System.out.println("Продавец продал машину. К концу месяца это станет его небольшой прибавкой к ЗП.");
    }

    //сеттер итоговой зарплаты по вычислению из базовой зарплаты,суммы стоимостей проданных машин и количества проданных машин
    public int setFinalSalary() {
        if (amountOfCarsSoldThisPeriod == 0) {
            return salary;
        }
        int finalOutcome = salary + (profitOfSoldCars / (amountOfCarsSoldThisPeriod * 10));
        return finalOutcome;
    }

    //геттеры защищенных полей
    public ArrayList<Car> getCarList() {
        return carList;
    }

    public int getAmountOfCarsSoldThisPeriod() {
        return amountOfCarsSoldThisPeriod;
    }

    public int getFinalOutcome() {
        return finalOutcome;
    }

    public int getProfitOfSoldCars() {
        return profitOfSoldCars;
    }

    public int getSalary() {
        return salary;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getJob() {
        return job;
    }

    //сеттеры счётчиков количества и сумма стоимости проданных сотрудником автосалона машин
    public void setAmountOfCarsSoldThisPeriod(int amountOfCarsSoldThisPeriod) {
        this.amountOfCarsSoldThisPeriod = amountOfCarsSoldThisPeriod;
    }

    public void setProfitOfSoldCars(int profitOfSoldCars) {
        this.profitOfSoldCars = profitOfSoldCars;
    }
}

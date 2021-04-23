package main.java.OOPCarShop;

import java.util.ArrayList;

public class Employee extends Person {
    //бесполезный класс сотрудника автосалона, содержит в себе бесполезные поля и функции
    String fatherName;
    int salary = 20000;
    String job;
    ArrayList<Car> carList = new ArrayList<>();
    int amountOfCarsSoldThisPeriod = 0;
    int profitOfSoldCars = 0;
    String FIO;
    int finalOutcome = finalSalary();

    public int finalSalary(){
        if(amountOfCarsSoldThisPeriod == 0){
            return salary;
        }
        int finalOutcome = salary + (profitOfSoldCars/(amountOfCarsSoldThisPeriod*10));
        return finalOutcome;
    }

    //конструктор
    public Employee(String name, String familyName, int age, String fatherName, String job) {
        super(name, familyName, age);
        this.fatherName = fatherName;
        this.job = job;
        this.FIO = this.familyName + " " + Character.toString(this.name.charAt(0)) + ". " + Character.toString(this.fatherName.charAt(0)) + ".";
    }

    //бесполезный метод
    public void move() {
        System.out.println(name + "сделал несколько шагов.");
    }

    //бесполезный метод
    public void sell() {
        System.out.println("Работник " + name + " пытается продать машину клиентам.");
    }

    //метод, который удаляет машину из списка
    public void deleteCar(Car a) {
        int x = carList.indexOf(a);
        carList.remove(x);
        System.out.println("Машина " + a.brand + a.model + a.dateOfRelease + " г. была удалена успешно.");
    }

    //метод, который добавляет машину в список
    public void addCar(Car a) {
        carList.add(a);
        System.out.println("Машина " + a.brand + a.model + a.dateOfRelease + " г. была добавлена успешно.");
    }

    //метод, который отображает машины, которые имеются у данного сотрудника
    public void showCars() {
        if (!carList.isEmpty()) {
            System.out.println("За сотрудник автосалона " + name + " " + familyName + " закреплены машины:");
            int index = 1;
            for (Car a : carList) {
                System.out.println(index + ". " + a.brand + " " + a.model + " " + a.dateOfRelease + " г.;");
                index++;
            }
        } else {
            System.out.println("За сотрудником автосалона " + name + " " + familyName + " не закреплено машин в данный момент.");
        }
    }

    //Продолжение метода clientSellCar() - финал: машина продается(удаляется из списка), начисляется прибавка к зарплате
    //добавляется +1 к счётчику проданных машин за определенный период.
    public void sellCar(Car a, Client b) {
        System.out.println("Поздравляю! Покупатель " + b.familyName + " " + b.name + " стал обладателем " +
                "небитого и точно неукраденного " + a.brand + " " + a.model + " " + a.dateOfRelease + " года выпуска.");
        amountOfCarsSoldThisPeriod++;
        profitOfSoldCars += a.price;
        b.hasACar = true;
        b.insideShop = false;
        System.out.println("Клиент теперь имеет машину и с радостью уехал из автосалона.");
        deleteCar(a);
        System.out.println("Продавец продал машину. К концу месяца это станет его небольшой прибавкой к ЗП.");
        finalOutcome = finalSalary();
    }
}

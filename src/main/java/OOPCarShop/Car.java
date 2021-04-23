package main.java.OOPCarShop;

public class Car {

    //бесполезный класс машины
    String brand;
    String model;
    String type;
    String engine;
    String transmission;
    String owner = null;
    int dateOfRelease;
    int price;

    public Car(String brand, String model, String type, String engine, String transmission, int dateOfRelease, int price){
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.engine = engine;
        this.transmission = transmission;
        this.dateOfRelease = dateOfRelease;
        this.price = price;
    }

    public void move(){
        System.out.println("Педаль газа в пол и поехали!");
    }

    public void brake(){
        System.out.println("Педаль тормоза в пол и остановились.");
    }
}

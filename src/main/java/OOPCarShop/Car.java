package main.java.OOPCarShop;

public class Car {

    //бесполезный класс машины
    private String brand;
    private String model;
    private String type;
    private String engine;
    private String transmission;
    private String owner = null;
    private int dateOfRelease;
    private int price;

    public Car(String brand, String model, String type, String engine, String transmission, int dateOfRelease, int price){
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.engine = engine;
        this.transmission = transmission;
        this.dateOfRelease = dateOfRelease;
        this.price = price;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public String getType(){
        return type;
    }

    public String getEngine(){
        return engine;
    }

    public String getTransmission(){
        return transmission;
    }

    public String getOwner(){
        return owner;
    }

    public int getDateOfRelease() {
        return dateOfRelease;
    }

    public int getPrice() {
        return price;
    }

    public void move(){
        System.out.println("Педаль газа в пол и поехали!");
    }

    public void brake(){
        System.out.println("Педаль тормоза в пол и остановились.");
    }
}

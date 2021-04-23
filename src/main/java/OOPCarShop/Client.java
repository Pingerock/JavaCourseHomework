package main.java.OOPCarShop;

public class Client extends Person {
    //бесполезный класс клиента, который наследуется от класса человека (Person)
    String address;
    boolean Sex;
    boolean insideShop = true;
    boolean hasACar = false;
    String FI;

    public Client(String name, String familyName, int age, String address, boolean Sex) {
        super(name, familyName, age);
        this.address = address;
        this.Sex = Sex;
        FI = this.familyName + " " + this.name;
    }

    public void quit() {
        if (insideShop == false) {
            System.out.println(this.name + " уже находится за пределами автосалона");
        } else {
            System.out.println(this.name + " ушел из автосалона.");
            insideShop = false;
        }
    }

    public void enter() {
        if (insideShop == true) {
            System.out.println(this.name + " уже находится в автосалоне");
        } else {
            System.out.println(this.name + " вошел в автосалон");
            insideShop = true;
        }
    }

    public void whereIsClient() {
        if (insideShop == true) {
            System.out.println(this.name + " находится в автосалоне.");
        } else {
            System.out.println(this.name + "не в автосалоне.");
        }
    }
}

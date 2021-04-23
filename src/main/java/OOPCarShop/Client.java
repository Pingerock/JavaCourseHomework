package main.java.OOPCarShop;

public class Client extends Person {
    //бесполезный класс клиента, который наследуется от класса человека (Person)
    private String address;
    private boolean Sex;
    private boolean insideShop = true;
    private boolean hasACar = false;
    private String FI;

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

    //сеттеры "состояний" клиента: есть ли у него машина; он сейчас в автосалоне?
    public void setInsideShop(boolean a) {
        this.insideShop = a;
    }

    public void setHasACar(boolean a) {
        this.hasACar = a;
    }

    //геттеры
    public String getAddress() {
        return address;
    }

    public boolean isSex() {
        return Sex;
    }

    public String getFI() {
        return FI;
    }

    public boolean isInsideShop() {
        return insideShop;
    }
}

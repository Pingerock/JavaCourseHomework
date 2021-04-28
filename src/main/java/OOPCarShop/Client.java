package main.java.OOPCarShop;

public class Client extends Person {
    //бесполезный класс клиента, который наследуется от класса человека (Person)
    private String address;
    private String sex;
    private boolean insideShop = true;
    private boolean hasACar = false;


    public Client(String name, String familyName, int age, String address, String sex) {
        super(name, familyName, age);
        this.address = address;
        this.sex = sex;
    }

    public String FI() {
        return getFamilyName() + " " + getName();
    }

    public void quit() {
        if (insideShop == false) {
            System.out.println(getName() + " уже находится за пределами автосалона");
        } else {
            System.out.println(getName() + " ушел из автосалона.");
            insideShop = false;
        }
    }

    public void enter() {
        if (insideShop == true) {
            System.out.println(getName() + " уже находится в автосалоне");
        } else {
            System.out.println(getName() + " вошел в автосалон");
            insideShop = true;
        }
    }

    public void whereIsClient() {
        if (insideShop == true) {
            System.out.println(getName() + " находится в автосалоне.");
        } else {
            System.out.println(getName() + "не в автосалоне.");
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

    public String getSex() {
        return sex;
    }

    public boolean isInsideShop() {
        return insideShop;
    }
}

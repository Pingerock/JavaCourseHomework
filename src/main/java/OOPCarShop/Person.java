package main.java.OOPCarShop;

public class Person {
    //бесполезный класс-родитель человека, содержит в себе бесполезные поля
    protected String name;
    protected String familyName;
    protected int age;

    public Person(String name, String familyName, int age) {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }

    public void speak() {
        System.out.println(this.name + "сказал пару слов в никуда.");
    }
}

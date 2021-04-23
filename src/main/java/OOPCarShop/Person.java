package main.java.OOPCarShop;

public class Person {
    //бесполезный класс-родитель человека, содержит в себе бесполезные поля
    String name;
    String familyName;
    int age;

    public Person(String name, String familyName, int age){
        this.name = name;
        this.familyName = familyName;
        this.age = age;
    }

    public void speak(){
        System.out.println(this.name + "сказал пару слов в никуда.");
    }
}

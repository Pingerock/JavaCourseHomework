package main.java.OOPCarShop.enums;

public enum Engine {
    GAS("Бензиновый"),
    DIESEL("Дизельный"),
    ELECTRICITY("Электрический"),
    HYBRID("Гибридный");

    private final String name;

    Engine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

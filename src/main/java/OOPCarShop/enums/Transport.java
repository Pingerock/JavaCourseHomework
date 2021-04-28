package main.java.OOPCarShop.enums;

public enum Transport {
    TRUCK("Грузовой транспорт"),
    LIGHT("Легковой транспорт"),
    BUS("Автобус"),
    MOTORCYCLE("Мотоцикл");

    private final String name;

    Transport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package main.java.OOPCarShop.enums;

public enum CarModel {
    MASQUERADE("Masquerade"),
    SALVATION("Salvation"),
    MOSCOW("Moscow"),
    ENTROPY("Entropy");

    private final String name;

    CarModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

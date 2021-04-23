package main.java.OOPCarShop.enums;

public enum CarBrand {
    AUDI("Audi"),
    BMW("BMW"),
    FORD("Ford"),
    NISSAN("Nissan"),
    SUBARU("Subaru");

    private final String name;

    CarBrand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

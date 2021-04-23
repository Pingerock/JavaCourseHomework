package main.java.OOPCarShop.enums;

public enum Transmission {
    STEP("Ступенчатая"),
    NONSTEP("Бесступенчатая"),
    COMB("Комбинированная");

    private final String name;

    Transmission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

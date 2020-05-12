package com.mcdonalds.food;

public enum DrinkType {
    COKE(1.0, "Coke"),
    SPRITE(1.0, "Sprite"),
    DIET_COKE(1.0, "Diet Coke"),
    WATER(5.0, "Water"),
    ADULT_BEVERAGE(1.0, "Adult Beverage");

    private Double price;
    private String type;

    DrinkType(final Double price, final String stringType) {
        this.price = price;
        this.type = stringType;
    }

    public double price() { return price; }
    public String type() { return type; }

    public static DrinkType fromString(String text) {
        for (DrinkType ent: DrinkType.values()) {
            if (ent.type().equals(text)) {
                return ent;
            }
        }
        return null;
    }
}
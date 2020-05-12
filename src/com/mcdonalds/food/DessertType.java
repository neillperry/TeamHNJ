package com.mcdonalds.food;

public enum DessertType {
    APPLE_PIE(3.0, "Apple Pie"),
    ICE_CREAM (4.0, "Ice Cream"),
    BIRTHDAY_CAKE(3.0, "Birthday Cake"),
    COOKIE(4.0, "Cookie"),
    FROSTED_TATER_TOTS(1.0, "Frosted Tater Tots");

    private Double price;
    private String type;

    DessertType(final Double price, final String stringType) {
        this.price = price;
        this.type = stringType;
    }

    public double price() { return price; }

    public String type() { return type; }

    public static DessertType fromString(String text) {
        for (DessertType ent: DessertType.values()) {
            if (ent.type().equals(text)) {
                return ent;
            }
        }
        return null;
    }

}
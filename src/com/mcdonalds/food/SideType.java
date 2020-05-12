package com.mcdonalds.food;

public enum SideType {
    FRIES(2.0, "Fries"),
    APPLE(8.0, "Apple"),
    MOZZARELLA_STICKS(3.0, "Mozzarella Sticks"),
    SALAD(2000.0, "Salad"),
    ONION_RINGS(3.0, "Onion Rings"),
    MYSTERY(1.0, "Mystery");

    private Double price;
    private String type;

    SideType(final Double price, final String stringType) {
        this.price = price;
        this.type = stringType;
    }

    public double price() { return price; }
    public String type() { return type; }
}
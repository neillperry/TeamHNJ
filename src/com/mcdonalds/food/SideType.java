package com.mcdonalds.food;

public enum SideType {
    FRIES(2.0),
    APPLE(8.0),
    MOZZARELLA_STICKS(3.0),
    SALAD(2000.0),
    ONION_RINGS(3.0),
    MYSTERY(1.0);

    private Double price;

    SideType(final Double price) {
        this.price = price;
    }

    public double price() { return price; }
}
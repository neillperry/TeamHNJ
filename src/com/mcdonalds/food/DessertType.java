package com.mcdonalds.food;

public enum DessertType {
    APPLE_PIE(3.0),
    ICE_CREAM (4.0),
    BIRTHDAY_CAKE(3.0),
    COOKIE(4.0),
    FROSTED_TATER_TOTS(1.0);

    private Double price;
    private Size size;

    DessertType(final Double price) {
        this.price = price;
    }

    public double price() { return price * size.multiplier(); }
    public Size size() { return size; }

    public void setSize(final Size size) {
        this.size = size;
    }
}
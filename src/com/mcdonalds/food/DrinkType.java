package com.mcdonalds.food;

public enum DrinkType {
    COKE(1.0),
    SPRITE(1.0),
    DIET_COKE(1.0),
    WATER(5.0),
    ADULT_BEVERAGE(1.0);

    private Double price;
    private Size size;

    DrinkType(final Double price) {
        this.price = price;
    }

    public double price() { return price * size.multiplier(); }
    public Size size() { return size; }

    public void setSize(final Size size) {
        this.size = size;
    }
}
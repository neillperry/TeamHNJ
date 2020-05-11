package com.mcdonalds.food;

public enum EntreeType {
    HAMBURGER(4.0),
    CHEESEBURGER(5.0),
    CHICKEN_SANDWICH(6.0),
    CHICKEN_NUGGETS(3.0),
    MYSTERY(300.0);

    private Double price;
    private Size size;

    EntreeType(final Double price) {
        this.price = price;
    }

    public double price() { return price * size.multiplier(); }
    public Size size() { return size; }

    public void setSize(final Size size) {
        this.size = size;
    }
}
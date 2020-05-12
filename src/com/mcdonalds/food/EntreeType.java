package com.mcdonalds.food;

public enum EntreeType {
    HAMBURGER(4.0, "Hamburger"),
    CHEESEBURGER(5.0, "Cheeseburger"),
    CHICKEN_SANDWICH(6.0, "Chicken Sandwich"),
    CHICKEN_NUGGETS(3.0, "Chicken Nuggets"),
    MYSTERY(300.0, "Mystery");

    private Double price;
    private String type;

    EntreeType(final Double price, final String stringType) {
        this.price = price;
        this.type = stringType;
    }

    public double price() { return price; }
    public String type() { return type; }

}
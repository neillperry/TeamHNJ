package com.mcdonalds.food;

public enum Size {
    LARGE(2.0, "Large"),
    REGULAR(1.5, "Regular"),
    SMALL(1.0, "Small");

    private Double multiplier;
    private String type;

    Size(final Double multiplier, final String stringType) {
        this.multiplier = multiplier;
        this.type = stringType;
    }

    public Double multiplier() { return multiplier; }
    public String type() { return type; }

}


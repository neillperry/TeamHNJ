package com.mcdonalds.food;

public enum Size {
    LARGE(2.0),
    REGULAR(1.5),
    SMALL(1.0);

    private Double multiplier;

    Size(final Double multiplier) {
        this.multiplier = multiplier;
    }

    public Double multiplier() { return multiplier; }

}


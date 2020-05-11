package com.mcdonalds.food;

public class Dessert extends Food {
    private DessertType type;

    Dessert(DessertType type) {
        super();
        setType(type);
    }

    public DessertType getType() {
        return type;
    }

    public void setType(DessertType type) {
        this.type = type;
    }

    public enum DessertType {
        COKE, SPRITE, DIET_COKE, WATER, ADULT_BEVERAGE
    }

}

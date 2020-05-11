package com.mcdonalds.food;


import java.util.HashMap;

public class Drink extends Food {
    private DrinkType type;
    private static HashMap<DrinkType, Double> priceMap;


    Drink(DrinkType type, Size size) {
        setSize(size);
        setType(type);
        setPrice();
    }

    public DrinkType getType() {
        return type;
    }

    public Double setPrice() {
        switch(getSize()) {
            case SMALL:
                return 1.0 * priceMap.get(getType());
            case REGULAR:
                return 1.5 * priceMap.get(getType());
            default:
                return 2.0 * priceMap.get(getType());
        }
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public enum DrinkType {
        COKE, SPRITE, DIET_COKE, WATER, ADULT_BEVERAGE
    }

    static {
        priceMap = new HashMap<DrinkType, Double>();
        priceMap.put(DrinkType.COKE, 10.0);
        priceMap.put(DrinkType.DIET_COKE, 10.0);
        priceMap.put(DrinkType.SPRITE, 10.0);
        priceMap.put(DrinkType.WATER, 50.0);
        priceMap.put(DrinkType.ADULT_BEVERAGE, 2.0);
    }

}


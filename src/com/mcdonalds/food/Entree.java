package com.mcdonalds.food;

import java.util.HashMap;

public class Entree extends Food {
    private EntreeType type;
    private Double price;
    private Size size;
    private static HashMap<EntreeType, Double> priceMap;


    Entree(EntreeType type, Size size) {
        setSize(size);
        setType(type);
        price = calculatePrice(size);
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        size = size;
    }

    public EntreeType getType() {
        return type;
    }

    public void setType(EntreeType type) {
        this.type = type;
    }

    public Double getPrice() { return price; }

    public static enum EntreeType {
        HAMBURGER, CHEESEBURGER, CHICKEN_SANDWICH, CHICKEN_NUGGETS, MYSTERY
    }

    @Override
    public Double calculatePrice(Size size) {
        switch(size) {
            case SMALL:
                return 1.0 * priceMap.get(getType());
            case REGULAR:
                return 1.5 * priceMap.get(getType());
            case LARGE:
                return 2.0 * priceMap.get(getType());
            default:
                return 2.0 * priceMap.get(getType());
        }
    }

    static {
        priceMap = new HashMap<EntreeType, Double>();
        priceMap.put(EntreeType.HAMBURGER, 4.0);
        priceMap.put(EntreeType.CHEESEBURGER, 5.0);
        priceMap.put(EntreeType.CHICKEN_SANDWICH, 6.0);
        priceMap.put(EntreeType.CHICKEN_NUGGETS, 3.0);
        priceMap.put(EntreeType.MYSTERY, 300.0);
    }

}

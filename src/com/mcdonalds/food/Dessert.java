package com.mcdonalds.food;

import java.util.HashMap;

public class Dessert extends FoodItem {
    private DessertType type;
    private Double price;
    private Size size;
    private static HashMap<DessertType, Double> priceMap;


    Dessert(DessertType type, Size size) {
        setSize(size);
        setType(type);
        price = calculatePrice(size);
    }

    public DessertType getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        size = size;
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

    public Double getPrice() {
        return price;
    }

    public void setType(DessertType type) {
        this.type = type;
    }


    public static enum DessertType {
        APPLE_PIE, ICE_CREAM, BIRTHDAY_CAKE, COOKIE, FROSTED_TATER_TOTS
    }

    static {
        priceMap = new HashMap<DessertType, Double>();
        priceMap.put(DessertType.APPLE_PIE, 3.0);
        priceMap.put(DessertType.ICE_CREAM, 3.0);
        priceMap.put(DessertType.BIRTHDAY_CAKE, 3.0);
        priceMap.put(DessertType.COOKIE, 4.0);
        priceMap.put(DessertType.FROSTED_TATER_TOTS, 1.0);
    }

}

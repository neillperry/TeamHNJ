package com.mcdonalds.food;

import java.util.HashMap;

public class Side extends FoodItem {
    private SideType type;
    private Double price;
    private Size size;
    private static HashMap<SideType, Double> priceMap;


    Side(SideType type, Size size) {
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

    public SideType getType() {
        return type;
    }

    public void setType(SideType type) {
        this.type = type;
    }

    public Double getPrice() { return price; }

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


    public static enum SideType {
        FRIES, APPLE, MOZZARELLA_STICKS, SALAD, ONION_RINGS, MYSTERY
    }

    static {
        priceMap = new HashMap<SideType, Double>();
        priceMap.put(SideType.FRIES, 2.0);
        priceMap.put(SideType.APPLE, 8.0);
        priceMap.put(SideType.MOZZARELLA_STICKS, 3.0);
        priceMap.put(SideType.SALAD, 2000.0);
        priceMap.put(SideType.ONION_RINGS, 3.0);
        priceMap.put(SideType.MYSTERY, 1.0);
    }
}

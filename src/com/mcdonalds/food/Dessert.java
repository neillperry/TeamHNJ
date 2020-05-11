package com.mcdonalds.food;

import java.util.HashMap;

public class Dessert extends FoodItem {
    private DessertType type;
    private Double price;
    private Size size;

    public Dessert(DessertType type, Size size) {
        setType(type);
        setSize(size);
        price = type.price() * size.multiplier();
    }

    public DessertType getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public void setSize(Size size) {
        size = size;
    }

    public void setType(DessertType type) {
        this.type = type;
    }

}

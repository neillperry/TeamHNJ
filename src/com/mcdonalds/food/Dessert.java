package com.mcdonalds.food;

import java.util.HashMap;

public class Dessert extends FoodItem {
    private DessertType type;
    private Double price;
    private Size size;

    Dessert(DessertType type) {
        setType(type);
        setSize();
        setPrice();
    }

    public DessertType getType() {
        return type;
    }

    public Size getSize() {
        return type.size();
    }

    public Double getPrice() {
        return price;
    }

    public void setSize() {
        size = type.size();
    }

    public void setPrice() { price = type.price(); }

    public void setType(DessertType type) {
        this.type = type;
    }

}

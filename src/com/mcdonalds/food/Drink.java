package com.mcdonalds.food;


import java.util.HashMap;

public class Drink extends FoodItem {
    private DrinkType type;
    private Double price;
    private Size size;

    Drink(DrinkType type, Size size) {
        setSize(size);
        setType(type);
        setPrice();
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public DrinkType getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        size = type.size();
    }

    public void setPrice() { price = type.price(); }

    public Double getPrice() {
        return price;
    }

}


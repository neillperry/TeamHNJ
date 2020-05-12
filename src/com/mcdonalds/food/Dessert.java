package com.mcdonalds.food;

import java.util.HashMap;

public class Dessert extends FoodItem {
    private DessertType type;
    private Double price;
    private Size size;
    private FoodType foodType;

    public Dessert(DessertType type, Size size) {
        setType(type);
        setSize(size);
        foodType = FoodType.DESSERT;
        price = type.price() * size.multiplier();
    }

    public DessertType getType() {
        return type;
    }

    public FoodType getFoodType() {
        return foodType;
    }


    public Size getSize() {
        return size;
    }

    public Double getPrice() {
        return price;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setType(DessertType type) {
        this.type = type;
    }

}

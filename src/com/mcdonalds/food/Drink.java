package com.mcdonalds.food;

import com.mcdonalds.food.DrinkType;

public class Drink extends FoodItem {
    private DrinkType type;
    private Double price;
    private Size size;
    private FoodType foodType;

    public Drink(DrinkType type, Size size) {
        setSize(size);
        setType(type);
        foodType = FoodType.DRINK;
        price = type.price() * size.multiplier();
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public FoodType getFoodType() { return foodType; }

    public DrinkType getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }
}


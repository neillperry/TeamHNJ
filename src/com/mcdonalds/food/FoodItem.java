package com.mcdonalds.food;


public abstract class FoodItem {
    private Double price;
    private Size size;
    private FoodType foodType;

    public Double getPrice() {
        return price;
    }

    public FoodType getFoodType() { return foodType; }
}

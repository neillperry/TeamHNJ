package com.mcdonalds.food;


public class Entree extends FoodItem {
    private EntreeType type;
    private Double price;
    private Size size;
    private FoodType foodType;


    public Entree(EntreeType type, Size size) {
        setType(type);
        setSize(size);
        foodType = FoodType.ENTREE;
        price = type.price() * size.multiplier();
    }

    public Size getSize() {
        return size;
    }

    public FoodType getFoodType() { return foodType; }

    public void setSize(Size size) {
        this.size = size;
    }

    public EntreeType getType() {
        return type;
    }

    public void setType(EntreeType type) {
        this.type = type;
    }

    public Double getPrice() { return price; }
}

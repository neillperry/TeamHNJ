package com.mcdonalds.food;

public class Side extends FoodItem {
    private SideType type;
    private Size size;
    private Double price;
    private FoodType foodType;

    public Side(SideType type, Size size) {
        setType(type);
        setSize(size);
        foodType = FoodType.SIDE;
        price = type.price() * size.multiplier();
    }

    // ACCESSOR  / METHODS
    public Size getSize() {
        return size;
    }

    public FoodType getFoodType() { return foodType; }

    public void setSize(Size size) {
        this.size = size;
    }

    public SideType getType() {
        return type;
    }

    public void setType(SideType type) {
        this.type = type;
    }

    public Double getPrice() { return price; }
}

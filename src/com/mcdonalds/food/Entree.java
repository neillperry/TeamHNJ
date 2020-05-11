package com.mcdonalds.food;

import java.util.HashMap;

public class Entree extends FoodItem {
    private EntreeType type;
    private Double price;
    private Size size;


    Entree(EntreeType type, Size size) {
        setType(type);
        setSize();
        setPrice();
    }

    public Size getSize() {
        return size;
    }

    public void setSize() {
        size = type.size();
    }

    public EntreeType getType() {
        return type;
    }

    public void setType(EntreeType type) {
        this.type = type;
    }

    public Double getPrice() { return price; }

    public void setPrice() { price = type.price(); }
}

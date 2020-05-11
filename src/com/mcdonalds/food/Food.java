package com.mcdonalds.food;

import java.util.HashMap;

public class Food {
    private Double price;
    private Size size;

    Food(Size size) {
        setSize(size);
    }

    Food(){}

    public double getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

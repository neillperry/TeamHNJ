package com.mcdonalds.food;

public class Food {
    private double price;
    private Size size;

    Food(double price, Size size) {
        setPrice(price);
        setSize(size);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

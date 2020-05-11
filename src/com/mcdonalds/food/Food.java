package com.mcdonalds.food;

import java.util.HashMap;

public abstract class Food {
    private Double price;
    private Size size;


    public abstract Double getPrice();

    public abstract Double setPrice();

    public abstract Size getSize();

    public abstract void setSize(Size size);
}

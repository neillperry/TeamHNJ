package com.mcdonalds.food;

import java.util.HashMap;

public abstract class FoodItem {
    private Double price;

    public abstract Double calculatePrice(Size size);

}

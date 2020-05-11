package com.mcdonalds.food;

import java.util.HashMap;

public abstract class Food {
    private Double price;

    public abstract Double calculatePrice(Size size);

}

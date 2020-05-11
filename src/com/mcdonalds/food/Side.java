package com.mcdonalds.food;

import java.util.HashMap;
import com.mcdonalds.food.SideType.*;

public class Side extends FoodItem {
    private SideType type;
    private Size size;
    private Double price;

    public Side(SideType type, Size size) {
        setType(type);
        setSize(size);
        price = type.price() * size.multiplier();
    }

    // ACCESSOR  / METHODS
    public Size getSize() {
        return size;
    }

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

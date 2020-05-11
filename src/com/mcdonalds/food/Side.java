package com.mcdonalds.food;

import java.util.HashMap;
import com.mcdonalds.food.SideType.*;

public class Side extends FoodItem {
    private SideType type;
    private Size size;
    private Double price;

    Side(SideType type) {
        setType(type);
        setSize();
        price = getPrice();
    }

    // ACCESSOR  / METHODS
    public Size getSize() {
        return type.size();
    }

    public void setSize() {
        size = type.size();
    }

    public SideType getType() {
        return type;
    }

    public void setType(SideType type) {
        this.type = type;
    }

    public Double getPrice() { return type.price(); }
}

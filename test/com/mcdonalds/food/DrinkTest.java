package com.mcdonalds.food;

import static org.junit.Assert.*;
import org.junit.Test;
import com.mcdonalds.food.Drink.DrinkType;

class DrinkTest {

    @Test
    public void testSize() {
        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        assertEquals(testCoke.getSize(), Size.LARGE);
    }
}
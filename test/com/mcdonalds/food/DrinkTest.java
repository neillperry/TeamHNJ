package com.mcdonalds.food;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mcdonalds.food.Drink.DrinkType;

public class DrinkTest extends TestCase {

    @Test
    public void testGetType() {
        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        assertEquals(testCoke.getSize(), Size.LARGE);
    }

    public void testGetSize() {
        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        assertEquals(testCoke.getSize(), Size.LARGE);
    }

    public void testSetSize() {
    }

    public void testSetPrice() {
    }

    public void testGetPrice() {
    }

    public void testSetType() {
    }
}
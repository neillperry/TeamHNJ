package com.mcdonalds.food;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.mcdonalds.food.Drink.DrinkType;

public class DrinkTest extends TestCase {

    @Before
    

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

    public void testCalculatePrice() {
        Drink testCoke = new Drink(DrinkType.DIET_COKE, Size.REGULAR);
        System.out.println(testCoke.getPrice());
        assertEquals(testCoke.getPrice(), 15.0, 0.001);
    }

    public void testSetType() {
        Drink testWater = new Drink(DrinkType.WATER, Size.REGULAR);
        assertEquals(testWater.getType(), DrinkType.WATER);
    }
}
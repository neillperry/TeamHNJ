package com.mcdonalds.food;

import junit.framework.TestCase;

import static com.mcdonalds.food.Size.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mcdonalds.food.Drink.DrinkType;

public class DrinkTest extends TestCase {

    @Test
    public void testGetType() {
        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        Drink testSprite = new Drink(DrinkType.SPRITE, Size.REGULAR);
        Drink testAdult = new Drink(DrinkType.ADULT_BEVERAGE, SMALL);
        assertEquals(DrinkType.COKE, testCoke.getType());
        assertEquals(DrinkType.ADULT_BEVERAGE, testAdult.getType());
        assertEquals(DrinkType.SPRITE, testSprite.getType());
    }

    @Test
    public void testCalculatePrice() {
        Drink testDietCoke = new Drink(DrinkType.DIET_COKE, Size.LARGE);
        Drink testWater = new Drink(DrinkType.WATER, Size.REGULAR);
        Drink testAdult = new Drink(DrinkType.ADULT_BEVERAGE, SMALL);
        assertEquals(20.0, testDietCoke.getPrice(), 0.001);
        assertEquals(75.0, testWater.getPrice(), 0.001);
        assertEquals(2.0, testAdult.getPrice(), 0.001);
    }

    @Test
    public void testSetType() {
        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        Drink testSprite = new Drink(DrinkType.SPRITE, Size.LARGE);

        testCoke.setType(DrinkType.DIET_COKE);
        testSprite.setType(DrinkType.WATER);

        assertEquals(DrinkType.DIET_COKE, testCoke.getType());
        assertEquals(DrinkType.WATER, testSprite.getType());
    }
}
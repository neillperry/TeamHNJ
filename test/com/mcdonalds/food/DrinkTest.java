package com.mcdonalds.food;

import junit.framework.TestCase;

import static com.mcdonalds.food.Size.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.mcdonalds.food.DrinkType;

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
    public void testGetFoodType() {
        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        Drink testSprite = new Drink(DrinkType.SPRITE, Size.REGULAR);
        Drink testAdult = new Drink(DrinkType.ADULT_BEVERAGE, SMALL);

        assertEquals(FoodType.DRINK, testCoke.getFoodType());
        assertEquals(FoodType.DRINK, testAdult.getFoodType());
        assertEquals(FoodType.DRINK, testSprite.getFoodType());
    }

    @Test
    public void testGetPrice() {
        Drink testDietCoke = new Drink(DrinkType.DIET_COKE, Size.LARGE);
        Drink testWater = new Drink(DrinkType.WATER, Size.REGULAR);
        Drink testAdult = new Drink(DrinkType.ADULT_BEVERAGE, SMALL);
        assertEquals(2.0, testDietCoke.getPrice(), 0.001);
        assertEquals(7.5, testWater.getPrice(), 0.001);
        assertEquals(1.0, testAdult.getPrice(), 0.001);
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
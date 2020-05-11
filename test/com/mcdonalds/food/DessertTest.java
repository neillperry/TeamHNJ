package com.mcdonalds.food;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import com.mcdonalds.food.DessertType;
import com.mcdonalds.food.Size;

public class DessertTest extends TestCase {

    @Test
    public void testGetType() {
        Dessert cookie = new Dessert(DessertType.COOKIE, Size.SMALL);
        Dessert applePie = new Dessert(DessertType.APPLE_PIE, Size.REGULAR);
        Dessert taterTots = new Dessert(DessertType.FROSTED_TATER_TOTS, Size.SMALL);

        assertEquals(DessertType.COOKIE, cookie.getType());
        assertEquals(DessertType.APPLE_PIE, applePie.getType());
        assertEquals(DessertType.FROSTED_TATER_TOTS, taterTots.getType());
    }


    public void testCalculatePrice() {
        Dessert cookie = new Dessert(DessertType.COOKIE, Size.LARGE);
        Dessert applePie = new Dessert(DessertType.APPLE_PIE, Size.REGULAR);
        Dessert taterTots = new Dessert(DessertType.FROSTED_TATER_TOTS, Size.SMALL);
        assertEquals(8.0, cookie.getPrice(), 0.001);
        assertEquals(4.5, applePie.getPrice(), 0.001);
        assertEquals(1.0, taterTots.getPrice(), 0.001);
    }


    public void testSetType() {
        Dessert cookie = new Dessert(DessertType.COOKIE, Size.LARGE);
        Dessert applePie = new Dessert(DessertType.APPLE_PIE, Size.REGULAR);
        Dessert taterTots = new Dessert(DessertType.FROSTED_TATER_TOTS, Size.SMALL);

        applePie.setType(DessertType.COOKIE);
        cookie.setType(DessertType.FROSTED_TATER_TOTS);
        taterTots.setType(DessertType.APPLE_PIE);


        assertEquals(DessertType.COOKIE, applePie.getType());
        assertEquals(DessertType.APPLE_PIE, taterTots.getType());
        assertEquals(DessertType.FROSTED_TATER_TOTS, cookie.getType());
    }
}
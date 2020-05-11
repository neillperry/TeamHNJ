package com.mcdonalds.food;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EntreeTest extends TestCase {

    @Test
    public void testCalculatePrice() {
        Entree burger = new Entree(EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(EntreeType.MYSTERY, Size.SMALL);

        assertEquals(8.0, burger.getPrice(), 0.01);
        assertEquals(7.5, cheeseBurger.getPrice(), 0.01);
        assertEquals(300.0, mystery.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        Entree burger = new Entree(EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(EntreeType.MYSTERY, Size.SMALL);

        assertEquals(EntreeType.HAMBURGER, burger.getType());
        assertEquals(EntreeType.CHEESEBURGER, cheeseBurger.getType());
        assertEquals(EntreeType.MYSTERY, mystery.getType());
    }

    @Test
    public void testSetType() {
        Entree burger = new Entree(EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(EntreeType.MYSTERY, Size.SMALL);

        mystery.setType(EntreeType.HAMBURGER);
        burger.setType(EntreeType.CHEESEBURGER);
        cheeseBurger.setType(EntreeType.MYSTERY);

        assertEquals(EntreeType.HAMBURGER, mystery.getType());
        assertEquals(EntreeType.CHEESEBURGER, burger.getType());
        assertEquals(EntreeType.MYSTERY, cheeseBurger.getType());
    }
}
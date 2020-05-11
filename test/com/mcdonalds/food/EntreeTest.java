package com.mcdonalds.food;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EntreeTest extends TestCase {

    @Test
    public void testCalculatePrice() {
        Entree burger = new Entree(Entree.EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(Entree.EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(Entree.EntreeType.MYSTERY, Size.SMALL);

        assertEquals(8.0, burger.getPrice(), 0.01);
        assertEquals(7.5, cheeseBurger.getPrice(), 0.01);
        assertEquals(300.0, mystery.getPrice(), 0.01);
    }

    @Test
    public void testGetType() {
        Entree burger = new Entree(Entree.EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(Entree.EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(Entree.EntreeType.MYSTERY, Size.SMALL);

        assertEquals(Entree.EntreeType.HAMBURGER, burger.getType());
        assertEquals(Entree.EntreeType.CHEESEBURGER, cheeseBurger.getType());
        assertEquals(Entree.EntreeType.MYSTERY, mystery.getType());
    }

    @Test
    public void testSetType() {
        Entree burger = new Entree(Entree.EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(Entree.EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(Entree.EntreeType.MYSTERY, Size.SMALL);

        mystery.setType(Entree.EntreeType.HAMBURGER);
        burger.setType(Entree.EntreeType.CHEESEBURGER);
        cheeseBurger.setType(Entree.EntreeType.MYSTERY);

        assertEquals(Entree.EntreeType.HAMBURGER, mystery.getType());
        assertEquals(Entree.EntreeType.CHEESEBURGER, burger.getType());
        assertEquals(Entree.EntreeType.MYSTERY, cheeseBurger.getType());
    }
}
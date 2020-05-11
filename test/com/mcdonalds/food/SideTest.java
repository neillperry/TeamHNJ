package com.mcdonalds.food;

import junit.framework.TestCase;
import org.junit.Test;

public class SideTest extends TestCase {

    @Test
    public void testGetType() {
        Side fries = new Side(SideType.FRIES, Size.LARGE);
        Side apple = new Side(SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(SideType.MOZZARELLA_STICKS, Size.SMALL);

        assertEquals(SideType.FRIES, fries.getType());
        assertEquals(SideType.APPLE, apple.getType());
        assertEquals(SideType.MOZZARELLA_STICKS, mozzarella.getType());
    }

    @Test
    public void testSetType() {
        Side fries = new Side(SideType.FRIES, Size.LARGE);
        Side apple = new Side(SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(SideType.MOZZARELLA_STICKS, Size.SMALL);
        assertEquals(4.0, fries.getPrice(), 0.01);
        assertEquals(12.0, apple.getPrice(), 0.01);
        assertEquals(3.0, mozzarella.getPrice(), 0.01);

    }

    public void testCalculatePrice() {
        Side fries = new Side(SideType.FRIES, Size.LARGE);
        Side apple = new Side(SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(SideType.MOZZARELLA_STICKS, Size.SMALL);

        fries.setType(SideType.MOZZARELLA_STICKS);
        apple.setType(SideType.FRIES);
        mozzarella.setType(SideType.APPLE);

        assertEquals(SideType.FRIES, apple.getType());
        assertEquals(SideType.APPLE, mozzarella.getType());
        assertEquals(SideType.MOZZARELLA_STICKS, fries.getType());
    }
}
package com.mcdonalds.food;

import junit.framework.TestCase;
import org.junit.Test;

public class SideTest extends TestCase {

    @Test
    public void testGetType() {
        Side fries = new Side(Side.SideType.FRIES, Size.LARGE);
        Side apple = new Side(Side.SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(Side.SideType.MOZZARELLA_STICKS, Size.SMALL);

        assertEquals(Side.SideType.FRIES, fries.getType());
        assertEquals(Side.SideType.APPLE, apple.getType());
        assertEquals(Side.SideType.MOZZARELLA_STICKS, mozzarella.getType());
    }

    @Test
    public void testSetType() {
        Side fries = new Side(Side.SideType.FRIES, Size.LARGE);
        Side apple = new Side(Side.SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(Side.SideType.MOZZARELLA_STICKS, Size.SMALL);
        assertEquals(4.0, fries.getPrice(), 0.01);
        assertEquals(12.0, apple.getPrice(), 0.01);
        assertEquals(3.0, mozzarella.getPrice(), 0.01);

    }

    public void testCalculatePrice() {
        Side fries = new Side(Side.SideType.FRIES, Size.LARGE);
        Side apple = new Side(Side.SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(Side.SideType.MOZZARELLA_STICKS, Size.SMALL);

        fries.setType(Side.SideType.MOZZARELLA_STICKS);
        apple.setType(Side.SideType.FRIES);
        mozzarella.setType(Side.SideType.APPLE);

        assertEquals(Side.SideType.FRIES, apple.getType());
        assertEquals(Side.SideType.APPLE, mozzarella.getType());
        assertEquals(Side.SideType.MOZZARELLA_STICKS, fries.getType());
    }
}
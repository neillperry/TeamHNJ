package com.mcdonalds.inventory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAdvanceEnum {

    @Before
    public void testSetUp(){

        /**** Set order ****/
        MenuOrder.HAMBURGER.setSmallSize(1);
        MenuOrder.HAMBURGER.setRegularSize(2);
        MenuOrder.HAMBURGER.setLargeSize(3);
        MenuOrder.CHICKEN_NUGGET.setRegularSize(5);
        MenuOrder.CHICKEN_NUGGET.setLargeSize(2);
        MenuOrder.COKE.setSmallSize(1);
        MenuOrder.COKE.setRegularSize(3);
        /*******************/

    }

    @Test
    public void ShouldBeAbleToReadValueFromAdvEnumMenuOrder(){

        assertEquals(1, MenuOrder.HAMBURGER.getSmallSize());
        assertEquals(2, MenuOrder.HAMBURGER.getRegularSize());
        assertEquals(3, MenuOrder.HAMBURGER.getLargeSize());
        assertEquals(5, MenuOrder.CHICKEN_NUGGET.getRegularSize());
        assertEquals(2, MenuOrder.CHICKEN_NUGGET.getLargeSize());
        assertEquals(1, MenuOrder.COKE.getSmallSize());
        assertEquals(3, MenuOrder.COKE.getRegularSize());

    }

    @Test
    public void ShouldReturn0ForInitialValueCheck(){

        assertEquals(0, MenuOrder.CHICKEN_NUGGET.getSmallSize());
        assertEquals(0, MenuOrder.COKE.getLargeSize());

    }

    @Test
    public void ShouldBeAbleToReadAndModifyValuesOfInstance(){

        MenuOrder.HAMBURGER.setRegularSize(MenuOrder.HAMBURGER.getRegularSize() + 1);
        assertEquals(3, MenuOrder.HAMBURGER.getRegularSize());

    }

    @Test
    public void ShouldBeAbleToGetTheInstanceAsString(){

        String strHamburger = null;

        for(MenuOrder i: MenuOrder.values()){
            if (i.equals(MenuOrder.HAMBURGER)) {
                strHamburger =  i.name();
                break;
            }
        }

        assertEquals("HAMBURGER", strHamburger);
    }
    @Test
    public void ShouldReturn21ForTheMatchingInstances_BetweenMenuOrderAndMenuInventory(){

        int count = 0;

        for(MenuOrder i: MenuOrder.values()){
            for(MenuInventory j: MenuInventory.values()){
                if (i.name().equals(j.name())){
                    count = count + 1;
                }
            }
        }

        assertEquals(21, count);
    }
    @Test
    public void ShouldReturn21ForTheMatchingInstances_BetweenMenuOrderAndMenuTempStorage(){

        int count = 0;

        for(MenuOrder i: MenuOrder.values()){
            for(MenuTempStorage j: MenuTempStorage.values()){
                if (i.name().equals(j.name())){
                    count = count + 1;
                }
            }
        }

        assertEquals(21, count);

    }
    @Test
    public void ShouldReturn21ForTheSizeOfMenuOrderMenuInventoryMenuTempStorage(){

        // By testing "ShouldReturn21ForTheMatchingInstances_BetweenMenuOrderAndMenuInventory()",
        // "ShouldReturn21ForTheMatchingInstances_BetweenMenuOrderAndMenuTempStorage()"
        // ans this, we know that 3 enums have same instances

        int countSizeMenuInventory = MenuInventory.values().length;
        int countSizeMenuOrder = MenuOrder.values().length;
        int countSizeMenuTempStorage = MenuTempStorage.values().length;

        assertEquals(21, countSizeMenuInventory);
        assertEquals(21, countSizeMenuOrder);
        assertEquals(21, countSizeMenuTempStorage);
    }
}

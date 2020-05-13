package com.mcdonalds.inventory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TestInventoryManager {

    InventoryManager inventMng = new InventoryManager();

    @Before
    public void testSetUp(){

        inventMng.setInventoryData(10);
    }
    @Test
    public void shouldReturnAllItems10_originalCond_MenuInventory(){

        inventMng.processOrderData(0);

        boolean[] flag = {false, false, false};

        for(MenuInventory i: MenuInventory.values()){
            if (i.getSmallSize() != 10){
                flag[0] = true;
                break;
            }
            if (i.getRegularSize() != 10){
                flag[1] = true;
                break;
            }
            if (i.getLargeSize() != 10){
                flag[2] = true;
                break;
            }

        }
        assertFalse(flag[0]);
        assertFalse(flag[1]);
        assertFalse(flag[2]);
    }
    @Test
    public void shouldReturnAllItems0_originalCond_MenuOrder(){

        inventMng.processOrderData(0);

        boolean[] flag = {false, false, false};

        for(MenuOrder i: MenuOrder.values()){
            if (i.getSmallSize() != 0){
                flag[0] = true;
                break;
            }
            if (i.getRegularSize() != 0){
                flag[1] = true;
                break;
            }
            if (i.getLargeSize() != 0){
                flag[2] = true;
                break;
            }
        }
        assertFalse(flag[0]);
        assertFalse(flag[1]);
        assertFalse(flag[2]);
    }

    @Test
    public void shouldReturnAllItems10_origianlCond_MenuTempStorage(){

        inventMng.processOrderData(0);


        boolean[] flag = {false, false, false};

        for(MenuTempStorage i: MenuTempStorage.values()){
            if (i.getSmallSize() != 10){
                flag[0] = true;
                break;
            }
            if (i.getRegularSize() != 10){
                flag[1] = true;
                break;
            }
            if (i.getLargeSize() != 10){
                flag[2] = true;
                break;
            }
        }

        assertFalse(flag[0]);
        assertFalse(flag[1]);
        assertFalse(flag[2]);

    }


    @Test
    public void shouldReturnCount2_testGetNumCountOrderRequested(){
        inventMng.processOrderData(1);
        inventMng.processOrderData(1);

        assertEquals(2,inventMng.getNumCountOrderRequested());
    }
    @Test
    public void shouldReturnEmptyTrue_testGetItemsProcessable(){
        Map<String, Integer> mapTest = new HashMap<>();
        mapTest = inventMng.getItemsProcessable();
        assertTrue(mapTest.isEmpty());
    }

    @Test
    public void shouldReturnSize2_testGetItemsProcessableSize(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(1);
        MenuOrder.FRIES.setRegularSize(12); // Out of stock
        MenuOrder.COKE.setRegularSize(2);

        // request to process data
        inventMng.processOrderData(0);

        Map<String, Integer> mapTest = new HashMap<>();
        mapTest = inventMng.getItemsProcessable();

        assertEquals(2, mapTest.size());
    }
    @Test
    public void shouldReturn1SmallHamburger2SmallCoke_testGetItemsProcessable1(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        // get data
        Map<String, Integer> mapTest = new HashMap<>();
        mapTest = inventMng.getItemsProcessable();

        // declare local variables
        int[] count = {0, 0, 0};
        int[] quantity = {0, 0};

        for(String i: mapTest.keySet()){
            if (i.equals("HAMBURGER SMALL")) {
                count[0] = count[0] + 1;
                quantity[0] = mapTest.get(i);
            }
            else if (i.equals("COKE REGULAR")) {
                count[1] = count[1] + 1;
                quantity[1] = mapTest.get(i);
            }
            else{
                count[2] = count[2] + 1;
            }
        }

        assertEquals(1, count[0]); // HAMBURGER SMALL
        assertEquals(1, count[1]); // COKE REGULAR
        assertEquals(0, count[2]); // If there are something else in the map
        assertEquals(4, quantity[0]); // quantity of HAMBURGER SMALL
        assertEquals(5, quantity[1]); // quantity of COKE REGULAR
    }

    @Test
    public void shouldReturn1SmallHamburger2SmallCoke_testGetItemsProcessable2(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(12); // Out of inventory
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        // get data
        Map<String, Integer> mapTest = new HashMap<>();
        mapTest = inventMng.getItemsProcessable();

        // declare local variables
        int[] count = {0, 0, 0};
        int[] quantity = {0, 0};

        for(String i: mapTest.keySet()){
            if (i.equals("HAMBURGER SMALL")) {
                count[0] = count[0] + 1;
                quantity[0] = mapTest.get(i);
            }
            else if (i.equals("COKE REGULAR")) {
                count[1] = count[1] + 1;
                quantity[1] = mapTest.get(i);
            }
            else{
                count[2] = count[2] + 1;
            }
        }

        assertEquals(1, count[0]); // HAMBURGER SMALL
        assertEquals(1, count[1]); // COKE REGULAR
        assertEquals(0, count[2]); // If there is something else in the map
        assertEquals(4, quantity[0]); // quantity of HAMBURGER SMALL
        assertEquals(5, quantity[1]); // quantity of COKE REGULAR
    }
    @Test
    public void shouldReturnSize2_testGetOutOfInventory(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(14); // Out of inventory
        MenuOrder.FRIES.setRegularSize(12); // Out of inventory
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        // get data
        Map<String, Integer> mapTest = new HashMap<>();
        mapTest = inventMng.getOutOfInventory();

        assertEquals(2, mapTest.size());
    }
    @Test
    public void shouldReturnHamburgerSmallNeg4FriesRegularNeg2_testGetOutOfInventory2(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(14); // Out of inventory
        MenuOrder.FRIES.setRegularSize(12); // Out of inventory
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        // get data
        Map<String, Integer> mapTest = new HashMap<>();
        mapTest = inventMng.getOutOfInventory();

        // declare local variables
        int[] count = {0, 0, 0};
        int[] quantity = {0, 0};

        for(String i: mapTest.keySet()){
            if (i.equals("HAMBURGER SMALL")) {
                count[0] = count[0] + 1;
                quantity[0] = mapTest.get(i);
            }
            else if (i.equals("FRIES REGULAR")) {
                count[1] = count[1] + 1;
                quantity[1] = mapTest.get(i);
            }
            else{
                count[2] = count[2] + 1;
            }
        }

        assertEquals(1, count[0]); // HAMBURGER SMALL
        assertEquals(1, count[1]); // FRIES REGULAR
        assertEquals(0, count[2]); // If there is something else in the map
        assertEquals(-4, quantity[0]); // quantity out of inventory for HAMBURGER SMALL
        assertEquals(-2, quantity[1]); // quantity out of inventory for FRIES REGULAR
    }
    @Test
    public void shouldReturnSmallHamburger14RegularFries12RegularCoke5Rest0_MenuOrder(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(14); // Out of inventory
        MenuOrder.FRIES.setRegularSize(12); // Out of inventory
        MenuOrder.COKE.setRegularSize(5);

        int[] quantity = new int[6];

        for (MenuOrder i: MenuOrder.values()){
            switch(i){
                case HAMBURGER:
                    quantity[0] =  MenuOrder.HAMBURGER.getSmallSize();
                    break;
                case FRIES:
                    quantity[1] =  MenuOrder.FRIES.getRegularSize();
                    break;
                case COKE:
                    quantity[2] =  MenuOrder.COKE.getRegularSize();
                    break;
                default:
                    quantity[3] =(i.getSmallSize() > 0) ? i.getSmallSize(): 0;
                    quantity[4] =(i.getRegularSize() > 0) ? i.getRegularSize(): 0;
                    quantity[5] =(i.getLargeSize() > 0) ? i.getLargeSize(): 0;

            }
        }

        assertEquals(14, quantity[0]);
        assertEquals(12, quantity[1]);
        assertEquals(5, quantity[2]);
        assertEquals(0, quantity[3]);
        assertEquals(0, quantity[4]);
        assertEquals(0, quantity[5]);

    }
    @Test
    public void shouldReturnSmallHamburger14RegularFries12RegularCoke5Rest0_MenuTempStorage(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(14); // Out of inventory
        MenuOrder.FRIES.setRegularSize(12); // Out of inventory
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        int[] quantity = new int[6];

        for (MenuTempStorage i: MenuTempStorage.values()){

            switch(i){
                case HAMBURGER:
                    quantity[0] =  MenuTempStorage.HAMBURGER.getSmallSize();
                    break;
                case FRIES:
                    quantity[1] =  MenuTempStorage.FRIES.getRegularSize();
                    break;
                case COKE:
                    quantity[2] =  MenuTempStorage.COKE.getRegularSize();
                    break;
                default:
                    quantity[3] =(i.getSmallSize() != 10) ? i.getSmallSize(): 0;
                    quantity[4] =(i.getRegularSize() != 10) ? i.getRegularSize(): 0;
                    quantity[5] =(i.getLargeSize() != 10) ? i.getLargeSize(): 0;

            }
        }

        assertEquals(-4, quantity[0]);
        assertEquals(-2, quantity[1]);
        assertEquals(5, quantity[2]);
        assertEquals(0, quantity[3]);
        assertEquals(0, quantity[4]);
        assertEquals(0, quantity[5]);


    }
    @Test
    public void shouldReturn0_notYetChecked_testGetStatusOrderProcessable(){

        assertEquals(0, inventMng.getStatusOrderProcessable());

    }
    @Test
    public void shouldReturn1_partiallyProcessable_testGetStatusOrderProcessable(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(14); // out of inventory
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        assertEquals(1, inventMng.getStatusOrderProcessable());

    }
    @Test
    public void shouldReturn2_fullyProcessable_testGetStatusOrderProcessable(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        assertEquals(2, inventMng.getStatusOrderProcessable());
    }
    @Test
    public void shouldClearDataMenuOrder_testClearData(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        // request to clear data
        inventMng.clearData();

        boolean[] flag = {false, false, false};

        for (MenuOrder i: MenuOrder.values()){
            if (i.getSmallSize() != 0){
                flag[0] = true;
                break;
            }
            if (i.getRegularSize() != 0){
                flag[1] = true;
                break;
            }
            if (i.getLargeSize() != 0){
                flag[2] = true;
                break;
            }
        }
        assertFalse(flag[0]);
        assertFalse(flag[1]);
        assertFalse(flag[2]);
    }

    @Test
    public void shouldClearDataMenuTempStorage_testClearData(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);

        // request to clear data
        inventMng.clearData();

        boolean[] flag = {false, false, false};

        for (MenuTempStorage i: MenuTempStorage.values()){
            if (i.getSmallSize() != 0){
                flag[0] = true;
                break;
            }
            if (i.getRegularSize() != 0){
                flag[1] = true;
                break;
            }
            if (i.getLargeSize() != 0){
                flag[2] = true;
                break;
            }
        }
        assertFalse(flag[0]);
        assertFalse(flag[1]);
        assertFalse(flag[2]);
    }

    @Test
    public void shouldKeepSubtractDataFromInventory(){

        /****** First order ******/
        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(0);

        int[] quantity = {0, 0, 0};
        extractDataFromMenuInventory(quantity);

        assertEquals(6, quantity[0]);
        assertEquals(8, quantity[1]);
        assertEquals(7, quantity[2]);


        /****** Second order ******/
        Arrays.fill(quantity, 0);

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(5);

        // request to process data
        inventMng.processOrderData(0);
        extractDataFromMenuInventory(quantity);

        assertEquals(2, quantity[0]);
        assertEquals(6, quantity[1]);
        assertEquals(2, quantity[2]);

    }
    private int[] extractDataFromMenuInventory(int[] quantity){

        for (MenuInventory i: MenuInventory.values()){
            if (i.name().equals("HAMBURGER")){
                quantity[0] = i.getSmallSize();
            }
            if(i.name().equals("FRIES")){
                quantity[1] = i.getRegularSize();
            }
            if(i.name().equals("COKE")){
                quantity[2] = i.getRegularSize();
            }
        }
        return quantity;
    }

    @Test
    public void shouldNotSubtractAnyDataFromInventory_testProcessOrderMode0(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(12); // out of inventory
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(0);

        assertEquals(1, inventMng.getOutOfInventory().size());
        assertEquals(2, inventMng.getItemsProcessable().size());

        int[] quantity = {0, 0, 0};

        for (MenuInventory i: MenuInventory.values()){

            if (i.name().equals("HAMBURGER")){
                quantity[0] = i.getSmallSize();
            }
            if (i.name().equals("FRIES")){
                quantity[1] = i.getRegularSize();
            }
            if(i.name().equals("COKE")){
                quantity[2] = i.getRegularSize();
            }
        }

        assertEquals(10, quantity[0]);
        assertEquals(10, quantity[1]);
        assertEquals(10, quantity[2]);
    }

    @Test
    public void shouldSubtractSmallHamburgerRegularCokeFromInventory_testProcessOrderMode1(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(12); // out of inventory
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(1);

        assertEquals(1, inventMng.getOutOfInventory().size());
        assertEquals(2, inventMng.getItemsProcessable().size());

        int[] quantity = {0, 0, 0};

        for (MenuInventory i: MenuInventory.values()){

            if (i.name().equals("HAMBURGER")){
                quantity[0] = i.getSmallSize();
            }
            if (i.name().equals("FRIES")){
                quantity[1] = i.getRegularSize();
            }
            if(i.name().equals("COKE")){
                quantity[2] = i.getRegularSize();
            }
        }

        assertEquals(6, quantity[0]);
        assertEquals(10, quantity[1]);
        assertEquals(7, quantity[2]);
    }

    @Test
    public void shouldSubtractSmallHamburgerRegularCokeFromInventory_testProcessOrderMode1_2(){

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(12); // out of inventory
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(1);

        assertEquals(1, inventMng.getOutOfInventory().size());
        assertEquals(2, inventMng.getItemsProcessable().size());

        int[] quantity = {0, 0, 0};

        for (MenuInventory i: MenuInventory.values()){

            if (i.name().equals("HAMBURGER")){
                quantity[0] = i.getSmallSize();
            }
            if (i.name().equals("FRIES")){
                quantity[1] = i.getRegularSize();
            }
            if(i.name().equals("COKE")){
                quantity[2] = i.getRegularSize();
            }
        }

        assertEquals(6, quantity[0]);
        assertEquals(10, quantity[1]);
        assertEquals(7, quantity[2]);
    }

    @Test
    public void testDisplayCurrentInventoryData(){

        /*Test by displaying in the terminal
        * - Should "HAMBURGER" SMALL -> 6
        * - Should "FRIES" REGULAR -> 8
        * - Should "COKE" REGULAR -> 7
        * */

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(2);
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(1);
        inventMng.displayCurrentInventoryData();
    }

    @Test
    public void testDisplayOutOfInventory(){

        /*Test by displaying in the terminal
         * - Should "FRIES" REGULAR -> -2
         * */

        // set order
        MenuOrder.HAMBURGER.setSmallSize(4);
        MenuOrder.FRIES.setRegularSize(12);
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(1);
        inventMng.displayOutOfInventory();
    }
    @Test
    public void testDisplayPotentialInventory(){

        /*Test by displaying in the terminal
         * - Should look like below
         *
         * HAMBURGER
         * Small size : -4
         *
         * FRIES
         * Regular size : -2
         *
         * */

        // set order
        MenuOrder.HAMBURGER.setSmallSize(14);
        MenuOrder.FRIES.setRegularSize(12);
        MenuOrder.COKE.setRegularSize(3);

        // request to process data
        inventMng.processOrderData(1);
        inventMng.displayPotentialInventory();
    }


    @After
    public void cleanUpTest(){

        for (MenuOrder i: MenuOrder.values()){
            i.setSmallSize(0);
            i.setRegularSize(0);
            i.setLargeSize(0);
        }
        for (MenuTempStorage i: MenuTempStorage.values()){
            i.setSmallSize(0);
            i.setRegularSize(0);
            i.setLargeSize(0);
        }
    }

}

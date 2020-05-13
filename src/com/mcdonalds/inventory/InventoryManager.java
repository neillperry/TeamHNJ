package com.mcdonalds.inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * The main purpose of this program is to process inventory.
 * This program takes and stores inventory information in "MenuInventory" enum.
 * This program takes order data from "MenuOrder" and check with inventory information in "MenuInventory" and
 * see if we have enough inventory to process the order.
 * If there is not enough inventory to process order, you have 2 options.
 *  +Option 1 : not process order at all (mode = 0)
 *  +Option 2 : only process items which are possible to process (mode = 1)
 * These options can be chosen when you run "processOrderData()"
 *
 *
 * Basic steps for executing this program
 * 0. Clear data by executing "clearData()"
 * 1. Set initial inventory data by executing "setInventoryData(%)" (%: number of items)
 * 2. Store order data in "MenuOrder" enum use (MenuOrder.*.setSmallSize(%), MenuOrder.*.setSmallSize(%), MenuOrder.*.setSmallSize(%))
 *      -> *: food item name, %: number of items
 * 3. Execute "processOrderData(&)" (& : mode number -> explained above)
 *
 *
 * The below is the options for how to access data
 * "displayCurrentInventoryData()" : Display current inventory
 * "displayOutOfInventory()" : Display item which is out of inventory if order is processed
 * "getStatusOrderProcessable()" : int :Check if the system can process the data -> check the constants
 * "getItemsProcessable()" : Map<String, Integer> : ordered items which are processable
 * "getOutOfInventory()" : Map<String, Integer> : ordered items which are out of stock
 *
 *
 *
 * ////////// Caution! //////////
 * "MenuInventory" enum, "MenuOrder" enum, "MenuTempStorage" need to have same instance name!
 * If you need to add an instance, add to all 3 enums
 *
 *
 *
 *
 * /-------- Sample program --------/
 * InventoryManager inventMng = new InventoryManager();
 *
 * // Set initial inventory
 *          inventMng.setInventoryData(10);
 *
 * // Set order data
 *         MenuOrder.HAMBURGER.setSmallSize(1);
 *         MenuOrder.HAMBURGER.setRegularSize(2);
 *         MenuOrder.HAMBURGER.setLargeSize(3);
 *         MenuOrder.CHICKEN_NUGGET.setRegularSize(5);
 *         MenuOrder.CHICKEN_NUGGET.setLargeSize(2);
 *         MenuOrder.COKE.setSmallSize(1);
 *         MenuOrder.COKE.setRegularSize(3);
 *
 * // Get counter order requested
 *         System.out.print("numCountOrderRequested:");
 *         System.out.println(inventMng.getNumCountOrderRequested());
 *
 * // Process order data
 *         inventMng.processOrderData(1);
 *
 * // Display current inventory
 *         inventMng.displayCurrentInventoryData();
 *
 * // Status if order is processable
 *         int status = inventMng.getStatusOrderProcessable();
 *         System.out.println(status);
 *
 * // Display items which are out of inventory
 *         inventMng.displayOutOfInventory();
 *         System.out.println();
 *
 * // Ordered items processable
 *         System.out.println("itemProcessable:");
 *         displayProcessable(inventMng.getItemsProcessable());
 *
 * // Ordered items not processable
 *         System.out.println("getOutOfInventory:");
 *         displayOutOfInventoryDetails(inventMng.getOutOfInventory());
 *
 * // Command for clearing data
 *         System.out.println("Data is cleared");
 *         inventMng.clearData();
 *
 *
 * // Methods
 *     private static void displayProcessable(Map<String, Integer> itemsProcessable){
 *
 *         for(String i: itemsProcessable.keySet()){
 *             System.out.print(i + " : ");
 *             System.out.println(itemsProcessable.get(i));
 *         }
 *         System.out.println();
 *     }
 *
 *
 *     private static void displayOutOfInventoryDetails(Map<String, Integer> outOfInventory){
 *
 *         String[] outOfInventoryDetails= new String[2];
 *
 *         if (!outOfInventory.isEmpty()){ // Check if it's empty
 *             int numLackItem;
 *             for(String i: outOfInventory.keySet()){
 *                 numLackItem = outOfInventory.get(i);
 *                 outOfInventoryDetails = i.split(" ");
 *                 System.out.print("Food:" + outOfInventoryDetails[0] + ", ");
 *                 System.out.print("Size:" + outOfInventoryDetails[1] + ", ");
 *                 System.out.println("Amount:" + Math.abs(numLackItem));
 *             }
 *         }
 *         else{
 *             System.out.println("No data stored");
 *         }
 *         System.out.println();
 *     }
 *
 *
 * */

public class InventoryManager {

    // Constants
    private static int STATUS_ORDER_PROC_NOT_YET_CHECKED = 0; // Order has not checked yet
    private static int STATUS_ORDER_PROC_NOT_FULLY_PROCESSABLE = 1; // Order cannot be fully processable
    private static int STATUS_ORDER_PROC_FULLY_PROCESSABLE = 2; // Order can be fully processable

    // Fields
    private Map<String, Integer> outOfInventory = new HashMap<>();
    private Map<String, Integer> itemsProcessable = new HashMap<>();
    private int statusOrderProcessable = STATUS_ORDER_PROC_NOT_YET_CHECKED; // this is coming from "checkIfOrderProcessable()"
    private int numCountOrderRequested = 0;

    // Set inventory data :: It will overwrite date stored
    public void setInventoryData(int itemStore){

        //EnumMap<Menu, Integer> inventoryData = new EnumMap<>(Menu.class);
        for(MenuInventory i: MenuInventory.values()){
            i.setSmallSize(itemStore);
            i.setRegularSize(itemStore);
            i.setLargeSize(itemStore);
        }
    }

    // Display CurrentInventory
    public void displayCurrentInventoryData(){
        for(MenuInventory i: MenuInventory.values()){
            System.out.println(i + ":");
            System.out.println("+Small : "+ i.getSmallSize());
            System.out.println("+Regular : "+ i.getRegularSize());
            System.out.println("+Large : " + i.getLargeSize());
        }
    }

    // ProcessingOrderData
    // -> This will reflect order data to "MenuInventory" if processable
    public void processOrderData(int mode){

        checkOrderProcessable();

     switch(mode) {

         // This option only works if all order data is processable
         // If there is even 1 item which is not processable, it will not do anything
         case 0:
             if (statusOrderProcessable == STATUS_ORDER_PROC_FULLY_PROCESSABLE){
                 for(MenuInventory i: MenuInventory.values()){
                     for (MenuTempStorage j: MenuTempStorage.values()){
                         if (i.name().equals(j.name())){
                             i.setSmallSize(j.getSmallSize());
                             i.setRegularSize(j.getRegularSize());
                             i.setLargeSize(j.getLargeSize());
                         }
                     }
                 }
             }
             break;

             // This is the option for processing order even if not fully processable
         case 1:
             if (statusOrderProcessable == STATUS_ORDER_PROC_NOT_FULLY_PROCESSABLE){
                 for(MenuInventory i: MenuInventory.values()){
                     for (MenuTempStorage j: MenuTempStorage.values()){
                         if (i.name().equals(j.name())){
                             if (j.getSmallSize() >= 0) {
                                 i.setSmallSize(j.getSmallSize());
                             }
                             if (j.getRegularSize() >= 0){
                                i.setRegularSize(j.getRegularSize());
                             }
                             if (j.getLargeSize() >= 0) {
                                 i.setLargeSize(j.getLargeSize());
                             }
                         }
                     }
                 }
             }
        }
    }
    public void clearData(){
        // Clear order information
        for(MenuOrder i: MenuOrder.values()){
            i.setSmallSize(0);
            i.setRegularSize(0);
            i.setLargeSize(0);
        }
        // Clear temporary storage
        for(MenuTempStorage i: MenuTempStorage.values()){
            i.setSmallSize(0);
            i.setRegularSize(0);
            i.setLargeSize(0);
        }
    }

    private void checkOrderProcessable(){

        // Initialize variable and data
        statusOrderProcessable = STATUS_ORDER_PROC_NOT_YET_CHECKED;
        outOfInventory.clear();
        itemsProcessable.clear();

        // Count up number of order requested
        numCountOrderRequested = numCountOrderRequested + 1;

        // Execute methods
        calcInventoryRemain();
        checkIfOrderProcessable();
    }

    /*********** Internal : access from "checkOrderProcessable()" ***********/
    // Calculation remaining of inventory
    private void calcInventoryRemain(){

        int[] result = new int[3];
        //itemsProcessable = new HashMap<>();
        String size = null;

        for(MenuInventory i : MenuInventory.values()){
            for (MenuOrder j : MenuOrder.values()) {
                if (i.name().equals(j.name())) {
                    result[0] = i.getSmallSize() - j.getSmallSize();
                    result[1] = i.getRegularSize() - j.getRegularSize();
                    result[2] = i.getLargeSize() - j.getLargeSize();
                    calcInventoryStoreResult(i, result);

                    // Create a table for order item processable
                    if ((j.getSmallSize() != 0)&&(result[0] >= 0)){
                        size = "SMALL";
                        itemsProcessable.put(j.name()+" "+size, j.getSmallSize());
                    }
                    if ((j.getRegularSize() != 0)&&(result[1] >= 0)){
                        size = "REGULAR";
                        itemsProcessable.put(j.name()+" "+size, j.getRegularSize());
                    }
                    if ((j.getLargeSize() != 0)&&(result[2] >= 0)){
                        size = "LARGE";
                        itemsProcessable.put(j.name()+" "+size, j.getLargeSize());
                    }
                }
            }
        }
    }
    // Used with "calcInventoryRemain()"
    private void calcInventoryStoreResult(MenuInventory foodItem, int... result){
        for (MenuTempStorage i : MenuTempStorage.values()){
         if (i.name().equals(foodItem.name())){
             i.setSmallSize(result[0]);
             i.setRegularSize(result[1]);
             i.setLargeSize(result[2]);
         }
        }
    }

    // Check if order is processable : use the data calculated in calcInventoryRemain()
    private void checkIfOrderProcessable(){

        //outOfInventory = new HashMap<>();
        int[] quantityAfterOrderProcessed = new int[3];
        boolean result = true;
        String strNotEnoughItem = null;
        String strSize = null;

        for (MenuTempStorage i: MenuTempStorage.values()){
            quantityAfterOrderProcessed[0] = i.getSmallSize();
            quantityAfterOrderProcessed[1] = i.getRegularSize();
            quantityAfterOrderProcessed[2] = i.getLargeSize();

            for(int j = 0; j< quantityAfterOrderProcessed.length; j++){
                if (quantityAfterOrderProcessed[j] < 0){
                    switch(j){
                        case 0: strSize = "SMALL"; break;
                        case 1: strSize = "REGULAR"; break;
                        case 2: strSize = "LARGE"; break;
                    }

                    strNotEnoughItem = i.name() + " "+strSize;
                    outOfInventory.put(strNotEnoughItem, quantityAfterOrderProcessed[j]);
                }
            }
        }
        if (outOfInventory.size() > 0){
            result = false;
        }
        // set to the field
        if (result == false) {
            statusOrderProcessable = STATUS_ORDER_PROC_NOT_FULLY_PROCESSABLE;
        }
        else if(result == true){
            statusOrderProcessable = STATUS_ORDER_PROC_FULLY_PROCESSABLE;
        }
    }

    /*************************************************************************/

    // if Order cannot be processed, show which item is out of stock
    public void displayOutOfInventory(){
        if (statusOrderProcessable == STATUS_ORDER_PROC_NOT_FULLY_PROCESSABLE) {
            int quantityNeeds;
            for (String i : outOfInventory.keySet()) {
                quantityNeeds = outOfInventory.get(i);
                System.out.println(i + ":" + quantityNeeds);
            }
        }
        else if(statusOrderProcessable == STATUS_ORDER_PROC_FULLY_PROCESSABLE){
            System.out.println("Order is processable. No item will be shown.");
        }
        else if(statusOrderProcessable == STATUS_ORDER_PROC_NOT_YET_CHECKED){
            System.out.println("Order is not checked yet. Please execute \"checkOrderProcessable()\" before executing \"displayOutOfInventory()\".");
        }
        else{
            System.out.println("We could not find the status.");
        }
    }

    // return "outOfInventory" information
    public Map<String, Integer> getOutOfInventory(){
        return outOfInventory;
    }
    // return "itemProcessable" information
    public Map<String, Integer> getItemsProcessable(){
        return itemsProcessable;
    }

    // Display potential inventory information
    // -> If order is processed as requested, what would happen to inventory
    public void displayPotentialInventory(){

        for(MenuTempStorage i: MenuTempStorage.values()){
            for (MenuInventory j: MenuInventory.values()) {

                if (i.name().equals(j.name())) {
                    System.out.println(i.name());
                    if (i.getSmallSize() != j.getSmallSize()) {
                        System.out.println("Small size:" + i.getSmallSize());
                    }
                    if (i.getRegularSize() != j.getRegularSize()) {
                        System.out.println("Regular size:" + i.getRegularSize());
                    }
                    if (i.getLargeSize() != j.getLargeSize()) {
                        System.out.println("Large size:" + i.getLargeSize());
                    }

                }
            }
        }
    }

    // Accessor for the field "statusOrderProcessable"
    public int getStatusOrderProcessable() {
        return statusOrderProcessable;
    }

    // Accessor for the field "numCountOrderRequested"
    public int getNumCountOrderRequested(){
        return numCountOrderRequested;
    }
}

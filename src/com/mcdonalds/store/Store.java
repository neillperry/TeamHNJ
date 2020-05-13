package com.mcdonalds.store;

import com.mcdonalds.user.User;
import com.mcdonalds.order.Order;
import com.mcdonalds.inventory.InventoryManager;
import com.mcdonalds.inventory.MenuOrder;
import com.mcdonalds.food.Size;
import com.mcdonalds.food.FoodItem;
import com.mcdonalds.food.FoodType;

import com.mcdonalds.food.DessertType;
import com.mcdonalds.food.Dessert;
import com.mcdonalds.food.Entree;
import com.mcdonalds.food.EntreeType;
import com.mcdonalds.food.Side;
import com.mcdonalds.food.SideType;
import com.mcdonalds.food.Drink;
import com.mcdonalds.food.DrinkType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

public class Store {
    // STATIC VARIABLES
    public static final double TAXRATE = 0.2;

    // FIELDS
    private Collection<Order> placedOrders;
    private Collection<Order> completedOrders;
    private Collection<User> users;
    private Double collectedSalesTaxes = 0.0;
    private Double storeRevenue = 0.0;
    private InventoryManager inventMng = new InventoryManager();
    private int statusOrderProcessable = 0; // 0:Not yet checked, 1: partially processable, 2: fully processable
    private int processOrderDataMode = 0; // 0: process only fully processable, 1: process only processable items
    private int initialInventory = 10; // quantity of initial inventory : apply to all items

    // CONSTRUCTOR
    public Store() {
        users = new ArrayList<>() {};
        placedOrders = new ArrayList<>() {};
        completedOrders = new ArrayList<>() {};
        initializeInventory(initialInventory);
    }

    // ACCESSOR / SETTOR METHODS
    public Collection<Order> getCompletedOrders() {
        return completedOrders;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Order> getPlacedOrders() {
        return placedOrders;
    }

    public double getCollectedSalesTax() {
        return collectedSalesTaxes;
    }

    public double getCollectedRevenue() {
        return storeRevenue;
    }

    public int getInitialInventory() {
        return initialInventory;
    }

    // BUSINESS METHODS
    public void processOrder(Order order) {
        order.setOrderNumber(createOrderNumber());
        collectMoney(order);
        placedOrders.add(order);
    }

    public void completeOrder(Order newOrder) {
        completedOrders.add(newOrder);
        newOrder.setIsComplete(true);
    }

    public void collectMoney(Order order) {
        order.calculateSubTotalPrice();
        calculateTaxesOwed(order);
        storeRevenue += order.getFinalPrice();
    }

    public void calculateTaxesOwed(Order order) {
        double taxes = order.getSubTotalPrice() * TAXRATE;
        collectedSalesTaxes += taxes;
        order.setTax(taxes);
    }

    public int createOrderNumber() {
        Random r = new Random();
        return r.nextInt((999999999 - 1) + 1) + 0;
    }

    // BUSINESS METHODS
    // This is for the inventory system
    public void initializeInventory(int initialInventory) {
        this.initialInventory = initialInventory;
        inventMng.setInventoryData(initialInventory);
    }

    public boolean checkIfOrderProcessable(Order order) {
        boolean returnValue = false;
        inventMng.clearData(); // Clear ordered item data and temporary storage for the inventory system

        //---------- Integration of Inventory system ----------
        // Overview
        // 1. Extract ordered item data from "order.getFoodItems()"
        // 2. Count how many of each items are ordered
        // 3. Store the counts into inventory system
        // 4. Call methods to process the data
        // 5. Store fields or display the results

        // initialize variables
        int applePieSmall = 0, applePieRegular = 0, applePieLarge = 0;
        int iceCreamSmall = 0, iceCreamRegular = 0, iceCreamLarge = 0;
        int bCakeSmall = 0, bCakeRegular = 0, bCakeLarge = 0;
        int cookieSmall = 0, cookieRegular = 0, cookieLarge = 0;
        int totsSmall = 0, totsRegular = 0, totsLarge = 0;
        int cokeSmall = 0, cokeRegular = 0, cokeLarge = 0;
        int spriteSmall = 0, spriteRegular = 0, spriteLarge = 0;
        int dietCokeSmall = 0, dietCokeRegular = 0, dietCokeLarge = 0;
        int waterSmall = 0, waterRegular = 0, waterLarge = 0;
        int adultSmall = 0, adultRegular = 0, adultLarge = 0;
        int hamburgerSmall = 0, hamburgerRegular = 0, hamburgerLarge = 0;
        int cheeseBSmall = 0, cheeseBRegular = 0, cheeseBLarge = 0;
        int chickenSandSmall = 0, chickenSandRegular = 0, chickenSandLarge = 0;
        int chickenNugSmall = 0, chickenNugRegular = 0, chickenNugLarge = 0;
        int entreeMystSmall = 0, entreeMystRegular = 0, entreeMystLarge = 0;
        int friesSmall = 0, friesRegular = 0, friesLarge = 0;
        int appleSmall = 0, appleRegular = 0, appleLarge = 0;
        int mozzarellaSmall = 0, mozzarellaRegular = 0, mozzarellaLarge = 0;
        int saladSmall = 0, saladRegular = 0, saladLarge = 0;
        int onionRingSmall = 0, onionRingRegular = 0, onionRingLarge = 0;
        int sideMysterySmall = 0, sideMysteryRegular = 0, sideMysteryLarge = 0;

        // Extract information of ordered items
        // Count how many of each item was ordered
        Collection<FoodItem> itemOrdered = order.getFoodItems();
        for (FoodItem i : itemOrdered) {
            FoodType category = i.getFoodType();
            if (category.equals(FoodType.DESSERT)) {
                //System.out.println("-- Dessert-- ");
                Dessert j = (Dessert) i;

                switch (j.getType().name()) {
                    case "APPLE_PIE":
                        if (j.getSize().name().equals("SMALL")) {
                            applePieSmall = applePieSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            applePieRegular = applePieRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            applePieLarge = applePieLarge + 1;
                        }
                        break;
                    case "ICE_CREAM":
                        if (j.getSize().name().equals("SMALL")) {
                            iceCreamSmall = iceCreamSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            iceCreamRegular = iceCreamRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            iceCreamLarge = iceCreamLarge + 1;
                        }
                        break;
                    case "BIRTHDAY_CAKE":
                        if (j.getSize().name().equals("SMALL")) {
                            bCakeSmall = bCakeSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            bCakeRegular = bCakeRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            bCakeLarge = bCakeLarge + 1;
                        }
                        break;
                    case "COOKIE":
                        if (j.getSize().name().equals("SMALL")) {
                            cookieSmall = cookieSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            cookieRegular = cookieRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            cookieLarge = cookieLarge + 1;
                        }
                        break;
                    case "FROSTED_TATER_TOTS":
                        if (j.getSize().name().equals("SMALL")) {
                            totsSmall = totsSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            totsRegular = totsRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            totsLarge = totsLarge + 1;
                        }
                        break;
                }
            } else if (category.equals(FoodType.DRINK)) {
                //System.out.println("-- Drink -- ");
                Drink j = (Drink) i;
                switch (j.getType().name()) {
                    case "COKE":
                        if (j.getSize().name().equals("SMALL")) {
                            cokeSmall = cokeSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            cokeRegular = cokeRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            cokeLarge = cokeLarge + 1;
                        }
                        break;

                    case "SPRITE":
                        if (j.getSize().name().equals("SMALL")) {
                            spriteSmall = spriteSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            spriteRegular = spriteRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            spriteLarge = spriteLarge + 1;
                        }
                        break;
                    case "DIET_COKE":
                        if (j.getSize().name().equals("SMALL")) {
                            dietCokeSmall = dietCokeSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            dietCokeRegular = dietCokeRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            dietCokeLarge = dietCokeLarge + 1;
                        }
                        break;
                    case "WATER":
                        if (j.getSize().name().equals("SMALL")) {
                            waterSmall = waterSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            waterRegular = waterRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            waterLarge = waterLarge + 1;
                        }
                        break;
                    case "ADULT_BEVERAGE":
                        if (j.getSize().name().equals("SMALL")) {
                            adultSmall = adultSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            adultRegular = adultRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            adultLarge = adultLarge + 1;
                        }
                        break;
                }

            } else if (category.equals(FoodType.ENTREE)) {
                //System.out.println("-- Entree --");
                Entree j = (Entree) i;

                switch (j.getType().name()) {
                    case "HAMBURGER":
                        if (j.getSize().name().equals("SMALL")) {
                            hamburgerSmall = hamburgerSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            hamburgerRegular = hamburgerRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            hamburgerLarge = hamburgerLarge + 1;
                        }
                        break;
                    case "CHEESEBURGER":
                        if (j.getSize().name().equals("SMALL")) {
                            cheeseBSmall = cheeseBSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            cheeseBRegular = cheeseBRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            cheeseBLarge = cheeseBLarge + 1;
                        }
                        break;
                    case "CHICKEN_SANDWICH":
                        if (j.getSize().name().equals("SMALL")) {
                            chickenSandSmall = chickenSandSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            chickenSandRegular = chickenSandRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            chickenSandLarge = chickenSandLarge + 1;
                        }
                        break;
                    case "CHICKEN_NUGGETS":
                        if (j.getSize().name().equals("SMALL")) {
                            chickenNugSmall = chickenNugSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            chickenNugRegular = chickenNugRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            chickenNugLarge = chickenNugLarge + 1;
                        }
                        break;
                    case "MYSTERY":
                        if (j.getSize().name().equals("SMALL")) {
                            entreeMystSmall = entreeMystSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            entreeMystRegular = entreeMystRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            entreeMystLarge = entreeMystLarge + 1;
                        }
                        break;
                }

            } else if (category.equals(FoodType.SIDE)) {
                //System.out.println("-- Side --");
                Side j = (Side) i;

                switch (j.getType().name()) {
                    case "FRIES":
                        if (j.getSize().name().equals("SMALL")) {
                            friesSmall = friesSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            friesRegular = friesRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            friesLarge = friesLarge + 1;
                        }
                        break;
                    case "APPLE":
                        if (j.getSize().name().equals("SMALL")) {
                            appleSmall = appleSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            appleRegular = appleRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            appleLarge = appleLarge + 1;
                        }
                        break;
                    case "MOZZARELLA_STICKS":
                        if (j.getSize().name().equals("SMALL")) {
                            mozzarellaSmall = mozzarellaSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            mozzarellaRegular = mozzarellaRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            mozzarellaLarge = mozzarellaLarge + 1;
                        }
                        break;
                    case "SALAD":
                        if (j.getSize().name().equals("SMALL")) {
                            saladSmall = saladSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            saladRegular = saladRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            saladLarge = saladLarge + 1;
                        }
                        break;
                    case "ONION_RINGS":
                        if (j.getSize().name().equals("SMALL")) {
                            onionRingSmall = onionRingSmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            onionRingRegular = onionRingRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            onionRingLarge = onionRingLarge + 1;
                        }
                        break;
                    case "MYSTERY":
                        if (j.getSize().name().equals("SMALL")) {
                            sideMysterySmall = sideMysterySmall + 1;
                        } else if (j.getSize().name().equals("REGULAR")) {
                            sideMysteryRegular = sideMysteryRegular + 1;
                        } else if (j.getSize().name().equals("LARGE")) {
                            sideMysteryLarge = sideMysteryLarge + 1;
                        }
                        break;
                }
            }
        }

        // Storing quantity of each ordered item into the inventory system
        // Dessets
        if (applePieSmall > 0) MenuOrder.APPLE_PIE.setSmallSize(applePieSmall);
        if (applePieRegular > 0) MenuOrder.APPLE_PIE.setRegularSize(applePieRegular);
        if (applePieLarge > 0) MenuOrder.APPLE_PIE.setLargeSize(applePieLarge);
        if (iceCreamSmall > 0) MenuOrder.ICE_CREAM.setSmallSize(iceCreamSmall);
        if (iceCreamRegular > 0) MenuOrder.ICE_CREAM.setRegularSize(iceCreamRegular);
        if (iceCreamLarge > 0) MenuOrder.ICE_CREAM.setLargeSize(iceCreamLarge);
        if (bCakeSmall > 0) MenuOrder.BIRTHDAY_CAKE.setSmallSize(bCakeSmall);
        if (bCakeRegular > 0) MenuOrder.BIRTHDAY_CAKE.setRegularSize(bCakeRegular);
        if (bCakeLarge > 0) MenuOrder.BIRTHDAY_CAKE.setLargeSize(bCakeLarge);
        if (cookieSmall > 0) MenuOrder.HOT_COOKIES.setSmallSize(cookieSmall);
        if (cookieRegular > 0) MenuOrder.HOT_COOKIES.setRegularSize(cookieRegular);
        if (cookieLarge > 0) MenuOrder.HOT_COOKIES.setLargeSize(cookieLarge);
        if (totsSmall > 0) MenuOrder.FROSTED_TATER_TOTS.setSmallSize(totsSmall);
        if (totsRegular > 0) MenuOrder.FROSTED_TATER_TOTS.setRegularSize(totsRegular);
        if (totsLarge > 0) MenuOrder.FROSTED_TATER_TOTS.setLargeSize(totsLarge);

        // Drinks
        if (cokeSmall > 0) MenuOrder.COKE.setSmallSize(cokeSmall);
        if (cokeRegular > 0) MenuOrder.COKE.setRegularSize(cokeRegular);
        if (cokeLarge > 0) MenuOrder.COKE.setLargeSize(cokeLarge);
        if (spriteSmall > 0) MenuOrder.SPRITE.setSmallSize(spriteSmall);
        if (spriteRegular > 0) MenuOrder.SPRITE.setRegularSize(spriteRegular);
        if (spriteLarge > 0) MenuOrder.SPRITE.setLargeSize(spriteLarge);
        if (dietCokeSmall > 0) MenuOrder.DIET_COKE.setSmallSize(dietCokeSmall);
        if (dietCokeRegular > 0) MenuOrder.DIET_COKE.setRegularSize(dietCokeRegular);
        if (dietCokeLarge > 0) MenuOrder.DIET_COKE.setLargeSize(dietCokeLarge);
        if (waterSmall > 0) MenuOrder.WATER.setSmallSize(waterSmall);
        if (waterRegular > 0) MenuOrder.WATER.setRegularSize(waterRegular);
        if (waterLarge > 0) MenuOrder.WATER.setLargeSize(waterLarge);
        if (adultSmall > 0) MenuOrder.ADULT_BEVERAGE.setSmallSize(adultSmall);
        if (adultRegular > 0) MenuOrder.ADULT_BEVERAGE.setRegularSize(adultRegular);
        if (adultLarge > 0) MenuOrder.ADULT_BEVERAGE.setLargeSize(adultLarge);

        // Entrees
        if (hamburgerSmall > 0) MenuOrder.HAMBURGER.setSmallSize(hamburgerSmall);
        if (hamburgerRegular > 0) MenuOrder.HAMBURGER.setRegularSize(hamburgerRegular);
        if (hamburgerLarge > 0) MenuOrder.HAMBURGER.setLargeSize(hamburgerLarge);
        if (cheeseBSmall > 0) MenuOrder.CHEESE_BURGER.setSmallSize(cheeseBSmall);
        if (cheeseBRegular > 0) MenuOrder.CHEESE_BURGER.setRegularSize(cheeseBRegular);
        if (cheeseBLarge > 0) MenuOrder.CHEESE_BURGER.setLargeSize(cheeseBLarge);
        if (chickenSandSmall > 0) MenuOrder.CHICKEN_SANDWICH.setSmallSize(chickenSandSmall);
        if (chickenSandRegular > 0) MenuOrder.CHICKEN_SANDWICH.setRegularSize(chickenSandRegular);
        if (chickenSandLarge > 0) MenuOrder.CHICKEN_SANDWICH.setLargeSize(chickenSandLarge);
        if (chickenNugSmall > 0) MenuOrder.CHICKEN_NUGGET.setSmallSize(chickenNugSmall);
        if (chickenNugRegular > 0) MenuOrder.CHICKEN_NUGGET.setRegularSize(chickenNugRegular);
        if (chickenNugLarge > 0) MenuOrder.CHICKEN_NUGGET.setLargeSize(chickenNugLarge);
        if (entreeMystSmall > 0) MenuOrder.SHRIMP_TACOS.setSmallSize(entreeMystSmall);
        if (entreeMystRegular > 0) MenuOrder.SHRIMP_TACOS.setRegularSize(entreeMystRegular);
        if (entreeMystLarge > 0) MenuOrder.SHRIMP_TACOS.setLargeSize(entreeMystLarge);

        // Sides
        if (friesSmall > 0) MenuOrder.FRIES.setSmallSize(friesSmall);
        if (friesRegular > 0) MenuOrder.FRIES.setRegularSize(friesRegular);
        if (friesLarge > 0) MenuOrder.FRIES.setLargeSize(friesLarge);
        if (appleSmall > 0) MenuOrder.APPLES.setSmallSize(appleSmall);
        if (appleRegular > 0) MenuOrder.APPLES.setRegularSize(appleRegular);
        if (appleLarge > 0) MenuOrder.APPLES.setLargeSize(appleLarge);
        if (mozzarellaSmall > 0) MenuOrder.MOZARELLA_STICKS.setSmallSize(mozzarellaSmall);
        if (mozzarellaRegular > 0) MenuOrder.MOZARELLA_STICKS.setRegularSize(mozzarellaRegular);
        if (mozzarellaLarge > 0) MenuOrder.MOZARELLA_STICKS.setLargeSize(mozzarellaLarge);
        if (saladSmall > 0) MenuOrder.SALAD.setSmallSize(saladSmall);
        if (saladRegular > 0) MenuOrder.SALAD.setRegularSize(saladRegular);
        if (saladLarge > 0) MenuOrder.SALAD.setLargeSize(saladLarge);
        if (onionRingSmall > 0) MenuOrder.ONION_RINGS.setSmallSize(onionRingSmall);
        if (onionRingRegular > 0) MenuOrder.ONION_RINGS.setRegularSize(onionRingRegular);
        if (onionRingLarge > 0) MenuOrder.ONION_RINGS.setLargeSize(onionRingLarge);
        if (sideMysterySmall > 0) MenuOrder.ALLIGATOR_BITE.setSmallSize(sideMysterySmall);
        if (sideMysteryRegular > 0) MenuOrder.ALLIGATOR_BITE.setRegularSize(sideMysteryRegular);
        if (sideMysteryLarge > 0) MenuOrder.ALLIGATOR_BITE.setLargeSize(sideMysteryLarge);

        // process the data in the inventory system and display the results
        inventMng.processOrderData(processOrderDataMode);
        displayNumCountOrderRequested(inventMng.getNumCountOrderRequested());
        displayCurrentProcessOrderDataMode();
        displayItemProcessable(inventMng.getItemsProcessable());
        displayItemNotProcessable(inventMng.getOutOfInventory());

        this.statusOrderProcessable = inventMng.getStatusOrderProcessable();
        displayOrderCheckResult();
        displayCurrentInventory();

        ///////////////////////////////////////////////////////////
        if (statusOrderProcessable == 2) {
            returnValue = true;
        }

        return returnValue;
    }

    // Works with Inventory System (processOrder()) - Display the count of requested orders
    private void displayNumCountOrderRequested(int numCountRequested) {
        System.out.println("\nRequested count : " + numCountRequested);
    }

    // Works with Inventory System (processOrder()) - Display the mode of OrderProcessing in the inventory system
    private void displayCurrentProcessOrderDataMode() {
        System.out.print("Current process mode : ");
        switch (processOrderDataMode) {
            case 0:
                System.out.println("PROCESS_ONLY_FULLY_PROCESSABLE");
                break;
            case 1:
                System.out.println("PROCESS_EVEN_PARTIALLY_PROCESSABLE");
                break;
        }
    }

    // Works with Inventory System (processOrder()) - Display item processable
    private void displayItemProcessable(Map<String, Integer> itemProcessable) {
        int itemNum;
        String[] itemName = new String[2];

        System.out.println("\n-------- ordered items processable --------");
        if (itemProcessable.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (String i : itemProcessable.keySet()) {
                itemNum = itemProcessable.get(i);
                itemName = i.split(" ");

                System.out.println(itemName[0] + ":" + itemName[1] + " : " + itemNum);
            }
        }
        System.out.println("----------------------------------------");
    }

    // Works with Inventory System (processOrder()) - Display item not processable due to lack of inventory
    private void displayItemNotProcessable(Map<String, Integer> itemNotProcessable) {
        int itemNum;
        String[] itemName = new String[2];
        System.out.println("\n-------- ordered items NOT processable--------");
        if (itemNotProcessable.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (String i : itemNotProcessable.keySet()) {
                itemNum = itemNotProcessable.get(i);
                itemName = i.split(" ");

                System.out.println(itemName[0] + ":" + itemName[1] + " (reason : " + itemNum + " items)");
            }
        }
        System.out.println("----------------------------------------");
    }

    // Works with Inventory System (processOrder()) - Display the result of order and inventory
    private void displayOrderCheckResult() {

        System.out.print("\nOrder items check result : ");

        switch (this.statusOrderProcessable) {
            case 0:
                System.out.println("NOT_YET_CHECKED");
                break;
            case 1:
                System.out.println("NOT_FULLY_PROCESSABLE");
                break;
            case 2:
                System.out.println("FULLY_PROCESSABLE");
                break;
        }
    }

    // Works with Inventory System (processOrder()) - Display current inventory
    private void displayCurrentInventory() {
        System.out.println("\n-------- Current inventory--------");
        inventMng.displayCurrentInventoryData();
        System.out.println("----------------------------------");
    }
}


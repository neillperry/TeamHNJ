package com.mcdonalds.store;

import com.mcdonalds.user.User;
import com.mcdonalds.order.Order;
import junit.framework.TestCase;
import com.mcdonalds.food.*;
import java.util.Collection;

public class StoreTest extends TestCase {
    private Store newStore;
    private Order firstOrder;
    private Order secondOrder;
    private Order thirdOrder;

    public void setUp() throws Exception {
        super.setUp();
        newStore = new Store();

        User newUser = new User("Bob", 22);
        User newUser2 = new User("Jane", 34);
        User newUser3 = new User("Dog", 7);

        firstOrder = new Order(newStore, newUser);
        secondOrder = new Order(newStore, newUser2);
        thirdOrder = new Order(newStore, newUser3);

        // FOOD ITEMS
        Dessert cookie = new Dessert(DessertType.COOKIE, Size.LARGE);
        Dessert applePie = new Dessert(DessertType.APPLE_PIE, Size.REGULAR);
        Dessert taterTots = new Dessert(DessertType.FROSTED_TATER_TOTS, Size.SMALL);

        Entree burger = new Entree(EntreeType.HAMBURGER, Size.LARGE);
        Entree cheeseBurger = new Entree(EntreeType.CHEESEBURGER, Size.REGULAR);
        Entree mystery = new Entree(EntreeType.MYSTERY, Size.SMALL);

        Side fries = new Side(SideType.FRIES, Size.LARGE);
        Side apple = new Side(SideType.APPLE, Size.REGULAR);
        Side mozzarella = new Side(SideType.MOZZARELLA_STICKS, Size.SMALL);

        Drink testCoke = new Drink(DrinkType.COKE, Size.LARGE);
        Drink testSprite = new Drink(DrinkType.SPRITE, Size.REGULAR);
        Drink testAdult = new Drink(DrinkType.ADULT_BEVERAGE, Size.SMALL);

        firstOrder.addFoodItem(burger);
        firstOrder.addFoodItem(cookie);
        firstOrder.addFoodItem(taterTots);
        firstOrder.addFoodItem(mystery);
        firstOrder.addFoodItem(fries);
        firstOrder.addFoodItem(apple);
        firstOrder.addFoodItem(testSprite);
        firstOrder.addFoodItem(testSprite);
        firstOrder.addFoodItem(taterTots);
        firstOrder.addFoodItem(cheeseBurger);

        secondOrder.addFoodItem(burger);
        secondOrder.addFoodItem(burger);
        secondOrder.addFoodItem(burger);
        secondOrder.addFoodItem(burger);
        secondOrder.addFoodItem(cheeseBurger);
        secondOrder.addFoodItem(cheeseBurger);
        secondOrder.addFoodItem(testSprite);
        secondOrder.addFoodItem(mozzarella);
        secondOrder.addFoodItem(testAdult);
        secondOrder.addFoodItem(testCoke);
        secondOrder.addFoodItem(testAdult);
        secondOrder.addFoodItem(testCoke);
    }

    public void testProcessOrderZero() {
        Collection<Order> completedOrders = newStore.getCompletedOrders();
        assertEquals(0, completedOrders.size());
    }

    public void testProcessOrders() {
        newStore.addNewOrder(firstOrder);
        newStore.addNewOrder(secondOrder);
        newStore.addNewOrder(thirdOrder);

        newStore.processOrder(firstOrder);
        newStore.processOrder(secondOrder);
        newStore.processOrder(thirdOrder);
        Collection<Order> completedOrders = newStore.getCompletedOrders();
        assertEquals(3, completedOrders.size());
    }

    public void testAddNewOrder() {
        newStore.addNewOrder(firstOrder);
        Collection<Order> receivedOrders = newStore.getPlacedOrders();
        assertEquals(1, receivedOrders.size());

    }

    public void testCreateOrderNumber() {
        newStore.addNewOrder(firstOrder);
        newStore.processOrder(firstOrder);
        
    }
}
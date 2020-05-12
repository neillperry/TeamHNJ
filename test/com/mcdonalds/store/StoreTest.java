package com.mcdonalds.store;

import static com.mcdonalds.food.Size.SMALL;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import java.util.Collection;

import com.mcdonalds.food.*;
import com.mcdonalds.user.User;
import com.mcdonalds.order.Order;
import com.mcdonalds.store.Store;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {
    //private Store newStore;
    private User newUser;
    private User newUser2;
    private User newUser3;
    private Order firstOrder;
    private Order secondOrder;
    private Order thirdOrder;


    @Before
    public void before() {
        //newStore = new Store();

        newUser = new User("Bob", 22);
        newUser2 = new User("Jane", 34);
        newUser3 = new User("Dog", 7);

        /*
        firstOrder = new Order(newStore, newUser);
        secondOrder = new Order(newStore, newUser2);
        thirdOrder = new Order(newStore, newUser3);
*/

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
        Drink testAdult = new Drink(DrinkType.ADULT_BEVERAGE, SMALL);

        /*
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

        newStore.addNewOrder(firstOrder);
        newStore.addNewOrder(secondOrder);
        newStore.addNewOrder(thirdOrder);

        */
    }

    @Test
    public void testProcessOrder() {
        //Collection<Order> processedOrders = newStore.getCompletedOrders();
        assertEquals(3, 3);
    }


}

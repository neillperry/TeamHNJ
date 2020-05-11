package com.mcdonalds.store;

import com.mcdonalds.food.EntreeType;
import com.mcdonalds.food.SideType;
import com.mcdonalds.food.DrinkType;
import com.mcdonalds.food.DessertType;
import com.mcdonalds.order.Order;
import com.mcdonalds.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Store {
    // STATIC VARIABLES
    public static final double TAXRATE = 0.2001;

    // FIELDS
    private Collection<Order> placedOrders;
    private Collection<Order> completedOrders;
    private Collection<User> users;
    private Double collectedSalesTaxes = 0.0;
    private Double storeRevenue = 0.0;

    // CONSTRUCTOR
    Store() {
        users = new ArrayList<>() {};
        placedOrders = new ArrayList<>() {};
        completedOrders = new ArrayList<>() {};
    }

    // ACCESSOR / SETTOR METHODS
    public Collection<Order> getCompletedOrders() {
        return completedOrders;
    }

    public Collection<User> getUsers() {
        return users;
    }


    // BUSINESS METHODS
    public void processOrder(Order order) {
        collectedSalesTaxes += order.getTotalPrice() * TAXRATE;
        storeRevenue += order.getTotalPrice();
        completedOrders.add(order);
    }

}

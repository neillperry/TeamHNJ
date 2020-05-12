package com.mcdonalds.store;

import com.mcdonalds.food.*;
import com.mcdonalds.order.Order;
import com.mcdonalds.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

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
    public Store() {
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
        order.setOrderNumber(createOrderNumber());
        collectedSalesTaxes += order.getTotalPrice() * TAXRATE;
        storeRevenue += order.getTotalPrice();
        completedOrders.add(order);
    }

    public void addNewOrder(Order newOrder) {
        placedOrders.add(newOrder);
    }

    // BUSINESS METHODS
    public int createOrderNumber() {
        Random r = new Random();
        return r.nextInt((999999999-1)+1) + 0;
    }

}

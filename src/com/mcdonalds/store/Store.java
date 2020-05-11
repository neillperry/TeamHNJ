package com.mcdonalds.store;

import com.mcdonalds.order.Order;
import com.mcdonalds.user.User;

import java.util.ArrayList;
import java.util.Collection;

public class Store {
    // FIELDS
    private Collection<Order> orders;
    private Collection<User> users;
    private Double collectedSalesTaxes = 0.0;

    // CONSTRUCTOR
    Store() {
        users = new ArrayList<>() {};
        orders = new ArrayList<>() {};
    }

    // ACCESSOR / SETTOR METHODS
    public Collection<Order> getOrders() {
        return orders;
    }

    public Collection<User> getUsers() {
        return users;
    }

}

package com.mcdonalds.store;

import static org.junit.Assert.*;
import com.mcdonalds.user.User;
import com.mcdonalds.order.Order;

import org.junit.Before;
import org.junit.Test;

public class StoreTest {

    @Before
    public void before() {
        Store newStore = new Store();
        User newUser = new User("Bob", 22);
        Order firstOrder = new Order(newStore, newUser);

    }



}

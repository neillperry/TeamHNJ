package com.mcdonalds.order;

import com.mcdonalds.user.User;
import junit.framework.TestCase;
import org.junit.Test;
import com.mcdonalds.store.Store;
import com.mcdonalds.user.User;

public class OrderTest extends TestCase {

    @Test
    public void testThing() {
        Store newStore = new Store();
        User newUser = new User("Bob", 22);
        Order orderTest = new Order(newStore, newUser);
        assertEquals(3, 3);
    }


}
package com.mcdonalds.user;

import junit.framework.TestCase;
import org.junit.Test;

public class UserTest extends TestCase {

    @Test
    public void testUserName() {
        User newUser = new User("Bob", 12);
        assertEquals("Bob", newUser.getName());
    }

    @Test
    public void testUserAge() {
        User newUser = new User("Bob", 12);
        assertEquals(12, newUser.getAge());
    }
}
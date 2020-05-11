package com.mcdonalds.order;

import java.util.Collection;
import com.mcdonalds.user.User;
import com.mcdonalds.store.Store;
import com.mcdonalds.food.FoodItem;
import java.util.Random;

public class Order {
    public static final double TAXRATE = 20.01;
    private User customer;
    private Store mainStore;
    private Collection<FoodItem> foodItems;
    private Double totalPrice;
    private int orderNumber;

    Order(Store store, User customer){
        setMainStore(store);
        setCustomer(customer);
        orderNumber = setOrderNumber(); 
    }

    public void setMainStore(Store mainStore) {
        this.mainStore = mainStore;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }


    public int setOrderNumber(int min) {
        Random r = new Random();
        return r.nextInt((999999999-1)+1) + min;
    }


}

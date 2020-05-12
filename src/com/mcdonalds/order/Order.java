package com.mcdonalds.order;

import java.util.ArrayList;
import java.util.Collection;
import com.mcdonalds.user.User;
import com.mcdonalds.store.Store;
import com.mcdonalds.food.FoodItem;
import java.util.Random;

public class Order {
    private Store mainStore;
    private User customer;
    private Collection<FoodItem> foodItems;
    private Double totalPrice = 0.0;
    private int orderNumber;

    // CONSTRUCTOR
    public Order(Store store, User customer){
        setMainStore(store);
        setCustomer(customer);
        foodItems = new ArrayList<>() {};
    }

    // ACCESSOR / SETTOR METHODS
    public void setMainStore(Store mainStore) {
        this.mainStore = mainStore;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Collection<FoodItem> getFoodItems() {
        return foodItems;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void calculateTotalPrice() {
        for (FoodItem food : foodItems) {
            totalPrice += food.getPrice();
        }
    }

    public void addFoodItem(FoodItem food) {
        foodItems.add(food);
    }
}

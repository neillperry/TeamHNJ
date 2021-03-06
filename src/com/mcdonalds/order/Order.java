package com.mcdonalds.order;

import java.util.ArrayList;
import java.util.Collection;
import com.mcdonalds.user.User;
import com.mcdonalds.store.Store;
import com.mcdonalds.food.FoodItem;
import java.util.Random;

public class Order {
    // FIELDS
    private Store mainStore;
    private User customer;
    private Collection<FoodItem> foodItems;
    private double subTotalPrice = 0.0;
    private double tax = 0.0;
    private int orderNumber;
    private boolean isComplete = false;

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

    public Double getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setIsComplete(boolean completeness) {
        isComplete = completeness;
    }

    public boolean getIsComplete() { return isComplete; }

    public void setTax(double calculatedTax) {this.tax = calculatedTax; }

    public double getTax() { return this.tax; }

    public double getFinalPrice() { return this.tax + this.subTotalPrice; }

    public void calculateSubTotalPrice() {
        for (FoodItem food : foodItems) {
            subTotalPrice += food.getPrice();
        }
    }

    public void addFoodItem(FoodItem food) {
        foodItems.add(food);
    }
}

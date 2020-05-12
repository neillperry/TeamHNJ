package com.mcdonalds.inventory;

public enum MenuInventory {

    HAMBURGER(0, 0, 0),
    CHEESE_BURGER(0,0, 0),
    CHICKEN_SANDWICH(0, 0, 0),
    CHICKEN_NUGGET(0, 0, 0),
    SHRIMP_TACOS(0, 0, 0),

    APPLE_PIE(0, 0, 0),
    ICE_CREAM(0, 0, 0),
    BIRTHDAY_CAKE(0, 0, 0),
    HOT_COOKIES(0, 0, 0),
    FROSTED_TATER_TOTS(0, 0, 0),

    FRIES(0, 0, 0),
    APPLES(0, 0, 0),
    MOZARELLA_STICKS(0, 0, 0),
    SALAD(0, 0, 0),
    ONION_RINGS(0,0, 0),
    ALLIGATOR_BITE(0, 0, 0),

    COKE(0, 0, 0),
    SPRITE(0, 0,0),
    DIET_COKE(0, 0, 0),
    ADULT_BEVERAGE(0, 0, 0);

    private int smallSize;
    private int regularSize;
    private int largeSize;

    MenuInventory(int smallSize, int regularSize, int largeSize){
        this.smallSize = smallSize;
        this.regularSize = regularSize;
        this.largeSize = largeSize;
    }

    /* read quantity of each size */
    public int getSmallSize(){
        return smallSize;
    }
    public int getRegularSize(){
        return regularSize;
    }
    public int getLargeSize(){
        return largeSize;
    }

    /* set quantity of each size */
    public void setSmallSize(int smallSize){
        this.smallSize = smallSize;
    }
    public void setRegularSize(int regularSize){
        this.regularSize = regularSize;
    }
    public void setLargeSize(int largeSize){
        this.largeSize = largeSize;
    }

}

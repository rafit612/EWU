package com.hmatewu.ewulife;

public class FoodAdapter {
    String Restaurant;
    String Item;
    String Price;

    public FoodAdapter() {
    }

    public FoodAdapter(String restaurant, String item, String price) {
        Restaurant = restaurant;
        Item = item;
        Price = price;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String restaurant) {
        Restaurant = restaurant;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}

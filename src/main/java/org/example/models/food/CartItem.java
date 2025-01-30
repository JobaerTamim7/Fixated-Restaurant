package org.example.models.food;

import org.example.models.food.FoodItem;

public class CartItem {
    private final FoodItem foodItem;
    private int quantity;

    public CartItem(FoodItem foodItem) {
        this.foodItem = foodItem;
        this.quantity = 1;
    }

    public void incrementQuantity() {
        quantity++;
    }


    public FoodItem getFoodItem() { return foodItem; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return foodItem.getPrice() * quantity; }
    public String getItemName() {return foodItem.getName(); }
}
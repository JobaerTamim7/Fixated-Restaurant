package org.example.services.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.models.food.CartItem;
import org.example.models.food.FoodItem;

public class CartService {
    private static CartService instance;
    private final ObservableList<CartItem> items = FXCollections.observableArrayList();

    private CartService() {}

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }

    public void addItem(FoodItem foodItem) {
        boolean itemFound = false;

        for (CartItem cartItem : items) {
            if (cartItem.getFoodItem().getName().equals(foodItem.getName())) {
                cartItem.incrementQuantity();
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            items.add(new CartItem(foodItem));
        }
    }

    public double getTotal() {
        double total = 0;

        for (CartItem cartItem : items) {
            total += cartItem.getTotal(); 
        }

        return total;
    }


    public ObservableList<CartItem> getItems() {
        return FXCollections.observableList(items);
    }

    public void clearCart() {
        items.clear();
    }
}

package org.example.models.food;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class FoodItem {
    private final String name;
    private final String category;
    private final double price;
    private final String image;

    public FoodItem(String name, String category, double price, String image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

}

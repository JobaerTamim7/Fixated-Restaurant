package org.example.models.food;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodItem {
    private final String name;
    private final String category;
    private final double price;
    private final String image;

    @JsonCreator
    public FoodItem(
            @JsonProperty("name") String name,
            @JsonProperty("category") String category,
            @JsonProperty("price") double price,
            @JsonProperty("image") String image) {
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

package org.example.controllers.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.food.FoodItem;
import org.example.services.CartService;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.util.List;

public class MenuController implements SwitchSceneInterface {

    @FXML
    private GridPane menuGrid;
    private final int COL = 3;

    private final List<FoodItem> FoodItems = List.of(
            new FoodItem("Burger","FastFood", 9.99, "burger.png"),
            new FoodItem("Pizza", "FastFood",12.99, "pizza.png"),
            new FoodItem("Fries", "FastFood",4.99, "fries.png"),
            new FoodItem("Salad", "FastFood",8.99, "salad.png"),
            new FoodItem("Pasta", "FastFood",11.99, "pasta.png"),
            new FoodItem("Steak", "FastFood",19.99, "steak.png"),
            new FoodItem("Soup", "FastFood",6.99, "soup.png"),
            new FoodItem("Ice Cream", "FastFood",5.99, "icecream.png"),
            new FoodItem("Soda", "FastFood",2.99, "soda.png")
    );

    private Stage stage;

    @Override
    public void initialize(Stage stage) {
        try{
            this.stage = stage;
            populateMenuGrid();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void populateMenuGrid() {
        for(int i = 0; i < FoodItems.size(); i++) {
            FoodItem item = FoodItems.get(i);
            addItemCard(item, i);
        }
    }
    @FXML
    private void handleCartNavigation(Event event) {
        try {
            SceneController.switchScene(stage, SceneName.CART);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exit(){
        System.exit(0);
    }

    private void addItemCard(FoodItem item, int index) {
        VBox card = new VBox(10);
        card.getStyleClass().add("menu-card");

        // Image
        ImageView image = new ImageView();
        try {
            image.setImage(new Image(
                    getClass().getResourceAsStream("/images/food/" + item.getImage())
            ));
        } catch (Exception e) {
            image.setImage(new Image(
                    getClass().getResourceAsStream("/images/placeholder.png")
            ));
        }
        image.setFitWidth(200);
        image.setFitHeight(150);
        image.setPreserveRatio(true);

        Label nameLabel = new Label(item.getName());
        nameLabel.getStyleClass().add("item-name");

        Label priceLabel = new Label("$"+ item.getPrice());
        priceLabel.getStyleClass().add("item-price");

        Button addButton = new Button("Add to Cart");
        addButton.setOnAction(e -> handleAddToCart(item));

        card.getChildren().addAll(image, nameLabel, priceLabel, addButton);

        int column = index % COL;
        int row = index / COL;
        menuGrid.add(card, column, row);
    }

    private void handleAddToCart(FoodItem item) {
        CartService.getInstance().addItem(item);
        showAddedToCartNotification(item);
    }

    private void showAddedToCartNotification(FoodItem item) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item Added");
        alert.setHeaderText(null);
        alert.setContentText(item.getName() + " added to cart!");
        alert.initOwner(stage);
        alert.showAndWait();
    }

    public void handleCartNavigation(ActionEvent actionEvent) {
        try {
            SceneController.switchScene(stage, SceneName.CART);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

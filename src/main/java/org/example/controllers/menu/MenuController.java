package org.example.controllers.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
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
import org.example.services.customer.CartService;
import org.example.services.customer.FoodMenuService;
import io.github.palexdev.materialfx.controls.MFXPagination;

import java.io.IOException;
import java.util.List;

public class MenuController implements SwitchSceneInterface {

    @FXML
    private GridPane menuGrid;

    @FXML
    private MFXPagination pagination;

    private final int COL = 3;
    private int page = 1;
    private List<FoodItem> foodItems;
    private Stage stage;

    @Override
    public void initialize(Stage stage) {
        try {
            this.stage = stage;
            loadMenu();
            setupPagination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMenu() {
        foodItems = FoodMenuService.menu(page);
        System.out.println(foodItems);
        populateMenuGrid();
    }

    private void populateMenuGrid() {
        menuGrid.getChildren().clear();
        for (int i = 0; i < foodItems.size(); i++) {
            addItemCard(foodItems.get(i), i);
        }
    }

    private void setupPagination() {
        pagination.setMaxPage(2);
        pagination.setCurrentPage(1);

        pagination.currentPageProperty().addListener((observable, oldValue, newValue) -> {
            this.page = newValue.intValue();
            loadMenu();
        });
    }

    @FXML
    private void handleCartNavigation(ActionEvent event) {
        try {
            SceneController.switchScene(stage, SceneName.CART);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exit() {
        System.exit(0);
    }

    private void addItemCard(FoodItem item, int index) {
        VBox card = new VBox(10);
        card.setAlignment(Pos.CENTER);


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

        Label priceLabel = new Label("$" + item.getPrice());

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
}

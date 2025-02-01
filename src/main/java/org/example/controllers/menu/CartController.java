package org.example.controllers.menu;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.controllers.scene.SceneController;
import org.example.controllers.scene.SceneName;
import org.example.controllers.scene.SwitchSceneInterface;
import org.example.models.food.CartItem;
import org.example.services.customer.CartService;

import java.io.IOException;

public class CartController implements SwitchSceneInterface {
    @FXML private TableView<CartItem> cartTable;
    @FXML private TableColumn<CartItem, String> nameColumn;
    @FXML private TableColumn<CartItem, Double> priceColumn;
    @FXML private TableColumn<CartItem, Integer> quantityColumn;
    @FXML private TableColumn<CartItem, Double> totalColumn;

    private Stage stage;

    @Override
    public void initialize(Stage stage) {
        this.stage = stage;
        configureTable();
        cartTable.setItems(CartService.getInstance().getItems());
    }

    private void configureTable() {
        nameColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getFoodItem().getName()
                ));


        priceColumn.setCellValueFactory(cellData ->
                        new SimpleDoubleProperty(
                                cellData.getValue().getFoodItem().getPrice()
                        ).asObject());

        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    @FXML
    private void handleCheckout() throws IOException {
        CartService.getInstance().clearCart();
        SceneController.switchScene(stage, SceneName.MENU);
    }




}

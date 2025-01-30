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
import org.example.services.CartService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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


    private void generateReceiptFile() {
        try {
            // Create directory if it doesn't exist
            Path directory = Paths.get(System.getProperty("user.home"), "OrderHistory");
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            // Create filename with timestamp
            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
            );
            Path filePath = directory.resolve("Order_" + timestamp + ".txt");

            // Create receipt content
            String content = buildReceiptContent();

            // Write to file
            Files.write(filePath, content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private String buildReceiptContent() {
        StringBuilder sb = new StringBuilder();
        List<CartItem> items = CartService.getInstance().getItems();

        // Header
        sb.append("========== ORDER RECEIPT ==========\n");
        sb.append("Date: ").append(LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        )).append("\n\n");

        // Items
        sb.append("Item                 "+ "Price                   "+ "Quantity                    "+ "Total");
        sb.append("------------------------------------------------\n");

        for (CartItem item : items) {
            sb.append(item.getFoodItem().getName()+ "                   " +
                    item.getFoodItem().getPrice()+  "                   " +
                    item.getQuantity()+  "                   " +
                    item.getTotal());
        }

        // Footer
        sb.append("\n");
        sb.append("Total Items: ").append(items.size()).append("\n");
        sb.append("Grand Total: $").append(
                items.stream().mapToDouble(CartItem::getTotal).sum()
        ).append("\n");
        sb.append("========== THANK YOU ==========\n");

        return sb.toString();
    }
}

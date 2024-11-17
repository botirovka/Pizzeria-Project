package org.example.cppprojectui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.cppprojectui.models.Pizza;
import org.example.cppprojectui.models.PizzaState;

public class OrderdetailsController {
    @FXML
    private Text orderText;

    @FXML
    private TableView<Pizza> orderDetailsTable;

    private ObservableList<Pizza> orderDetails = FXCollections.observableArrayList(); // Ініціалізуємо тут

    @FXML
    private TableColumn<Pizza, String> namesColumn;

    @FXML
    private TableColumn<Pizza, PizzaState> statesColumn;

    @FXML
    private void initialize() {
        // Очищаємо таблицю
        orderDetailsTable.getItems().clear();

        // Налаштовуємо колонки
        namesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        statesColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

        // Встановлюємо початковий список
        orderDetailsTable.setItems(orderDetails);
    }

    @FXML
    private void closeOrderDetailsWindow() {
        Stage stage = (Stage) orderDetailsTable.getScene().getWindow();
        stage.close();
    }

    public void setOrderDetails(ObservableList<Pizza> pizzas) {
        // Видаляємо старих слухачів, якщо є
        if (this.orderDetails != null) {
            this.orderDetails.removeListener(listChangeListener);
        }

        // Призначаємо новий список
        this.orderDetails = pizzas;

        // Додаємо слухача змін
        this.orderDetails.addListener(listChangeListener);

        // Оновлюємо таблицю
        orderDetailsTable.setItems(orderDetails);
    }

    private final ListChangeListener<Pizza> listChangeListener = change -> {
        while (change.next()) {
            if (change.wasAdded() || change.wasRemoved() || change.wasUpdated()) {
                // Таблиця автоматично оновиться, бо ObservableList вже прив'язаний
                orderDetailsTable.refresh();
            }
        }
    };

    public void setOrderText(String orderText) {
        this.orderText.setText(orderText);
    }
}

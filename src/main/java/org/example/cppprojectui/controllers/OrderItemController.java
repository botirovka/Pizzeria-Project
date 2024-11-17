package org.example.cppprojectui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OrderItemController {

    @FXML
    private Text orderText;

    @FXML
    private Button detailsButton;

    // Метод для заповнення даних замовлення
    public void setData(int orderId, String clientName) {
        orderText.setText("ID " + orderId + ": " + clientName);

        // Додайте обробник події для кнопки
        detailsButton.setOnAction(event -> {
            openOrderDetailsWindow();
            System.out.println("Details button clicked for Order ID: " + orderId);
        });
    }

    @FXML
    private void openOrderDetailsWindow() {
        try {
            // Завантаження FXML для модального вікна
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/cppprojectui/views/orderdetails-view.fxml"));
            Parent root = loader.load();

            OrderdetailsController controller = loader.getController();

            // Створення нового вікна для повідомлення
            Stage orderDetailsStage = new Stage();
            orderDetailsStage.initModality(Modality.APPLICATION_MODAL); // Встановлення модальності
            orderDetailsStage.setTitle("Order: " + orderText.getText() + " Details");
            orderDetailsStage.setScene(new Scene(root));
            controller.setOrderText("Order: " + orderText.getText() + " Details");

            // Відображення модального вікна та блокування основного вікна
            orderDetailsStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

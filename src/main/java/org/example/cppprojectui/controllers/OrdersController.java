package org.example.cppprojectui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.cppprojectui.models.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrdersController {

    @FXML
    private Pane cashRegistersPane;

    private List<CashRegisterController> cashRegisterControllers = new ArrayList<>();

    public void setCashRegistersAmount(int cashRegistersAmount) {
        addCashRegisters(cashRegistersAmount);
    }

    private void addCashRegisters(int cashRegistersAmount) {
        try {
            int layoutX = 0;
            for (int i = 0; i < cashRegistersAmount; i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/cppprojectui/views/cash-register.fxml"));
                Node cashRegisterNode = loader.load();
                CashRegisterController cashRegisterController = loader.getController();

                // Зберігаємо контролери кас
                cashRegisterControllers.add(cashRegisterController);

                cashRegisterController.setRegisterLayoutX(layoutX);
                cashRegisterController.setRegisterText(i + 1);

                cashRegistersPane.getChildren().add(cashRegisterNode);
                layoutX += 382;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOrderToCashRegister(int cashRegisterIndex, Order order) {
        if (cashRegisterIndex < cashRegisterControllers.size()) {
            cashRegisterControllers.get(cashRegisterIndex).addOrder(order.getOrderNumber(), order.getClient().getName());
        } else {
            System.out.println("Invalid cash register index");
        }
    }

}

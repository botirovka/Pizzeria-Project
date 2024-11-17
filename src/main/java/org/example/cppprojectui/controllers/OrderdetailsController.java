package org.example.cppprojectui.controllers;

import javafx.collections.FXCollections;
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

    private ObservableList<Pizza> orderDetails;

    @FXML
    private TableColumn<Pizza,String> namesColumn;

    @FXML
    private TableColumn<Pizza, PizzaState> statesColumn;

    @FXML
    private void initialize(){
        orderDetailsTable.getItems().clear();
        namesColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        statesColumn.setCellValueFactory(new PropertyValueFactory<>("state"));

        orderDetails = FXCollections.observableArrayList(
                new Pizza("Margherita", PizzaState.Baking, 15),
                new Pizza("Margherita", PizzaState.Ready, 15),
                new Pizza("Frutti di Mare", PizzaState.Preparing_Dough, 15),
                new Pizza("Quattro Formaggi", PizzaState.Awaiting_Preparation, 15)
        );

        orderDetailsTable.setItems(orderDetails);
    }

    @FXML
    private void closeOrderDetailsWindow(){
        Stage stage = (Stage) orderDetailsTable.getScene().getWindow();
        stage.close();
    }

    public void setOrderText(String orderText){
        this.orderText.setText(orderText);
    }

}

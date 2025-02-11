package com.thomas.timetravelagency;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CustomerView {
    private Stage stage;
    private Scene scene;
    private Scene timeTravelScene;

    UseCase useCase = new UseCase();

    List<Customer> customerList = new ArrayList<>();

    ObservableList<Customer> customers = FXCollections.observableArrayList(customerList);

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public Scene getTimeTravelScene() {
        return timeTravelScene;
    }

    public void setTimeTravelScene(Scene timeTravelScene) {
        this.timeTravelScene = timeTravelScene;
    }
    public void onBsckToMainButtonClicked(ActionEvent actionEvent) {
        stage.setScene(timeTravelScene);
        stage.show();
    }
    @FXML
    TableView<Customer> customerTable = new TableView<>(customers);

    @FXML
    TableColumn<Customer, Integer> idColumn = new TableColumn<>("Id");

    @FXML
    TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");

    @FXML
    TableColumn<Customer, String> emailColumn = new TableColumn<>("Email");

    @FXML
    TextField customerId = new TextField();

    @FXML
    TextField customerName = new TextField();

    @FXML
    TextField customerEmail = new TextField();

    @FXML
    Label answers = new Label();

    @FXML
    public void initialize() {
        customerList = useCase.getCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        customers = FXCollections.observableArrayList(customerList);
        customerTable.setItems(customers);
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        emailColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmail()));
    }
    public void onAddCustomerClicked(ActionEvent actionEvent) {
        int id = Integer.parseInt(customerId.getText());
        String name = customerName.getText();
        String email = customerEmail.getText();
        String customerAdded = useCase.addCustomer(id, name, email);
        answers.setText(customerAdded);
        Customer customer = new Customer(id, name, email);
        customers.add(customer);
        customerTable.setItems(customers);
        customerId.clear();
        customerName.clear();
        customerEmail.clear();
    }
    public void onDeleteCustomerClicked(ActionEvent actionEvent) {
        Customer customer = customerTable.getSelectionModel().getSelectedItem();
        if (customer != null) {
            String removed = useCase.removeCustomer(customer);
            customers.remove(customer);
            answers.setText(removed);
        }
    }
    public void onUpdateCustomerClicked(ActionEvent actionEvent) {
        if (!customerId.getText().isEmpty() && !customerName.getText().isEmpty() && !customerEmail.getText().isEmpty()) {
            Customer customer = new Customer(Integer.parseInt(customerId.getText()), customerName.getText(), customerEmail.getText());
            String updated = useCase.updateCustomer(customer);
            answers.setText(updated);
            initialize();
            customerId.clear();
            customerName.clear();
            customerEmail.clear();
            }
        else{
            Customer customer = customerTable.getSelectionModel().getSelectedItem();
            if (customer != null) {
                customerId.setText(String.valueOf(customer.getId()));
                customerName.setText(customer.getName());
                customerEmail.setText(customer.getEmail());
            }
        }
    }
}

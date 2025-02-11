package com.thomas.timetravelagency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BookingView {
    private Stage stage;
//    private Scene scene;
    private Scene timeTravelScene;
    UseCase useCase = new UseCase();
    private List<Customer> customers = new ArrayList<>();
    private List<TimePeriod> timePeriods = new ArrayList<>();
    private List<TimeMachine> timeMachines = new ArrayList<>();
    private List<Guide> guides = new ArrayList<>();


    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    private ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
    private ObservableList<TimePeriod> timePeriodObservableList = FXCollections.observableArrayList();
    private ObservableList<TimeMachine> timeMachinesObservableList = FXCollections.observableArrayList();
    private ObservableList<Guide> guideObservableList = FXCollections.observableArrayList();

    @FXML
    private ComboBox<Customer> customerBox;
    @FXML
    private ComboBox<TimePeriod> timePeriodBox;
    @FXML
    private ComboBox<TimeMachine> timeMachineBox;
    @FXML
    private ComboBox<Guide> guideBox;
    @FXML
    TextArea textArea;

    public void setScene(Scene timeTravelScene) {
        this.timeTravelScene = timeTravelScene;
    }
    public void onButtonClicked(ActionEvent actionEvent) {
        stage.setScene(timeTravelScene);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void initialize() {
        setCustomerBox();
        setTimePeriodBox();
        setTimeMachineBox();
        setGuideBox();
    }

    public void setCustomerBox() {
        customers = useCase.getCustomers();
        Customer[] customerNames = new Customer[customers.size()];
        for (int i = 0; i < customers.size(); i++) {
            customerNames[i] = customers.get(i);
            customerObservableList.add(customers.get(i));
            System.out.println(customers.get(i));
        }
        customerBox.setItems(FXCollections.observableArrayList(customerNames));
    }
    public void setTimePeriodBox() {
        timePeriods = useCase.getTimePeriods();
        TimePeriod[] timePeriodNames = new TimePeriod[timePeriods.size()];
        for (int i = 0; i < timePeriods.size(); i++) {
            timePeriodNames[i] = timePeriods.get(i);
            timePeriodObservableList.add(timePeriods.get(i));
        }
        timePeriodBox.setItems(FXCollections.observableArrayList(timePeriodNames));
    }
    public void setTimeMachineBox() {
        timeMachines = useCase.getTimeMachines();
        TimeMachine[] timeMachineNames = new TimeMachine[timeMachines.size()];
        for (int i = 0; i < timeMachines.size(); i++) {
            timeMachineNames[i] = timeMachines.get(i);
            timeMachinesObservableList.add(timeMachines.get(i));
        }
        timeMachineBox.setItems(FXCollections.observableArrayList(timeMachineNames));
    }
    public void setGuideBox() {
        guides = useCase.getGuides();
        Guide[] guideNames = new Guide[guides.size()];
        for (int i = 0; i < guides.size(); i++) {
            guideNames[i] = guides.get(i);
            guideObservableList.add(guides.get(i));
        }
        guideBox.setItems(FXCollections.observableArrayList(guideNames));
    }
    public void onSaveBookingClicked(ActionEvent actionEvent) {
        Customer customer = customerBox.getSelectionModel().getSelectedItem();
        TimePeriod timePeriod = timePeriodBox.getSelectionModel().getSelectedItem();
        TimeMachine timeMachine = timeMachineBox.getSelectionModel().getSelectedItem();
        Guide guide = guideBox.getSelectionModel().getSelectedItem();
        String booked = useCase.book(customer,timeMachine, timePeriod, guide);
        textArea.appendText(booked + " --- " + customer.getName() + " --- " + timeMachine.getName() + " --- " + timePeriod.getName());
    }
}

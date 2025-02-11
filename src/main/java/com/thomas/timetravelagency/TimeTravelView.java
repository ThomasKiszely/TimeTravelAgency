package com.thomas.timetravelagency;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TimeTravelView {
    private Stage stage;
    private Scene customerViewScene;
    private Scene bookingScene;
    private Button customer;
    private Button booking;
    private Button timeMachine;
    @FXML
    private TextArea area59;

    UseCase useCase = new UseCase();

    List list = new ArrayList();
    ObservableList observableList = FXCollections.observableList(list);

    List periodList = new ArrayList();
    ObservableList periodObservableList = FXCollections.observableList(periodList);

    @FXML
    private ListView timeTravel = new ListView(observableList);

    @FXML
    private ListView timePeriodView = new ListView(periodObservableList);

    CustomerView customerView;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;
    }

    public void setBookingScene(Scene bookingScene) {
        this.bookingScene = bookingScene;
    }
    public Scene getCustomerView() {
        return customerViewScene;
    }
    public void setScene(Scene customerViewScene) {
        this.customerViewScene = customerViewScene;
    }

    public void onCustomerClick(){
        stage.setScene(customerViewScene);
        stage.show();
        }
    public void onBookingClick(){
        stage.setScene(bookingScene);
        stage.show();
    }
    public void onExitButtonClicked(){
        stage.close();
    }

    public void onTimeMachinesClicked(ActionEvent actionEvent){
        timeTravel.getItems().clear();
        list = useCase.getTimeMachineNames();
        System.out.println(list.size());
        observableList.addAll(FXCollections.observableList(list));
        timeTravel.setItems(observableList);
    }
//    public void onTimeMachineSelected(ActionEvent actionEvent){
//        TimeMachine timeMachine = (TimeMachine) timeTravel.getSelectionModel().getSelectedItem();
//        area59.setText(timeMachine.getName() + timeMachine.getCapacity());
//    }
    public void initialize(){
        if (timeTravel.getSelectionModel().getSelectedItem() != null) {
        String text = (timeTravel.getSelectionModel().getSelectedItem().toString());
        area59.setText(text);
        }
        if (timePeriodView.getSelectionModel().getSelectedItem() != null) {
            String text = (timePeriodView.getSelectionModel().getSelectedItem().toString());
            area59.setText(text);
        }
    }
    public void onMouseClickList(){
        timeTravel.getSelectionModel().getSelectedItem();
        List<TimeMachine> timeMachineList = useCase.getTimeMachineFromName(timeTravel.getSelectionModel().getSelectedItem().toString());
        area59.setText(timeMachineList.toString());
    }
    public void onTimePeriodClicked(){
        periodList.clear();
        timePeriodView.getItems().clear();
        periodList = useCase.getTimePeriodNames();
        periodObservableList.addAll(FXCollections.observableList(periodList));
        timePeriodView.setItems(periodObservableList);
    }
    public void onMouseClickPeriodList(){
        timePeriodView.getSelectionModel().getSelectedItem();
        List<TimePeriod> timePeriodList = useCase.getTimePeriodFromName(timePeriodView.getSelectionModel().getSelectedItem().toString());
        area59.setText(timePeriodList.toString());
    }
}

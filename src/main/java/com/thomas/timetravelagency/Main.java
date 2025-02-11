package com.thomas.timetravelagency;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage stage)throws IOException {
        //Indlæs startmenu
        FXMLLoader timeTravelLoader = new FXMLLoader(Main.class.getResource("TimeTravelView.fxml"));
        Scene timeTravelScene = new Scene(timeTravelLoader.load());
        //Indlæs kundeadministration
        FXMLLoader customerAdminLoader = new FXMLLoader(Main.class.getResource("CustomerAdmin.fxml"));
        Scene customerAdminScene = new Scene(customerAdminLoader.load());
        //Indlæs bookings
        FXMLLoader bookingsLoader = new FXMLLoader(Main.class.getResource("Bookings.fxml"));
        Scene bookingsScene = new Scene(bookingsLoader.load());

        //Få fat i controllerne og forbind dem
        TimeTravelView timeTravelView = timeTravelLoader.getController();
        CustomerView customerView = customerAdminLoader.getController();
        BookingView bookingView = bookingsLoader.getController();

        timeTravelView.setStage(stage);
        timeTravelView.setScene(timeTravelScene);
        timeTravelView.setScene(customerAdminScene);
        timeTravelView.setBookingScene(bookingsScene);

        customerView.setStage(stage);
        customerView.setScene(customerAdminScene);
        customerView.setTimeTravelScene(timeTravelScene);


        bookingView.setStage(stage);
        bookingView.setScene(bookingsScene);
        bookingView.setScene(timeTravelScene);


        stage.setScene(timeTravelScene);
        stage.setTitle("Timetravel Agency");
        InputStream iconStream = getClass().getResourceAsStream("timetravel.png");
        Image icon = new Image(iconStream);
        stage.getIcons().add(icon);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}

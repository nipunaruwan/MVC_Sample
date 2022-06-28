package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashboardController {
    public AnchorPane Home;
    public Label lbldate;
    public Label lbltime;
    public AnchorPane Home1;


    public void initialize() {
        initClock();

        try {
            setChart();
        } catch (Exception e) {

        }
    }

    private void setChart() {
    }

    public void btnorderdetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderDetails.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnorder(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderController.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btnitem(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ItemController.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
    }

    public void btncustomer(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CustomerForm.fxml");
        assert resource != null;
        Parent load= FXMLLoader.load(resource);
        Home.getChildren().clear();
        Home.getChildren().add(load);
            /* Stage window = (Stage) MainContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddDriver.fxml"))));*/
    }

    public void btn_logout(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) Home.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
            /* Stage window = (Stage) MainContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddDriver.fxml"))));*/
    }

    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
          lbltime  .setText(LocalDateTime.now().format(formatter));


            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lbldate.setText(formatter2.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnlogout(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) Home.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
            /* Stage window = (Stage) MainContext.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddDriver.fxml"))));*/
    }
}

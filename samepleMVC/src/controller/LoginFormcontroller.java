package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormcontroller {
    public com.jfoenix.controls.JFXTextField txtUsername;
    public com.jfoenix.controls.JFXPasswordField txtpassword;
    public AnchorPane root;

    public void btnlogin(ActionEvent actionEvent) throws IOException {
      /*  if (txtUsername.getText().equalsIgnoreCase("admin") && txtpassword.getText().equalsIgnoreCase("1234")) ;
        Stage window = (Stage) this.root.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/CustomerForm.fxml"))));
        window.centerOnScreen();*/
LoginFormManager();
    }

    private void LoginFormManager() throws IOException {
        String user = "admin";
        String password = "1234";
        if (txtUsername.getText().equals(user) && txtpassword.getText().equals(password)) {
            Stage window = (Stage) root.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashboardController.fxml"))));

        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
        }
     /* System.out.println("wada");
        } else if (txtUsername.getText().isEmpty() && txtpassword.getText().isEmpty()) {
           //root.setText("Your User Name Or Password IS Empty...!");
           txtUsername.clear();txtpassword.clear();
        }



    else if (!txtUsername.getText().equals(user)) {
         // root.setText("Your User Name is incorrect..!");
            txtUsername.clear();
            txtpassword.clear();
        } else if (!txtpassword.getText().equals(password)) {
            *//*loginpane.setText("Your Password is incorrect..!");*//*
            txtUsername.clear();
            txtpassword.clear();
        }*/
        }

    }



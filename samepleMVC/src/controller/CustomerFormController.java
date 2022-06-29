package controller;

import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerFormController {
    public JFXTextField txtcusID;
    public JFXTextField txtpostalcode;
    public JFXTextField txtCusaddress;
    public JFXTextField txtcity;
    public JFXTextField txtprovide;
    public JFXTextField txtCusname;
    public JFXTextField txttitle;

    public void btnupdate(ActionEvent actionEvent) {
    }

    public void btnsave(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Customer customer = new Customer(Integer.parseInt(txtcusID.getText()), txttitle.getText(), txtCusname.getText(), txtCusaddress.getText(), txtcity.getText(), txtprovide.getText(), Integer.parseInt(txtpostalcode.getText()));


      /*  try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer " + "VALUES (?,?,?,?,?,?,?)");

            preparedStatement.setObject(1, customer.getCusID());
            preparedStatement.setObject(2, customer.getCust_title());

            preparedStatement.setObject(3, customer.getName());
            preparedStatement.setObject(4, customer.getAddresss());
            preparedStatement.setObject(5, customer.getCity());
            preparedStatement.setObject(6, customer.getProvide());
            preparedStatement.setObject(7, customer.getPostalcode());


            int add = preparedStatement.executeUpdate();
            if (add > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "try agian", ButtonType.OK).show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO customer " +
                "VALUES (?,?,?,?,?,?,?)");
        stm.setInt(1, customer.getCusID());
        stm.setString(2, customer.getCust_title());
        stm.setString(3, customer.getName());
        stm.setString(4, customer.getAddresss());
        stm.setString(5, customer.getCity());
        stm.setString(6, customer.getProvide());
        stm.setInt(7, customer.getPostalcode());

        // return stm.executeUpdate()<0;

        int add = stm.executeUpdate();


        if (add > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "try agian", ButtonType.OK).show();
        }

    }

        public void btndelete (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            Customer customer = new Customer(Integer.parseInt(txtcusID.getText()), txttitle.getText(), txtCusname.getText(), txtCusaddress.getText(), txtcity.getText(), txtprovide.getText(), Integer.parseInt(txtpostalcode.getText()));
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE  from customer where CusID=?");
            stm.setInt(1,customer.getCusID());

            int Delete = stm.executeUpdate();
            if (Delete<0){
               new Alert(Alert.AlertType.CONFIRMATION,"Delete",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"try again",ButtonType.OK).show();
            }
        }

        public void btnsearch (ActionEvent actionEvent){
        }
    }


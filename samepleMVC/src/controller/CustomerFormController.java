package controller;

import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Customer customer = new Customer(txtcusID.getText(), txttitle.getText(), txtCusname.getText(), txtCusaddress.getText(), txtcity.getText(), txtprovide.getText(), txtpostalcode.getText());
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE customer SET "+"cust_title=?,cust_name=?,cust_address=?,city=?,province=?,postalcode=? WHERE cust_id=?");
            preparedStatement.setObject(1,customer.getCust_title());
            preparedStatement.setObject(2,customer.getName());
            preparedStatement.setObject(3,customer.getAddresss());
            preparedStatement.setObject(4,customer.getCity());
            preparedStatement.setObject(5,customer.getProvide());
            preparedStatement.setObject(6,customer.getPostalcode());
            preparedStatement.setObject(7,customer.getCusID());

            int update=preparedStatement.executeUpdate();
            if (update>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"try again",ButtonType.OK).show();;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnsave(ActionEvent actionEvent)  {
        Customer customer = new Customer(txtcusID.getText(), txttitle.getText(), txtCusname.getText(), txtCusaddress.getText(), txtcity.getText(), txtprovide.getText(), txtpostalcode.getText());


        try {
         Connection   connection = DbConnection.getInstance().getConnection();


        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer " + "VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setObject(1, customer.getCusID());
            preparedStatement.setObject(2, customer.getCust_title());
            preparedStatement.setObject(3, customer.getName());
            preparedStatement.setObject(4, customer.getAddresss());
            preparedStatement.setObject(5, customer.getCity());
            preparedStatement.setObject(6, customer.getProvide());
            preparedStatement.setObject(7, customer.getPostalcode());

            int save = preparedStatement.executeUpdate();
            if (save > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void btndelete(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM customer WHERE cust_id=?");
        preparedStatement.setObject(1,txtcusID.getText());
        int delete= preparedStatement.executeUpdate();
        if (delete>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try again",ButtonType.OK).show();
        }


    }

    public void btnsearch(ActionEvent actionEvent) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM customer WHERE cust_id=?");
            preparedStatement.setObject(1,txtcusID.getText());

            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                txttitle.setText(resultSet.getString(2));
               txtCusname.setText(resultSet.getString(3));
               txtCusaddress.setText(resultSet.getString(4));
               txtcity.setText(resultSet.getString(5));
               txtprovide.setText(resultSet.getString(6));
               txtpostalcode.setText(resultSet.getString(7));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


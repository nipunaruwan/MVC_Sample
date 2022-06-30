package controller;

import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import view.tm.CustomerTM;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    public JFXTextField txtcusID;
    public JFXTextField txtpostalcode;
    public JFXTextField txtCusaddress;
    public JFXTextField txtcity;
    public JFXTextField txtprovide;
    public JFXTextField txtCusname;
    public JFXTextField txttitle;
    public TableView<CustomerTM> TblCustomer;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cusID"));
        TblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cust_title"));
        TblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        TblCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("addresss"));
        TblCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("city"));
        TblCustomer.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("provide"));
        TblCustomer.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("postalcode"));

        getAllcustomer();

        TblCustomer.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)-> {
            txtcusID.setText(newValue.getCusID());
            txttitle.setText(newValue.getCust_title());
            txtCusname.setText(newValue.getName());
            txtCusaddress.setText(newValue.getAddresss());
            txtcity.setText(newValue.getCity());
            txtprovide.setText(newValue.getProvide());
            txtpostalcode.setText(newValue.getPostalcode());

        });

    }
    private void getAllcustomer(){
        ArrayList<Customer> customers=new ArrayList<>();
        ObservableList<CustomerTM>customerTM= FXCollections.observableArrayList();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                customers.add(new Customer(resultSet.getString(1),
                        resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));

            }
            for (Customer cous :customers){
                customerTM.add(new CustomerTM(cous.getCusID(),cous.getCust_title(),
                        cous.getName(),cous.getAddresss(),cous.getCity(),
                        cous.getProvide(),cous.getPostalcode()));
            }
            TblCustomer.setItems(customerTM);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

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


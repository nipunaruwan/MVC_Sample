package controller;

import com.jfoenix.controls.JFXTextField;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Customer;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemController {


    public JFXTextField txtItemcode;
    public JFXTextField txtItem_type;
    public JFXTextField txtpackSize;
    public JFXTextField txtItemQTY;
    public JFXTextField txtprice;
    public JFXTextField txtdescription;

    public void btnupdate(ActionEvent actionEvent) throws SQLException {
        Item item= new Item(Integer.parseInt(txtItemcode.getText()),txtdescription.getText(),txtpackSize.getText(),Integer.parseInt(txtItemQTY.getText()),Double.parseDouble(txtprice.getText()),txtItem_type.getText());
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE item SET "+"description=?,packSize=?, qtyOnHand=?,unitPrice=?,item_type=? WHERE  item_code=?");
        preparedStatement.setObject(1,item.getDescription());
        preparedStatement.setObject(2,item.getPackSize());
        preparedStatement.setObject(3,item.getQtyOnHand());
        preparedStatement.setObject(4,item.getUnitPrice());
        preparedStatement.setObject(5,item.getItem_type());
        preparedStatement.setObject(6,item.getItem_code());

        int update= preparedStatement.executeUpdate();
        if (update>0){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try agian",ButtonType.OK).show();
        }

    }

    public void btnsave(ActionEvent actionEvent) {
        Item item= new Item(Integer.parseInt(txtItemcode.getText()),txtdescription.getText(),txtpackSize.getText(),Integer.parseInt(txtItemQTY.getText()),Double.parseDouble(txtprice.getText()),txtItem_type.getText());
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT  INTO item "+"VALUE (?,?,?,?,?,?)");
            preparedStatement.setObject(1,item.getItem_code());
            preparedStatement.setObject(2,item.getDescription());
            preparedStatement.setObject(3,item.getPackSize());
            preparedStatement.setObject(4,item.getQtyOnHand());
            preparedStatement.setObject(5,item.getUnitPrice());
            preparedStatement.setObject(6,item.getItem_type());

            int save=preparedStatement.executeUpdate();
            if (save>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Saved ", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try again", ButtonType.OK).show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btndelete(ActionEvent actionEvent) {
    }

    public void btnsearch(ActionEvent actionEvent) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM item  WHERE item_code=?");
            preparedStatement.setObject(1,txtItemcode.getText());

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                txtdescription.setText(resultSet.getString(2));
                
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

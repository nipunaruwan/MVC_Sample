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
import model.Item;
import view.tm.ItemTM;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemController implements Initializable {


    public JFXTextField txtItemcode;
    public JFXTextField txtItem_type;
    public JFXTextField txtpackSize;
    public JFXTextField txtItemQTY;
    public JFXTextField txtprice;
    public JFXTextField txtdescription;
    public TableView<ItemTM> TblItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("item_code"));
        TblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        TblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("packSize"));
        TblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        TblItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        TblItem.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("item_type"));


            getAllitems();



        TblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtItemcode.setText(String.valueOf(newValue.getItem_code()));
            txtdescription.setText(newValue.getDescription());
            txtpackSize.setText(newValue.getPackSize());
            txtItemQTY.setText(String.valueOf(newValue.getQtyOnHand()));
            txtprice.setText(String.valueOf(newValue.getUnitPrice()));
            txtItem_type.setText(newValue.getItem_type());

        });

    }

    private void getAllitems()  {
        ArrayList<Item> items = new ArrayList<>();
        ObservableList<ItemTM> itemTM = FXCollections.observableArrayList();


            try {
                 Connection connection = DbConnection.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    items.add(new Item(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5),resultSet.getString(6)));

                }
                for ( Item item :items){

                    itemTM.add(new ItemTM(item.getItem_code(), item.getDescription(),
                            item.getPackSize(), item.getQtyOnHand(), item.getQtyOnHand(),
                            item.getItem_type()));
                    TblItem.setItems(itemTM);
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


    }

    public void btnupdate(ActionEvent actionEvent)  {


        try {
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE item SET "+"description=?,packSize=?, qtyOnHand=?,unitPrice=?,item_type=? WHERE  item_code=?");
           preparedStatement.setObject(1,txtdescription.getText());
           preparedStatement.setObject(2,txtpackSize.getText());
           preparedStatement.setObject(3,txtItemQTY.getText());
           preparedStatement.setObject(4,txtprice.getText());
           preparedStatement.setObject(5,txtItem_type.getText());
           preparedStatement.setObject(6,txtItemcode.getText());

            int update= preparedStatement.executeUpdate();
            if (update>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try agian",ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




    public void btnsave(ActionEvent actionEvent) {
        Item item= new Item((txtItemcode.getText()),txtdescription.getText(),txtpackSize.getText(),Integer.parseInt(txtItemQTY.getText()),Double.parseDouble(txtprice.getText()),txtItem_type.getText());
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

    public void btndelete(ActionEvent actionEvent) throws SQLException {
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM item WHERE item_code=?");
        preparedStatement.setObject(1,txtItemcode.getText());
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
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM item  WHERE item_code=?");
            preparedStatement.setObject(1,txtItemcode.getText());

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                txtdescription.setText(resultSet.getString(2));
                txtpackSize.setText(resultSet.getString(3));
                txtItemQTY.setText(resultSet.getString(4));
                txtprice.setText(resultSet.getString(5));
                txtItem_type.setText(resultSet.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}

package com.recipeit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AddNewRecipeController {
    ArrayList<String> units = new ArrayList<>();

    @FXML
    private TextField newRecipeNameTF;
    @FXML
    private TextField ingNameTF;
    @FXML
    private TextField amountTF;
    @FXML
    private ChoiceBox<String> unitCB;

    @FXML
    public void initialize(){
        units.add("gr");
        units.add("ml");
        units.add("sdt");
        units.add("sdm");
        units.add("buah");
        ObservableList<String> unitsType = FXCollections.observableArrayList(units);
        unitCB.setItems(unitsType);
    }
    @FXML
    public void addNewRecipeIngBtnClick(){
        String newRecipeName = newRecipeNameTF.getText();
        String ingName = ingNameTF.getText();
        String amount = amountTF.getText();
        String unit = String.valueOf(unitCB.getValue());

        MainController.database.uploadRecipeIng(newRecipeName, ingName, Float.parseFloat(amount), unit);

        ingNameTF.clear();
        amountTF.clear();
    }
    @FXML
    public void backButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainView.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clearButtonClick(){
        newRecipeNameTF.clear();
        ingNameTF.clear();
        amountTF.clear();
    }
}

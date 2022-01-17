package com.recipeit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ShopListController {
    ArrayList<Ingredient> reqIng = MainController.wd.getReqIng();
    ArrayList<String> reqIngString = new ArrayList<>();

    @FXML
    private ListView<String> shopListView;

    @FXML
    public void initialize (){
        String name;
        String amount = null;
        String unit = null;
        for (Ingredient i : reqIng){
            name = i.getName();

            if (i.getType()==Ingredient.Type.GR){
                amount = String.format("%.0f", i.getAmount());
                unit = "gr";
            }
            else if (i.getType()==Ingredient.Type.ML) {
                amount = String.format("%.0f", i.getAmount());
                unit = "ml";
            }
            else if (i.getType()==Ingredient.Type.O){
                amount = String.format("%.0f", i.getAmount());
                unit = "buah";
            }
            else if (i.getType()== Ingredient.Type.SDT){
                amount = String.valueOf(i.getAmount());
                unit = "sdt";
            }
            else if (i.getType()==Ingredient.Type.SDM){
                amount = String.valueOf(i.getAmount());
                unit = "sdm";
            }
            reqIngString.add(name + " " + amount + " " + unit);
        }
        ObservableList<String> reqIng = FXCollections.observableArrayList(reqIngString);
        shopListView.setItems(reqIng);
        shopListView.setOrientation(Orientation.VERTICAL);

//        VBox vbox = new VBox(shopListView);
//        Scene scene = new Scene(vbox, 220, 270);

    }
    @FXML
    public void backBtnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainView.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clearBtnClick(ActionEvent event) throws IOException {
        MainController.wd.clearWeekDiet();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShopListView.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

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

public class MainController {
    public static Postgres database = new Postgres();

    public static WeekDiet wd = new WeekDiet();
    ArrayList<Recipe> recipeDB = database.reloadRecipe();

    @FXML
    private ChoiceBox<String> RecipeCheck;
        @FXML
        private TextField portionTextField;

        @FXML
        public void initialize (){
            ObservableList<String> recipeName = FXCollections.observableArrayList(database.getRecipesName(recipeDB));
            RecipeCheck.setItems(recipeName);
    }
    @FXML
    public void addRecipeButtonClick(){
        String recipeName = String.valueOf(RecipeCheck.getValue());
        String portion = portionTextField.getText();

        wd.addRecipe(recipeName, Integer.parseInt(portion), recipeDB);

        portionTextField.clear();
    }
    @FXML
    public void addNewRecipeBtnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddNewRecipeView.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void seeShopListBtnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ShopListView.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
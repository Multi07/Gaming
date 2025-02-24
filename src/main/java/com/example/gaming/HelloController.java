package com.example.gaming;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private ListView<Player> Players = new ListView<Player>();
    @FXML
    private TextField name;
    @FXML
    private TextField level;
    @FXML
    private TextField playerClass;
    @FXML
    private TextField email;
    @FXML
    private TextField registrationDate;

    @FXML
    private void CreatePlayer() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("CreatePlayer.fxml"));
        GridPane form = loader.load();
        PlayerFormController controller = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Create Player");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(new Scene(form));
        dialogStage.showAndWait();
        Player player =
        if (player != null) {
            Players.getItems().add(player);
        }
    }

    @FXML
    private void DeletePlayer(){
        Players.getItems().remove(Players.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void EditPlayer(){
        String newName = "";
        int newLevel = 0;
        String newPlayerClass = "";
        String newEmail = "";
        String newRegistrationDate = "";

        int index = Players.getSelectionModel().getSelectedIndex();

        if (name.getText().isEmpty()){
            newName = Players.getSelectionModel().getSelectedItem().name;
        }
        else { newName = name.getText(); }

        if (level.getText().isEmpty()){
            newLevel = Players.getSelectionModel().getSelectedItem().level;
        }
        else { newLevel = Integer.parseInt(level.getText()); }

        if (playerClass.getText().isEmpty()){
            newPlayerClass = Players.getSelectionModel().getSelectedItem().playerClass;
        }
        else { newPlayerClass = playerClass.getText(); }

        if (email.getText().isEmpty()){
            newEmail = Players.getSelectionModel().getSelectedItem().email;
        }
        else { newEmail = email.getText(); }

        if (registrationDate.getText().isEmpty()){
            newRegistrationDate = Players.getSelectionModel().getSelectedItem().registrationDate;
        }
        else { newRegistrationDate = registrationDate.getText(); }

        Players.getItems().set(index, new Player(newName, newLevel, newPlayerClass, newEmail, newRegistrationDate));
    }
    @FXML
    private void ShowPlayer(){
        // TODO: Implement this
    }

    private void makeMockData(){
        for (int i = 0; i < 5; i++) {
            Players.getItems().add(new Player(i+"name", i, i+"class", i+"@"+i+".cz", "2021.03.04"));
            Players.refresh();
        }
    }
    public void initialize(){
        Players.getItems().add(new Player("Kaiy", 100,"Mág", "jibladfgjknb@seznam"+".cz", "2021.03.04"));
        Players.getItems().add(new Player("Karel", 10,"Bojovník", "oikjadfgjio@email"+".cz", "2021.08.04"));
        Players.getItems().add(new Player("iojmpfrg", 1,"Střelec", "dsgh@"+"ihdg.cz", "2024.03.04"));

    }
}
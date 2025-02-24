package com.example.gaming;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    private void CreatePlayer(){
        Player player = new Player(
                this.name.getText(),
                (int) Double.parseDouble(
                        this.level
                                .getText()
                                .replaceAll(",", ".")
                                .replaceAll(" ", "")
                ),
                this.playerClass.getText(),
                this.email.getText(),
                this.registrationDate.getText());

        this.Players.getItems().add(player);
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
        Players.getSelectionModel().getSelectedItem().email = this.email.getText();
    }

    private void makeMockData(){
        for (int i = 0; i < 5; i++) {
            Players.getItems().add(new Player(i+"name", i, i+"class", i+"@"+i+".cz", "2021.03.04"));
            Players.refresh();
        }
    }
    public void initialize(){
            Players.getItems().add(new Player("name", 1,"class", "@"+".cz", "2021.03.04"));

    }
}
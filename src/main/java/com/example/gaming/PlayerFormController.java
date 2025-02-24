package com.example.gaming;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PlayerFormController {
    @FXML
    private TextField name;
    @FXML
    private TextField level;

    public Player getPlayer() {
        return player;
    }

    @FXML
    private RadioButton playerClass;
    @FXML
    private TextField email;
    @FXML
    private DatePicker registrationDate;
    @FXML
    private Player player;
    private Spinner<Integer> levelSpinner;

    private void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
        levelSpinner.setValueFactory(valueFactory);
    }

    public void createplayer() {
        this.player = new Player(this.name.getText(),
                (int) Double.parseDouble(
                        this.level
                                .getText()
                                .replaceAll(",", ".")
                                .replaceAll(" ", "")
                ),
                this.playerClass.getText(),
                this.email.getText(),
                this.registrationDate.toString());
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



}

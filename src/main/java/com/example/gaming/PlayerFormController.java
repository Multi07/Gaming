package com.example.gaming;

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
    private RadioButton Bojovnik;
    @FXML
    private RadioButton Mage;
    @FXML
    private RadioButton Archer;
    @FXML
    private TextField email;
    @FXML
    private DatePicker registrationDate;
    private String playerClass;
    @FXML
    private Player player;
    @FXML
    private Spinner<Integer> levelSpinner;

    private void initialize() {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
        levelSpinner.setValueFactory(valueFactory);
    }

    public void createplayer() {
        if (Bojovnik.isSelected()) {
            playerClass = "Bojovnik";
        }
        else if (Mage.isSelected()) {
            playerClass = "Mág";
        }
        else if (Archer.isSelected()) {
            playerClass = "Střelec";
        }
        this.player = new Player(
                this.name.getText(),
                Integer.parseInt(
                    this.levelSpinner.getValue().toString()
                ),
                this.Bojovnik.getText(),
                this.email.getText(),
                this.registrationDate.getValue()
        );
    }

    /*


*/



}

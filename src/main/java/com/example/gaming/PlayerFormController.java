package com.example.gaming;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PlayerFormController {
    boolean isEditMode;
    @FXML
    private TextField name;
    @FXML
    private TextField level;

    public Player getPlayer() {
        return player;
    }
    @FXML
    ToggleGroup roleToggleGroup;

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
        if (name.getText().isEmpty()|| email.getText().isEmpty()||registrationDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }
        RadioButton selectedRole = (RadioButton) roleToggleGroup.getSelectedToggle();
        if (isEditMode) {
            player.setPlayerClass(selectedRole.getText());
            player.setEmail(email.getText());
            player.setRegistrationDate(registrationDate.getValue());
            player.setLevel(Integer.parseInt(levelSpinner.getValue().toString()));
            player.setName(name.getText());
            selectedRole = null;
            for (Toggle toggle : roleToggleGroup.getToggles()) {
                if (((RadioButton) toggle).getText().equals(player.getPlayerClass())) {
                    selectedRole = (RadioButton) toggle;
                    break;
                }
            }
            if (selectedRole != null) {
                selectedRole.setSelected(true);
            }
        } else {
            this.player = new Player(name.getText(), Integer.parseInt(levelSpinner.getValue().toString()), selectedRole.getText(), email.getText(), registrationDate.getValue());
        }
        onCancel();
    }
    public void onCancel() {
        Stage stage = (Stage) name.getScene().getWindow();
        stage.close();
    }

    public void setEditMode(boolean editMode) {
        isEditMode = editMode;
    }

    public void setPlayer(Player player) {
        this.player = player;
        if (isEditMode) {
            name.setText(player.getName());
            levelSpinner.getValueFactory().setValue(player.getLevel());
            RadioButton selectedRole = null;
            for (Toggle toggle : roleToggleGroup.getToggles()) {
                if (((RadioButton)  toggle).getText().equals(player.getPlayerClass())) {
                    selectedRole = (RadioButton) toggle;
                    break;
                }
            }
            if (selectedRole != null) {
                selectedRole.setSelected(true);
            }
            email.setText(player.getEmail());
            registrationDate.setValue(player.getRegistrationDate());
        }
    }
}

package com.example.gaming;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PlayerFormController {
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
            this.registrationDate.getText()
    );

}

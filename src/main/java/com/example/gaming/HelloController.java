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
    private void CreatePlayer() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AddPlayer.fxml"));
        GridPane form = loader.load();
        PlayerFormController controller = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Create Player");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(new Scene(form));
        dialogStage.showAndWait();
        Player player = controller.getPlayer();
        if (player != null) {
            Players.getItems().add(player);
        }
    }

    @FXML
    private void DeletePlayer(){
        Players.getItems().remove(Players.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void ShowPlayer(){
        // TODO: Implement this
    }

    public void initialize(){
        Players.getItems().add(new Player("Kaiy", 100,"Mág", "jibladfgjknb@"+"seznam.cz", "2021.03.04"));
        Players.getItems().add(new Player("Karel", 10,"Bojovník", "oikjadfgjio@"+"email.cz", "2021.08.04"));
        Players.getItems().add(new Player("iojmpfrg", 1,"Střelec", "dsgh@"+"ihdg.cz", "2024.03.04"));

    }
}
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
import java.time.LocalDate;

public class HelloController {
    @FXML
    private ListView<Player> Players = new ListView<Player>();
    LocalDate date = LocalDate.of(2020, 1, 8);
    LocalDate date2 = LocalDate.of(2021, 8, 4);
    LocalDate date3 = LocalDate.of(2020, 3, 4);

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
        Player newplayer = controller.getPlayer();
        if (newplayer != null) {
            Players.getItems().add(newplayer);
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
    @FXML
    private void EditPlayer() throws IOException {
        String newName = "";
        int newLevel = 0;
        String newPlayerClass = "";
        String newEmail = "";
        String newRegistrationDate = "";
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AddPlayer.fxml"));
        GridPane form = loader.load();
        PlayerFormController controller = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Player");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(new Scene(form));
        dialogStage.showAndWait();
        Player newplayer = controller.getPlayer();
        if (newplayer != null) {
            Players.getItems().add(newplayer);
        }


    }

    public void initialize(){
        Players.getItems().add(new Player("Kaiy", 100,"Mág", "jibladfgjknb@"+"seznam.cz", date3));
        Players.getItems().add(new Player("Karel", 10,"Bojovník", "oikjadfgjio@"+"email.cz", date2));
        Players.getItems().add(new Player("iojmpfrg", 1,"Střelec", "dsgh@"+"ihdg.cz", date));

    }
}
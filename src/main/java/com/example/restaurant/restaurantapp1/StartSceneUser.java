package com.example.restaurant.restaurantapp1;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class StartSceneUser {
    final String nameFile = "start_scene_user.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEntr;

    @FXML
    private Button btnReg;

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public void toEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entry_user.fxml")));
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public void toReg(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user_registration.fxml")));
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }
}

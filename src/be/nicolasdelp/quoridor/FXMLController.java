package be.nicolasdelp.quoridor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FXMLController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button resumeGameButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button optionButton;

    @FXML
    private Button creditsButton;

    @FXML
    void resumeGame(ActionEvent event) {
        System.out.println("Action resumeGame");
    }

    @FXML
    void newGame(ActionEvent event) {
        System.out.println("Action newgame");
    }

    @FXML
    void option(ActionEvent event) {
        System.out.println("Action options");
    }

    @FXML
    void credits(ActionEvent event) {
        System.out.println("Action credits");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
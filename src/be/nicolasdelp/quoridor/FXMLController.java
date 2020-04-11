package be.nicolasdelp.quoridor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class FXMLController implements Initializable{

    @FXML
    private ResourceBundle resources;
    private URL location;
    private Pane menuPane;
    private Button resumeGameButton;
    private Button newGameButton;
    private Button optionButton;
    private Button creditsButton;
    private Pane newGamePane;
    private TabPane tabPlayers;
    private Button startGameButton;
    private ChoiceBox<?> numberOfPlayers;

    @FXML
    void credits(ActionEvent event) {
        System.out.println("Coucou");
    }

    @FXML
    void newGame(ActionEvent event) {

    }

    @FXML
    void option(ActionEvent event) {

    }

    @FXML
    void resumeGame(ActionEvent event) {

    }

    @FXML
    void startGame(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
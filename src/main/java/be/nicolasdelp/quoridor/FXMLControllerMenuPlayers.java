package be.nicolasdelp.quoridor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;

public class FXMLControllerMenuPlayers implements Initializable {

    ObservableList<String> typeOfPlayer = FXCollections.observableArrayList("Humain", "Ordinateur");
    ObservableList<String> colorOfPlayer = FXCollections.observableArrayList("Vert", "Rouge", "Jaune", "Bleu");

    @FXML
    private CheckBox twoPlayersCheckbox;

    @FXML
    private CheckBox fourPlayersCheckbox;

    @FXML
    private Pane pane2Players;

    @FXML
    private Pane pane4Players;

    @FXML
    private ChoiceBox typePlayer12;

    @FXML
    private ChoiceBox colorPlayer12;

    @FXML
    private ChoiceBox typePlayer22;

    @FXML
    private ChoiceBox colorPlayer22;

    @FXML
    private ChoiceBox typePlayer14;

    @FXML
    private ChoiceBox colorPlayer14;

    @FXML
    private ChoiceBox typePlayer24;

    @FXML
    private ChoiceBox colorPlayer24;

    @FXML
    private ChoiceBox typePlayer34;

    @FXML
    private ChoiceBox colorPlayer34;

    @FXML
    private ChoiceBox typePlayer44;

    @FXML
    private ChoiceBox colorPlayer44;

    @FXML
    void twoPlayersCheckboxCheck(ActionEvent event) {
        if(twoPlayersCheckbox.isSelected()){
            pane2Players.setVisible(true);
            fourPlayersCheckbox.setSelected(false);
            pane4Players.setVisible(false);
        }
        if(!twoPlayersCheckbox.isSelected()){
            pane2Players.setVisible(false);
            pane4Players.setVisible(true);
            fourPlayersCheckbox.setSelected(true);
        }
    }

    @FXML
    void fourPlayersCheckboxCheck(ActionEvent event) {
        if(fourPlayersCheckbox.isSelected()){
            pane4Players.setVisible(true);
            twoPlayersCheckbox.setSelected(false);
            pane2Players.setVisible(false);
        }
        if(!fourPlayersCheckbox.isSelected()){
            pane4Players.setVisible(false);
            pane2Players.setVisible(true);
            twoPlayersCheckbox.setSelected(true);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        twoPlayersCheckbox.setAllowIndeterminate(false);
        twoPlayersCheckbox.setSelected(true);
        pane2Players.setVisible(true);
        fourPlayersCheckbox.setAllowIndeterminate(false);
        fourPlayersCheckbox.setSelected(false);
        pane4Players.setVisible(false);
        typePlayer12.setValue("Humain");
        typePlayer12.setItems(typeOfPlayer);
        typePlayer22.setValue("Humain");
        typePlayer22.setItems(typeOfPlayer);
        typePlayer14.setValue("Humain");
        typePlayer14.setItems(typeOfPlayer);
        typePlayer24.setValue("Humain");
        typePlayer24.setItems(typeOfPlayer);
        typePlayer34.setValue("Humain");
        typePlayer34.setItems(typeOfPlayer);
        typePlayer44.setValue("Humain");
        typePlayer44.setItems(typeOfPlayer);
        colorPlayer12.setItems(colorOfPlayer);
        colorPlayer22.setItems(colorOfPlayer);
        colorPlayer14.setItems(colorOfPlayer);
        colorPlayer24.setItems(colorOfPlayer);
        colorPlayer34.setItems(colorOfPlayer);
        colorPlayer44.setItems(colorOfPlayer);
    }
}
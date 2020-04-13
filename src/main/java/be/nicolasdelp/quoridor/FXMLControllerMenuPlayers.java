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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
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
    private ChoiceBox typePlayer12;

    @FXML
    private ChoiceBox colorPlayer12;

    @FXML
    private TextField pseudoOfPlayer12;

    @FXML
    private Label labelIALevel12;

    @FXML
    private ChoiceBox levelIAPlayer12;

    @FXML
    private ChoiceBox typePlayer22;

    @FXML
    private ChoiceBox colorPlayer22;

    @FXML
    private TextField pseudoOfPlayer22;

    @FXML
    private Label labelIALevel22;

    @FXML
    private ChoiceBox levelIAPlayer22;

    @FXML
    private Pane pane4Players;

    @FXML
    private ChoiceBox typePlayer14;

    @FXML
    private ChoiceBox colorPlayer14;

    @FXML
    private TextField pseudoOfPlayer14;

    @FXML
    private Label labelIALevel14;

    @FXML
    private ChoiceBox levelIAPlayer14;

    @FXML
    private ChoiceBox typePlayer24;

    @FXML
    private ChoiceBox colorPlayer24;

    @FXML
    private TextField pseudoOfPlayer24;

    @FXML
    private Label labelIALevel24;

    @FXML
    private ChoiceBox levelIAPlayer24;

    @FXML
    private ChoiceBox typePlayer34;

    @FXML
    private ChoiceBox colorPlayer34;

    @FXML
    private TextField pseudoOfPlayer34;

    @FXML
    private Label labelIALevel34;

    @FXML
    private ChoiceBox levelIAPlayer34;

    @FXML
    private ChoiceBox typePlayer44;

    @FXML
    private ChoiceBox colorPlayer44;

    @FXML
    private TextField pseudoOfPlayer44;

    @FXML
    private Label labelIALevel44;

    @FXML
    private ChoiceBox levelIAPlayer44;

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

    @FXML
    void visibleIAChoice(MouseEvent event) {
        if(typePlayer12.getValue() == "Ordinateur"){
            levelIAPlayer12.setDisable(false);
            labelIALevel12.setDisable(false);
        }else{
            levelIAPlayer12.setDisable(true);
            labelIALevel12.setDisable(true);
        }
        if(typePlayer22.getValue() == "Ordinateur"){
            levelIAPlayer22.setDisable(false);
            labelIALevel22.setDisable(false);
        }else{
            levelIAPlayer22.setDisable(true);
            labelIALevel22.setDisable(true);
        }
        if(typePlayer14.getValue() == "Ordinateur"){
            levelIAPlayer14.setDisable(false);
            labelIALevel14.setDisable(false);
        }else{
            levelIAPlayer14.setDisable(true);
            labelIALevel14.setDisable(true);
        }
        if(typePlayer24.getValue() == "Ordinateur"){
            levelIAPlayer24.setDisable(false);
            labelIALevel24.setDisable(false);
        }else{
            levelIAPlayer24.setDisable(true);
            labelIALevel24.setDisable(true);
        }
        if(typePlayer34.getValue() == "Ordinateur"){
            levelIAPlayer34.setDisable(false);
            labelIALevel34.setDisable(false);
        }else{
            levelIAPlayer34.setDisable(true);
            labelIALevel34.setDisable(true);
        }
        if(typePlayer44.getValue() == "Ordinateur"){
            levelIAPlayer44.setDisable(false);
            labelIALevel44.setDisable(false);
        }else{
            levelIAPlayer44.setDisable(true);
            labelIALevel44.setDisable(true);
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
        typePlayer12.setItems(typeOfPlayer);
        typePlayer22.setItems(typeOfPlayer);
        typePlayer14.setItems(typeOfPlayer);
        typePlayer24.setItems(typeOfPlayer);
        typePlayer34.setItems(typeOfPlayer);
        typePlayer44.setItems(typeOfPlayer);
        colorPlayer12.setItems(colorOfPlayer);
        colorPlayer22.setItems(colorOfPlayer);
        colorPlayer14.setItems(colorOfPlayer);
        colorPlayer24.setItems(colorOfPlayer);
        colorPlayer34.setItems(colorOfPlayer);
        colorPlayer44.setItems(colorOfPlayer);
    }
}
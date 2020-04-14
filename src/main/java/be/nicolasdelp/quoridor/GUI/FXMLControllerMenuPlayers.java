package be.nicolasdelp.quoridor.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLControllerMenuPlayers implements Initializable {

    ObservableList<String> typeOfPlayer = FXCollections.observableArrayList("Humain", "Ordinateur");
    ObservableList<String> colorOfPlayer = FXCollections.observableArrayList("Vert", "Rouge", "Jaune", "Bleu");
    ObservableList<String> levelOfIA = FXCollections.observableArrayList("Facile", "Moyen", "Difficile");

    @FXML
    private CheckBox twoPlayersCheckbox;

    @FXML
    private CheckBox fourPlayersCheckbox;

    @FXML
    private Pane pane2Players;

    @FXML
    private ChoiceBox<String> typePlayer12;

    @FXML
    private ChoiceBox<String> colorPlayer12;

    @FXML
    private TextField pseudoOfPlayer12;

    @FXML
    private Label labelIALevel12;

    @FXML
    private ChoiceBox<String> levelIAPlayer12;

    @FXML
    private ChoiceBox<String> typePlayer22;

    @FXML
    private ChoiceBox<String> colorPlayer22;

    @FXML
    private TextField pseudoOfPlayer22;

    @FXML
    private Label labelIALevel22;

    @FXML
    private ChoiceBox<String> levelIAPlayer22;

    @FXML
    private Pane pane4Players;

    @FXML
    private ChoiceBox<String> typePlayer14;

    @FXML
    private ChoiceBox<String> colorPlayer14;

    @FXML
    private TextField pseudoOfPlayer14;

    @FXML
    private Label labelIALevel14;

    @FXML
    private ChoiceBox<String> levelIAPlayer14;

    @FXML
    private ChoiceBox<String> typePlayer24;

    @FXML
    private ChoiceBox<String> colorPlayer24;

    @FXML
    private TextField pseudoOfPlayer24;

    @FXML
    private Label labelIALevel24;

    @FXML
    private ChoiceBox<String> levelIAPlayer24;

    @FXML
    private ChoiceBox<String> typePlayer34;

    @FXML
    private ChoiceBox<String> colorPlayer34;

    @FXML
    private TextField pseudoOfPlayer34;

    @FXML
    private Label labelIALevel34;

    @FXML
    private ChoiceBox<String> levelIAPlayer34;

    @FXML
    private ChoiceBox<String> typePlayer44;

    @FXML
    private ChoiceBox<String> colorPlayer44;

    @FXML
    private TextField pseudoOfPlayer44;

    @FXML
    private Label labelIALevel44;

    @FXML
    private ChoiceBox<String> levelIAPlayer44;

    @FXML
    private Button startGame;
    
    @FXML
    private ImageView goBack;

    @FXML
    void goBackClicked(MouseEvent event) {
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("fxml/quoridorMenu.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 650, 400));
            secondStage.setResizable(false);
            secondStage.setTitle("QUORIDOR");
            secondStage.centerOnScreen();
            pane2Players.getScene().getWindow().hide();
            secondStage.show();
        } catch(Exception exception){
            System.out.println("Il y a eu un problème !");
        }
    }

    @FXML
    void twoPlayersCheckboxCheck(ActionEvent event) {
        if (twoPlayersCheckbox.isSelected()) {
            pane2Players.setVisible(true);
            fourPlayersCheckbox.setSelected(false);
            pane4Players.setVisible(false);
        }
        if (!twoPlayersCheckbox.isSelected()) {
            pane2Players.setVisible(false);
            pane4Players.setVisible(true);
            fourPlayersCheckbox.setSelected(true);
        }
    }

    @FXML
    void fourPlayersCheckboxCheck(ActionEvent event) {
        if (fourPlayersCheckbox.isSelected()) {
            pane4Players.setVisible(true);
            twoPlayersCheckbox.setSelected(false);
            pane2Players.setVisible(false);
        }
        if (!fourPlayersCheckbox.isSelected()) {
            pane4Players.setVisible(false);
            pane2Players.setVisible(true);
            twoPlayersCheckbox.setSelected(true);
        }
    }

    @FXML
    void visibleIAChoice(MouseEvent event) {
        if (typePlayer12.getValue() == "Ordinateur") {
            levelIAPlayer12.setDisable(false);
            labelIALevel12.setDisable(false);
            pseudoOfPlayer12.setText("Ordinateur");
            pseudoOfPlayer12.setEditable(false);
        } else {
            levelIAPlayer12.setDisable(true);
            labelIALevel12.setDisable(true);
            pseudoOfPlayer12.setText("Joueur 1");
            pseudoOfPlayer12.setEditable(true);
        }
        if (typePlayer22.getValue() == "Ordinateur") {
            levelIAPlayer22.setDisable(false);
            labelIALevel22.setDisable(false);
            pseudoOfPlayer22.setText("Ordinateur");
            pseudoOfPlayer22.setEditable(false);
        } else {
            levelIAPlayer22.setDisable(true);
            labelIALevel22.setDisable(true);
            pseudoOfPlayer22.setText("Joueur 2");
            pseudoOfPlayer22.setEditable(true);
        }
        if (typePlayer14.getValue() == "Ordinateur") {
            levelIAPlayer14.setDisable(false);
            labelIALevel14.setDisable(false);
            pseudoOfPlayer14.setText("Ordinateur");
            pseudoOfPlayer14.setEditable(false);
        } else {
            levelIAPlayer14.setDisable(true);
            labelIALevel14.setDisable(true);
            pseudoOfPlayer14.setText("Joueur 1");
            pseudoOfPlayer14.setEditable(true);
        }
        if (typePlayer24.getValue() == "Ordinateur") {
            levelIAPlayer24.setDisable(false);
            labelIALevel24.setDisable(false);
            pseudoOfPlayer24.setText("Ordinateur");
            pseudoOfPlayer24.setEditable(false);
        } else {
            levelIAPlayer24.setDisable(true);
            labelIALevel24.setDisable(true);
            pseudoOfPlayer24.setText("Joueur 2");
            pseudoOfPlayer24.setEditable(true);
        }
        if (typePlayer34.getValue() == "Ordinateur") {
            levelIAPlayer34.setDisable(false);
            labelIALevel34.setDisable(false);
            pseudoOfPlayer34.setText("Ordinateur");
            pseudoOfPlayer34.setEditable(false);
        } else {
            levelIAPlayer34.setDisable(true);
            labelIALevel34.setDisable(true);
            pseudoOfPlayer34.setText("Joueur 3");
            pseudoOfPlayer34.setEditable(true);
        }
        if (typePlayer44.getValue() == "Ordinateur") {
            levelIAPlayer44.setDisable(false);
            labelIALevel44.setDisable(false);
            pseudoOfPlayer44.setText("Ordinateur");
            pseudoOfPlayer44.setEditable(false);
        } else {
            levelIAPlayer44.setDisable(true);
            labelIALevel44.setDisable(true);
            pseudoOfPlayer44.setText("Joueur 4");
            pseudoOfPlayer44.setEditable(true);
        }
        if (twoPlayersCheckbox.isSelected()) {
            allIsOK2Players();
        }
        if (fourPlayersCheckbox.isSelected()) {
            allIsOK4Players();
        }
    }

    private void allIsOK2Players() {
        if (((typePlayer12.getValue() != null) && (colorPlayer12.getValue() != null) && (pseudoOfPlayer12.getText() != null))
                && ((typePlayer22.getValue() != null) && (colorPlayer22.getValue() != null) && (pseudoOfPlayer22.getText() != null))) {
            if ((((typePlayer12.getValue() == "Ordinateur") && (levelIAPlayer12.getValue() != null)) || (typePlayer12.getValue() == "Humain"))
                    && (((typePlayer22.getValue() == "Ordinateur") && (levelIAPlayer22.getValue() != null)) || (typePlayer22.getValue() == "Humain"))) {
                startGame.setDisable(false);
            } else{startGame.setDisable(true);}
        } else{startGame.setDisable(true);}
    }

    private void allIsOK4Players() {
        if (((typePlayer14.getValue() != null) && (colorPlayer14.getValue() != null) && (pseudoOfPlayer14.getText() != null))
                && ((typePlayer24.getValue() != null) && (colorPlayer24.getValue() != null) && (pseudoOfPlayer24.getText() != null))
                && ((typePlayer34.getValue() != null) && (colorPlayer34.getValue() != null) && (pseudoOfPlayer34.getText() != null))
                && ((typePlayer44.getValue() != null) && (colorPlayer44.getValue() != null) && (pseudoOfPlayer44.getText() != null))) {
            if ((((typePlayer14.getValue() == "Ordinateur") && (levelIAPlayer14.getValue() != null)) || (typePlayer12.getValue() == "Humain"))
                    && (((typePlayer24.getValue() == "Ordinateur") && (levelIAPlayer24.getValue() != null)) || (typePlayer24.getValue() == "Humain"))
                    && (((typePlayer34.getValue() == "Ordinateur") && (levelIAPlayer34.getValue() != null)) || (typePlayer34.getValue() == "Humain"))
                    && (((typePlayer44.getValue() == "Ordinateur") && (levelIAPlayer44.getValue() != null)) || (typePlayer44.getValue() == "Humain"))) {
                startGame.setDisable(false);
            }else{startGame.setDisable(true);}
        }else{startGame.setDisable(true);}
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
        typePlayer12.setValue("Humain");
        typePlayer22.setValue("Humain");
        typePlayer14.setValue("Humain");
        typePlayer24.setValue("Humain");
        typePlayer34.setValue("Humain");
        typePlayer44.setValue("Humain");
        colorPlayer12.setItems(colorOfPlayer);
        colorPlayer22.setItems(colorOfPlayer);
        colorPlayer14.setItems(colorOfPlayer);
        colorPlayer24.setItems(colorOfPlayer);
        colorPlayer34.setItems(colorOfPlayer);
        colorPlayer44.setItems(colorOfPlayer);
        colorPlayer12.setValue("Bleu");
        colorPlayer22.setValue("Rouge");
        colorPlayer14.setValue("Bleu");
        colorPlayer24.setValue("Rouge");
        colorPlayer34.setValue("Jaune");
        colorPlayer44.setValue("Vert");
        levelIAPlayer12.setItems(levelOfIA);
        levelIAPlayer22.setItems(levelOfIA);
        levelIAPlayer14.setItems(levelOfIA);
        levelIAPlayer24.setItems(levelOfIA);
        levelIAPlayer34.setItems(levelOfIA);
        levelIAPlayer44.setItems(levelOfIA);
        levelIAPlayer12.setValue("Facile");
        levelIAPlayer22.setValue("Facile");
        levelIAPlayer14.setValue("Facile");
        levelIAPlayer24.setValue("Facile");
        levelIAPlayer34.setValue("Facile");
        levelIAPlayer44.setValue("Facile");
        pseudoOfPlayer12.setText("Joueur 1");
        pseudoOfPlayer22.setText("Joueur 2");
        pseudoOfPlayer14.setText("Joueur 1");
        pseudoOfPlayer24.setText("Joueur 2");
        pseudoOfPlayer34.setText("Joueur 3");
        pseudoOfPlayer44.setText("Joueur 4");
    }

    @FXML
    void startGameClicked(MouseEvent event) {
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("fxml/quoridorBoard.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 1500, 1000));
            secondStage.setResizable(false);
            secondStage.setTitle("QUORIDOR");
            secondStage.centerOnScreen();
            pane2Players.getScene().getWindow().hide();
            secondStage.show();
        } catch(Exception exception){
            System.out.println("Il y a eu un problème !");
        }
    }
}
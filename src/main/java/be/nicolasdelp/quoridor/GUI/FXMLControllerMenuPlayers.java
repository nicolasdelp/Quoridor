package be.nicolasdelp.quoridor.gui;

import java.net.URL;
import java.util.ResourceBundle;

import be.nicolasdelp.quoridor.objects.*;
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

    @FXML
    private Pane pane2Players, pane4Players;

    @FXML
    private CheckBox twoPlayersCheckbox, fourPlayersCheckbox;

    @FXML
    private ChoiceBox<String> typePlayer12, colorPlayer12, levelIAPlayer12, typePlayer22, colorPlayer22, levelIAPlayer22, typePlayer14, colorPlayer14, levelIAPlayer14, 
                                typePlayer24, colorPlayer24, levelIAPlayer24, typePlayer34, colorPlayer34, levelIAPlayer34, typePlayer44, colorPlayer44, levelIAPlayer44;

    @FXML
    private TextField pseudoOfPlayer12, pseudoOfPlayer22, pseudoOfPlayer14, pseudoOfPlayer24, pseudoOfPlayer34, pseudoOfPlayer44;

    @FXML
    private Label labelIALevel12, labelIALevel22, labelIALevel14, labelIALevel24, labelIALevel34, labelIALevel44;

    @FXML
    private Button startGame;
    
    @FXML
    private ImageView goBack;

    private final ObservableList<String> typeOfPlayer = FXCollections.observableArrayList("Humain", "Ordinateur");
    private final ObservableList<String> colorOfPlayer = FXCollections.observableArrayList("Vert", "Rouge", "Jaune", "Bleu");
    private final ObservableList<String> levelOfIA = FXCollections.observableArrayList("Facile", "Moyen", "Difficile");

    private static Board board; //Le plateau
    /**
     * Initialise les composant avant l'ouverture de la fenetre
     *
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        twoPlayersCheckbox.setAllowIndeterminate(false);
        fourPlayersCheckbox.setAllowIndeterminate(false);
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
        levelIAPlayer12.setItems(levelOfIA);
        levelIAPlayer22.setItems(levelOfIA);
        levelIAPlayer14.setItems(levelOfIA);
        levelIAPlayer24.setItems(levelOfIA);
        levelIAPlayer34.setItems(levelOfIA);
        levelIAPlayer44.setItems(levelOfIA);
    }

    /**
     * Boutton de retour au menu
     *
     */
    @FXML
    void goBackClicked(MouseEvent event) {
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorMenu.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 650, 400));
            secondStage.setResizable(false);
            secondStage.setTitle("QUORIDOR");
            secondStage.centerOnScreen();
            pane2Players.getScene().getWindow().hide();
            secondStage.show();
        } catch(Exception exception){
            System.out.println(exception);
        }
    }

    /**
     * Gestion des checkbox pour 2 joueurs
     *
     */
    @FXML
    void twoPlayersCheckboxCheck(ActionEvent event) {
        if (twoPlayersCheckbox.isSelected()) {
            pane2Players.setVisible(true);
            pane4Players.setVisible(false);
            fourPlayersCheckbox.setSelected(false);
        }
        if (!twoPlayersCheckbox.isSelected()) {
            pane2Players.setVisible(false);
            pane4Players.setVisible(true);
            fourPlayersCheckbox.setSelected(true);
        }
    }
    
    /**
     * Gestion des checkbox pour 4 joueurs
     *
     */
    @FXML
    void fourPlayersCheckboxCheck(ActionEvent event) {
        if (fourPlayersCheckbox.isSelected()) {
            pane4Players.setVisible(true);
            pane2Players.setVisible(false);
            twoPlayersCheckbox.setSelected(false);
        }
        if (!fourPlayersCheckbox.isSelected()) {
            pane4Players.setVisible(false);
            pane2Players.setVisible(true);
            twoPlayersCheckbox.setSelected(true);
        }
    }

    /**
     * Gestion des mode de jeux 2 ou 4 joueurs (fonctionne quand on bouge la souris sur la fenetre)
     *
     */
    @FXML
    void visibleIAChoice(MouseEvent event) {
        if (typePlayer12.getValue() == "Ordinateur") {
            levelIAPlayer12.setVisible(true);
            labelIALevel12.setVisible(true);
            pseudoOfPlayer12.setText("Ordinateur");
            pseudoOfPlayer12.setEditable(false);
        } else if (typePlayer12.getValue() == "Humain") {
            levelIAPlayer12.setVisible(false);
            labelIALevel12.setVisible(false);
            pseudoOfPlayer12.setEditable(true);
        }
        if (typePlayer22.getValue() == "Ordinateur") {
            levelIAPlayer22.setVisible(true);
            labelIALevel22.setVisible(true);
            pseudoOfPlayer22.setText("Ordinateur");
            pseudoOfPlayer22.setEditable(false);
        } else if (typePlayer22.getValue() == "Humain") {
            levelIAPlayer22.setVisible(false);
            labelIALevel22.setVisible(false);
            pseudoOfPlayer22.setEditable(true);
        }
        if (typePlayer14.getValue() == "Ordinateur") {
            levelIAPlayer14.setVisible(true);
            labelIALevel14.setVisible(true);
            pseudoOfPlayer14.setText("Ordinateur");
            pseudoOfPlayer14.setEditable(false);
        } else if (typePlayer14.getValue() == "Humain") {
            levelIAPlayer14.setVisible(false);
            labelIALevel14.setVisible(false);
            pseudoOfPlayer14.setEditable(true);
        }
        if (typePlayer24.getValue() == "Ordinateur") {
            levelIAPlayer24.setVisible(true);
            labelIALevel24.setVisible(true);
            pseudoOfPlayer24.setText("Ordinateur");
            pseudoOfPlayer24.setEditable(false);
        } else if (typePlayer24.getValue() == "Humain") {
            levelIAPlayer24.setVisible(false);
            labelIALevel24.setVisible(false);
            pseudoOfPlayer24.setEditable(true);
        }
        if (typePlayer34.getValue() == "Ordinateur") {
            levelIAPlayer34.setVisible(true);
            labelIALevel34.setVisible(true);
            pseudoOfPlayer34.setText("Ordinateur");
            pseudoOfPlayer34.setEditable(false);
        } else if (typePlayer34.getValue() == "Humain") {
            levelIAPlayer34.setVisible(false);
            labelIALevel34.setVisible(false);
            pseudoOfPlayer34.setEditable(true);
        }
        if (typePlayer44.getValue() == "Ordinateur") {
            levelIAPlayer44.setVisible(true);
            labelIALevel44.setVisible(true);
            pseudoOfPlayer44.setText("Ordinateur");
            pseudoOfPlayer44.setEditable(false);
        } else if (typePlayer44.getValue() == "Humain") {
            levelIAPlayer44.setVisible(false);
            labelIALevel44.setVisible(false);
            pseudoOfPlayer44.setEditable(true);
        }
        if (twoPlayersCheckbox.isSelected()) {
            if(allIsOKPlayers12() && allIsOKPlayers22()){ //On vérifie que tout les champs sont remplis
                startGame.setDisable(false);
            } else {
                startGame.setDisable(true);
            }
        }
        if (fourPlayersCheckbox.isSelected()) {
            if (allIsOKPlayers14() && allIsOKPlayers24() && allIsOKPlayers34() && allIsOKPlayers44()){ //On vérifie que tout les champs sont remplis
                startGame.setDisable(false);
            } else {
                startGame.setDisable(true);
            }
        }
    }

    /**
     * Vérification que tout les champs du joueur 1 sont remplis
     *
     */
    private boolean allIsOKPlayers12() {
        if(typePlayer12.getValue() == "Ordinateur" && colorPlayer12.getValue() != null && !pseudoOfPlayer12.getText().isEmpty() && levelIAPlayer12.getValue() != null){
            return true;
        }
        if(typePlayer12.getValue() == "Humain" && colorPlayer12.getValue() != null && !pseudoOfPlayer12.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérification que tout les champs du joueur 2 sont remplis
     *
     */
    private boolean allIsOKPlayers22() {
        if(typePlayer22.getValue() == "Ordinateur" && colorPlayer22.getValue() != null && !pseudoOfPlayer22.getText().isEmpty() && levelIAPlayer22.getValue() != null){
            return true;
        }
        if(typePlayer22.getValue() == "Humain" && colorPlayer22.getValue() != null && !pseudoOfPlayer22.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérification que tout les champs du joueur 1 sont remplis
     *
     */
    private boolean allIsOKPlayers14() {
        if(typePlayer14.getValue() == "Ordinateur" && colorPlayer14.getValue() != null && !pseudoOfPlayer14.getText().isEmpty() && levelIAPlayer14.getValue() != null){
            return true;
        }
        if(typePlayer14.getValue() == "Humain" && colorPlayer14.getValue() != null && !pseudoOfPlayer14.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérification que tout les champs du joueur 2 sont remplis
     *
     */
    private boolean allIsOKPlayers24() {
        if(typePlayer24.getValue() == "Ordinateur" && colorPlayer24.getValue() != null && !pseudoOfPlayer24.getText().isEmpty() && levelIAPlayer24.getValue() != null){
            return true;
        }
        if(typePlayer24.getValue() == "Humain" && colorPlayer24.getValue() != null && !pseudoOfPlayer24.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérification que tout les champs du joueur 3 sont remplis
     *
     */
    private boolean allIsOKPlayers34() {
        if(typePlayer34.getValue() == "Ordinateur" && colorPlayer34.getValue() != null && !pseudoOfPlayer34.getText().isEmpty() && levelIAPlayer34.getValue() != null){
            return true;
        }
        if(typePlayer34.getValue() == "Humain" && colorPlayer34.getValue() != null && !pseudoOfPlayer34.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Vérification que tout les champs du joueur 4 sont remplis
     *
     */
    private boolean allIsOKPlayers44() {
        if(typePlayer44.getValue() == "Ordinateur" && colorPlayer44.getValue() != null && !pseudoOfPlayer44.getText().isEmpty() && levelIAPlayer44.getValue() != null){
            return true;
        }
        if(typePlayer44.getValue() == "Humain" && colorPlayer44.getValue() != null && !pseudoOfPlayer44.getText().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Retourne un objet Color selon la couleur choisit dans la ChoiceBox
     *
     */
    private Color getColor(ChoiceBox<String> x){
        if(x.getValue() == "Vert"){
            return Color.Vert;
        }
        if(x.getValue() == "Bleu"){
            return Color.Bleu;
        }
        if(x.getValue() == "Jaune"){
            return Color.Jaune;
        }
        if(x.getValue() == "Rouge"){
            return Color.Rouge;
        }
        else {
            return null;
        }
    }
    
    /**
     * Accesseur du plateau créé selon ce que les joueurs ont choisit
     *
     */
    public static Board getBoard(){
        return board;
    }

    @FXML
    void startGameClicked(MouseEvent event) {
        FXMLControllerMenuPlayers.board = new Board();
        if (twoPlayersCheckbox.isSelected()) { //Si on a 2 joueurs
            Player[] p = {new Player(typePlayer12.getValue(), pseudoOfPlayer12.getText(), 0, getColor(colorPlayer12), new Pawn()), 
                            new Player(typePlayer22.getValue(), pseudoOfPlayer22.getText(), 1, getColor(colorPlayer22), new Pawn())};
            FXMLControllerMenuPlayers.board.setPlayer(p);
            FXMLControllerMenuPlayers.board.createBoard();
        }
        if (fourPlayersCheckbox.isSelected()) { //Si on a 4 joueurs
            Player[] p = {new Player(typePlayer14.getValue(), pseudoOfPlayer14.getText(), 0, getColor(colorPlayer14), new Pawn()), 
                            new Player(typePlayer24.getValue(), pseudoOfPlayer24.getText(), 1, getColor(colorPlayer24), new Pawn()), 
                            new Player(typePlayer34.getValue(), pseudoOfPlayer34.getText(), 2, getColor(colorPlayer34), new Pawn()), 
                            new Player(typePlayer44.getValue(), pseudoOfPlayer44.getText(), 3, getColor(colorPlayer44), new Pawn())};
            FXMLControllerMenuPlayers.board.setPlayer(p);
            FXMLControllerMenuPlayers.board.createBoard();
        }
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorBoard.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 1250, 1000));
            secondStage.setResizable(false);
            secondStage.setTitle("QUORIDOR");
            secondStage.centerOnScreen();
            pane2Players.getScene().getWindow().hide();
            secondStage.show();
        } catch(Exception exception){
            System.out.println(exception);
        }
    }
}
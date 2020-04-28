package be.nicolasdelp.quoridor.gui;

import java.net.URL;
import java.util.ResourceBundle;

import be.nicolasdelp.quoridor.objects.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLControllerMenuPlayers implements Initializable {

    @FXML
    private Pane pane2Players;

    @FXML
    private ChoiceBox<String> typePlayer12, colorPlayer12, levelIAPlayer12, typePlayer22, colorPlayer22, levelIAPlayer22;

    @FXML
    private TextField pseudoOfPlayer12, pseudoOfPlayer22;

    @FXML
    private Label labelIALevel12, labelIALevel22;

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
        typePlayer12.setItems(typeOfPlayer);
        typePlayer22.setItems(typeOfPlayer);
        colorPlayer12.setItems(colorOfPlayer);
        colorPlayer22.setItems(colorOfPlayer);
        levelIAPlayer12.setItems(levelOfIA);
        levelIAPlayer22.setItems(levelOfIA);
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
        if(allIsOKPlayers12() && allIsOKPlayers22()){ //On vérifie que tout les champs sont remplis
            startGame.setDisable(false);
        } else {
            startGame.setDisable(true);
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
        Player[] p = {new Player(typePlayer12.getValue(), pseudoOfPlayer12.getText(), 0, getColor(colorPlayer12), new Pawn()), 
                        new Player(typePlayer22.getValue(), pseudoOfPlayer22.getText(), 1, getColor(colorPlayer22), new Pawn())};
        if(typePlayer12.getValue() == "Ordinateur"){
            p[0].setIALevel(levelIAPlayer12.getValue());
        }else if(typePlayer22.getValue() == "Ordinateur"){
            p[1].setIALevel(levelIAPlayer22.getValue());
        }
        FXMLControllerMenuPlayers.board.setPlayer(p);
        FXMLControllerMenuPlayers.board.createBoard();
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorBoard.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 1075, 1000));
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
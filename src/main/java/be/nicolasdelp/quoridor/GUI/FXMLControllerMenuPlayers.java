package be.nicolasdelp.quoridor.gui;

import java.io.File;
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

/**
 * La class FXMLControllerMenuPlayer est le controlleur de la fenetre d'option de partie
 *
 * @author Delplanque Nicolas
 */
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
    private final ObservableList<String> levelOfIA = FXCollections.observableArrayList("Facile", "Difficile");

    private static Board board; //Le plateau
    /**
     * Initialise les composant avant l'ouverture de la fenetre
     *
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typePlayer12.setItems(typeOfPlayer);
        typePlayer12.setValue(typeOfPlayer.get(0));
        typePlayer22.setItems(typeOfPlayer);
        typePlayer22.setValue(typeOfPlayer.get(1));
        pseudoOfPlayer12.setText("Joueur 1");
        colorPlayer12.setItems(colorOfPlayer);
        colorPlayer12.setValue(colorOfPlayer.get(0));
        colorPlayer22.setItems(colorOfPlayer);
        colorPlayer22.setValue(colorOfPlayer.get(1));
        levelIAPlayer12.setItems(levelOfIA);
        levelIAPlayer12.setValue(levelOfIA.get(0));
        levelIAPlayer22.setItems(levelOfIA);
        levelIAPlayer22.setValue(levelOfIA.get(0));
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
        if(allIsOKPlayers12() && allIsOKPlayers22()){ //On verifie que tout les champs sont remplis
            startGame.setDisable(false);
        } else {
            startGame.setDisable(true);
        }
    }

    /**
     * Verification que tout les champs du joueur 1 sont remplis
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
     * Verification que tout les champs du joueur 2 sont remplis
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
     * Retourne un objet ColorPawn selon la couleur choisit dans la ChoiceBox
     *
     */
    private ColorPawn getColorPawn(ChoiceBox<String> x){
        if(x.getValue() == "Vert"){
            return ColorPawn.Vert;
        }
        if(x.getValue() == "Bleu"){
            return ColorPawn.Bleu;
        }
        if(x.getValue() == "Jaune"){
            return ColorPawn.Jaune;
        }
        if(x.getValue() == "Rouge"){
            return ColorPawn.Rouge;
        }
        else {
            return null;
        }
    }
    
    /**
     * Accesseur du plateau cree selon ce que les joueurs ont choisit
     *
     * @return un plateau
     */
    public static Board getBoard(){
        return board;
    }

    @FXML
    void startGameClicked(MouseEvent event) {
        File f = new File("board.dat");
        if(f.exists()){
            f.delete();
        }
        FXMLControllerMenu.resumeParty = false;
        FXMLControllerMenuPlayers.board = new Board();
        Player[] p = {new Player(typePlayer12.getValue(), pseudoOfPlayer12.getText(), 0, getColorPawn(colorPlayer12), new Pawn()), 
                        new Player(typePlayer22.getValue(), pseudoOfPlayer22.getText(), 1, getColorPawn(colorPlayer22), new Pawn())};
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
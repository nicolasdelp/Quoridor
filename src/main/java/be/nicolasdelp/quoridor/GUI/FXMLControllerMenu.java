package be.nicolasdelp.quoridor.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLControllerMenu implements Initializable {

    @FXML
    private VBox menuWindow;

    @FXML
    private Button resumeButton;

    @FXML
    private Button newPartyButton;

    @FXML
    private Button optionsButton;

    @FXML
    private Button creditsButton;

    @FXML
    void resumeButtonClicked(MouseEvent event) {
        //TO DO
    }
    
    @FXML
    void newPartyButtonClicked(MouseEvent event) {
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorMenuPlayers.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 835, 450));
            secondStage.setResizable(false);
            secondStage.setTitle("NOUVELLE PARTIE");
            secondStage.centerOnScreen();
            menuWindow.getScene().getWindow().hide();
            secondStage.show();
        } catch(Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    void optionsButtonClicked(MouseEvent event) {
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorOptions.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 600, 340));
            secondStage.setResizable(false);
            secondStage.setTitle("CREDITS");
            secondStage.centerOnScreen();
            secondStage.show();
        } catch(Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    void creditsButtonClicked(MouseEvent event) {
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorCredits.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 600, 340));
            secondStage.setResizable(false);
            secondStage.setTitle("CREDITS");
            secondStage.centerOnScreen();
            secondStage.show();
        } catch(Exception exception){
            System.out.println(exception);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
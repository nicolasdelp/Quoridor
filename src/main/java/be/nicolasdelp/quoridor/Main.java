package be.nicolasdelp.quoridor;

import be.nicolasdelp.quoridor.GUI.*;
import be.nicolasdelp.quoridor.OBJECTS.*;
import be.nicolasdelp.quoridor.SAVELOAD.*;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void Engine(){
        FXMLControllerMenu ControllerMenu = new FXMLControllerMenu();
        FXMLControllerMenuPlayers controllerMenuPlayers = new FXMLControllerMenuPlayers();
        FXMLControllerBoard ControllerBoard = new FXMLControllerBoard();

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/quoridorMenu.fxml"));
        primaryStage.setScene(new Scene(root, 650, 400));
        primaryStage.setResizable(false);
        primaryStage.setTitle("QUORIDOR");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
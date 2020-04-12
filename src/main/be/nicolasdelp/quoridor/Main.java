package main.be.nicolasdelp.quoridor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(final Stage primaryStage) throws java.lang.Exception {
        Parent root = FXMLLoader.load(getClass().getResource("style/style.fxml"));
        primaryStage.setTitle("QUORIDOR");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
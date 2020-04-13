package be.nicolasdelp.quoridor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class FXMLControllerBoard implements Initializable {
    
    @FXML
    private GridPane grid;

    @FXML
    private ImageView box28;

    @FXML
    private ImageView box08;

    @FXML
    void box28Clicked(MouseEvent event) {
        final URL imageURL = getClass().getResource("img/pion-vert.png");  
        final Image image = new Image(imageURL.toExternalForm());
        box28.setImage(image);
        final URL imageURL2 = getClass().getResource("img/case.png");  
        final Image image2 = new Image(imageURL2.toExternalForm());
        box08.setImage(image2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
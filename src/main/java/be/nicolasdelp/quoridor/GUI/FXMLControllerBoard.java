package be.nicolasdelp.quoridor.gui;

import be.nicolasdelp.quoridor.objects.*;
import be.nicolasdelp.quoridor.rules.*;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class FXMLControllerBoard implements Initializable {

    final URL URLCase = getClass().getResource("../img/case.png");  //Image d'une case vide
    final Image imageCase = new Image(URLCase.toExternalForm());
    final URL URLPionVert = getClass().getResource("../img/pion-vert.png");  //Image du pion vert
    final Image imagePionVert = new Image(URLPionVert.toExternalForm());
    final URL URLPionRouge = getClass().getResource("../img/pion-rouge.png");  //Image du pion rouge
    final Image imagePionRouge = new Image(URLPionRouge.toExternalForm());
    final URL URLPionJaune = getClass().getResource("../img/pion-jaune.png");  //Image du pion jaune
    final Image imagePionJaune = new Image(URLPionJaune.toExternalForm());
    final URL URLPionBleu = getClass().getResource("../img/pion-bleu.png");  //Image du pion bleu
    final Image imagePionBleu = new Image(URLPionBleu.toExternalForm());

    private Board board; //Le plateau

    private int currentPlayer = 0; //Le joueur qui joue actuellement

    private ImageView[] oldImageView = new ImageView[4];


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.board = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        board.setPlayer(p);
        board.createBoard();
        box0008.setImage(imagePionVert);
        oldImageView[0] = box0008;
        box1608.setImage(imagePionBleu);
        oldImageView[1] = box1608;
        box0800.setImage(imagePionJaune);
        oldImageView[2] = box0800;
        box0816.setImage(imagePionRouge);
        oldImageView[3] = box0816;
    }

    @FXML
    private GridPane grid;

    @FXML
    private ImageView box0000, box0100, box0200, box0300, box0400, box0500, box0600, box0700, box0800, box0900, box1000, box1100, box1200, box1300, box1400, box1500, box1600, 
                      box0001, box0101, box0201, box0301, box0401, box0501, box0601, box0701, box0801, box0901, box1001, box1101, box1201, box1301, box1401, box1501, box1601,
                      box0002, box0102, box0202, box0302, box0402, box0502, box0602, box0702, box0802, box0902, box1002, box1102, box1202, box1302, box1402, box1502, box1602, 
                      box0003, box0103, box0203, box0303, box0403, box0503, box0603, box0703, box0803, box0903, box1003, box1103, box1203, box1303, box1403, box1503, box1603,
                      box0004, box0104, box0204, box0304, box0404, box0504, box0604, box0704, box0804, box0904, box1004, box1104, box1204, box1304, box1404, box1504, box1604, 
                      box0005, box0105, box0205, box0305, box0405, box0505, box0605, box0705, box0805, box0905, box1005, box1105, box1205, box1305, box1405, box1505, box1605,
                      box0006, box0106, box0206, box0306, box0406, box0506, box0606, box0706, box0806, box0906, box1006, box1106, box1206, box1306, box1406, box1506, box1606, 
                      box0007, box0107, box0207, box0307, box0407, box0507, box0607, box0707, box0807, box0907, box1007, box1107, box1207, box1307, box1407, box1507, box1607,
                      box0008, box0108, box0208, box0308, box0408, box0508, box0608, box0708, box0808, box0908, box1008, box1108, box1208, box1308, box1408, box1508, box1608, 
                      box0009, box0109, box0209, box0309, box0409, box0509, box0609, box0709, box0809, box0909, box1009, box1109, box1209, box1309, box1409, box1509, box1609, 
                      box0010, box0110, box0210, box0310, box0410, box0510, box0610, box0710, box0810, box0910, box1010, box1110, box1210, box1310, box1410, box1510, box1610,
                      box0011, box0111, box0211, box0311, box0411, box0511, box0611, box0711, box0811, box0911, box1011, box1111, box1211, box1311, box1411, box1511, box1611, 
                      box0012, box0112, box0212, box0312, box0412, box0512, box0612, box0712, box0812, box0912, box1012, box1112, box1212, box1312, box1412, box1512, box1612,
                      box0013, box0113, box0213, box0313, box0413, box0513, box0613, box0713, box0813, box0913, box1013, box1113, box1213, box1313, box1413, box1513, box1613, 
                      box0014, box0114, box0214, box0314, box0414, box0514, box0614, box0714, box0814, box0914, box1014, box1114, box1214, box1314, box1414, box1514, box1614,
                      box0015, box0115, box0215, box0315, box0415, box0515, box0615, box0715, box0815, box0915, box1015, box1115, box1215, box1315, box1415, box1515, box1615, 
                      box0016, box0116, box0216, box0316, box0416, box0516, box0616, box0716, box0816, box0916, box1016, box1116, box1216, box1316, box1416, box1516, box1616;

    @FXML
    void box0000Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 0));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0000.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0000;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0002Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 2));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0002.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0002;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0004Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 4));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0004.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0004;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0006Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 6));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0006.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0006;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0008Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 8));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0008.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0008;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0010Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 10));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0010.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0010;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0012Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 12));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0012.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0012;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0014Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 14));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0014.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0014;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0016Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(0, 16));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0016.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0016;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0101Clicked(MouseEvent event) {

    }

    @FXML
    void box0103Clicked(MouseEvent event) {

    }

    @FXML
    void box0105Clicked(MouseEvent event) {

    }

    @FXML
    void box0107Clicked(MouseEvent event) {

    }

    @FXML
    void box0109Clicked(MouseEvent event) {

    }

    @FXML
    void box0111Clicked(MouseEvent event) {

    }

    @FXML
    void box0113Clicked(MouseEvent event) {

    }

    @FXML
    void box0115Clicked(MouseEvent event) {

    }

    @FXML
    void box0200Clicked(MouseEvent event) {

    }

    @FXML
    void box0202Clicked(MouseEvent event) {

    }

    @FXML
    void box0204Clicked(MouseEvent event) {

    }

    @FXML
    void box0206Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(2, 6));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0206.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0206;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0208Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(2, 8));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0208.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0208;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0210Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(2, 10));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0210.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0210;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0212Clicked(MouseEvent event) {

    }

    @FXML
    void box0214Clicked(MouseEvent event) {

    }

    @FXML
    void box0216Clicked(MouseEvent event) {

    }

    @FXML
    void box0301Clicked(MouseEvent event) {

    }

    @FXML
    void box0303Clicked(MouseEvent event) {

    }

    @FXML
    void box0305Clicked(MouseEvent event) {

    }

    @FXML
    void box0307Clicked(MouseEvent event) {

    }

    @FXML
    void box0309Clicked(MouseEvent event) {

    }

    @FXML
    void box0311Clicked(MouseEvent event) {

    }

    @FXML
    void box0313Clicked(MouseEvent event) {

    }

    @FXML
    void box0315Clicked(MouseEvent event) {

    }

    @FXML
    void box0400Clicked(MouseEvent event) {

    }

    @FXML
    void box0402Clicked(MouseEvent event) {

    }

    @FXML
    void box0404Clicked(MouseEvent event) {

    }

    @FXML
    void box0406Clicked(MouseEvent event) {

    }

    @FXML
    void box0408Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[this.currentPlayer], new Position(4, 8));
            oldImageView[this.currentPlayer].setImage(imageCase);
            box0408.setImage(imagePionVert);
            oldImageView[this.currentPlayer] = box0408;

        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Deplacement impossible");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0410Clicked(MouseEvent event) {

    }

    @FXML
    void box0412Clicked(MouseEvent event) {

    }

    @FXML
    void box0414Clicked(MouseEvent event) {

    }

    @FXML
    void box0416Clicked(MouseEvent event) {

    }

    @FXML
    void box0501Clicked(MouseEvent event) {

    }

    @FXML
    void box0503Clicked(MouseEvent event) {

    }

    @FXML
    void box0505Clicked(MouseEvent event) {

    }

    @FXML
    void box0507Clicked(MouseEvent event) {

    }

    @FXML
    void box0509Clicked(MouseEvent event) {

    }

    @FXML
    void box0511Clicked(MouseEvent event) {

    }

    @FXML
    void box0513Clicked(MouseEvent event) {

    }

    @FXML
    void box0515Clicked(MouseEvent event) {

    }

    @FXML
    void box0600Clicked(MouseEvent event) {

    }

    @FXML
    void box0602Clicked(MouseEvent event) {

    }

    @FXML
    void box0604Clicked(MouseEvent event) {

    }

    @FXML
    void box0606Clicked(MouseEvent event) {

    }

    @FXML
    void box0608Clicked(MouseEvent event) {

    }

    @FXML
    void box0610Clicked(MouseEvent event) {

    }

    @FXML
    void box0612Clicked(MouseEvent event) {

    }

    @FXML
    void box0614Clicked(MouseEvent event) {

    }

    @FXML
    void box0616Clicked(MouseEvent event) {

    }

    @FXML
    void box0701Clicked(MouseEvent event) {

    }

    @FXML
    void box0703Clicked(MouseEvent event) {

    }

    @FXML
    void box0705Clicked(MouseEvent event) {

    }

    @FXML
    void box0707Clicked(MouseEvent event) {

    }

    @FXML
    void box0709Clicked(MouseEvent event) {

    }

    @FXML
    void box0711Clicked(MouseEvent event) {

    }

    @FXML
    void box0713Clicked(MouseEvent event) {

    }

    @FXML
    void box0715Clicked(MouseEvent event) {

    }

    @FXML
    void box0800Clicked(MouseEvent event) {

    }

    @FXML
    void box0802Clicked(MouseEvent event) {

    }

    @FXML
    void box0804Clicked(MouseEvent event) {

    }

    @FXML
    void box0806Clicked(MouseEvent event) {

    }

    @FXML
    void box0808Clicked(MouseEvent event) {

    }

    @FXML
    void box0810Clicked(MouseEvent event) {

    }

    @FXML
    void box0812Clicked(MouseEvent event) {

    }

    @FXML
    void box0814Clicked(MouseEvent event) {

    }

    @FXML
    void box0816Clicked(MouseEvent event) {

    }

    @FXML
    void box0901Clicked(MouseEvent event) {

    }

    @FXML
    void box0903Clicked(MouseEvent event) {

    }

    @FXML
    void box0905Clicked(MouseEvent event) {

    }

    @FXML
    void box0907Clicked(MouseEvent event) {

    }

    @FXML
    void box0909Clicked(MouseEvent event) {

    }

    @FXML
    void box0911Clicked(MouseEvent event) {

    }

    @FXML
    void box0913Clicked(MouseEvent event) {

    }

    @FXML
    void box0915Clicked(MouseEvent event) {

    }

    @FXML
    void box1000Clicked(MouseEvent event) {

    }

    @FXML
    void box1002Clicked(MouseEvent event) {

    }

    @FXML
    void box1004Clicked(MouseEvent event) {

    }

    @FXML
    void box1006Clicked(MouseEvent event) {

    }

    @FXML
    void box1008Clicked(MouseEvent event) {

    }

    @FXML
    void box1010Clicked(MouseEvent event) {

    }

    @FXML
    void box1012Clicked(MouseEvent event) {

    }

    @FXML
    void box1014Clicked(MouseEvent event) {

    }

    @FXML
    void box1016Clicked(MouseEvent event) {

    }

    @FXML
    void box1101Clicked(MouseEvent event) {

    }

    @FXML
    void box1103Clicked(MouseEvent event) {

    }

    @FXML
    void box1105Clicked(MouseEvent event) {

    }

    @FXML
    void box1107Clicked(MouseEvent event) {

    }

    @FXML
    void box1109Clicked(MouseEvent event) {

    }

    @FXML
    void box1111Clicked(MouseEvent event) {

    }

    @FXML
    void box1113Clicked(MouseEvent event) {

    }

    @FXML
    void box1115Clicked(MouseEvent event) {

    }

    @FXML
    void box1200Clicked(MouseEvent event) {

    }

    @FXML
    void box1202Clicked(MouseEvent event) {

    }

    @FXML
    void box1204Clicked(MouseEvent event) {

    }

    @FXML
    void box1206Clicked(MouseEvent event) {

    }

    @FXML
    void box1208Clicked(MouseEvent event) {

    }

    @FXML
    void box1210Clicked(MouseEvent event) {

    }

    @FXML
    void box1212Clicked(MouseEvent event) {

    }

    @FXML
    void box1214Clicked(MouseEvent event) {

    }

    @FXML
    void box1216Clicked(MouseEvent event) {

    }

    @FXML
    void box1301Clicked(MouseEvent event) {

    }

    @FXML
    void box1303Clicked(MouseEvent event) {

    }

    @FXML
    void box1305Clicked(MouseEvent event) {

    }

    @FXML
    void box1307Clicked(MouseEvent event) {

    }

    @FXML
    void box1309Clicked(MouseEvent event) {

    }

    @FXML
    void box1311Clicked(MouseEvent event) {

    }

    @FXML
    void box1313Clicked(MouseEvent event) {

    }

    @FXML
    void box1315Clicked(MouseEvent event) {

    }

    @FXML
    void box1400Clicked(MouseEvent event) {

    }

    @FXML
    void box1402Clicked(MouseEvent event) {

    }

    @FXML
    void box1404Clicked(MouseEvent event) {

    }

    @FXML
    void box1406Clicked(MouseEvent event) {

    }

    @FXML
    void box1408Clicked(MouseEvent event) {

    }

    @FXML
    void box1410Clicked(MouseEvent event) {

    }

    @FXML
    void box1412Clicked(MouseEvent event) {

    }

    @FXML
    void box1414Clicked(MouseEvent event) {

    }

    @FXML
    void box1416Clicked(MouseEvent event) {

    }

    @FXML
    void box1501Clickec(MouseEvent event) {

    }

    @FXML
    void box1503Clicked(MouseEvent event) {

    }

    @FXML
    void box1505Clicked(MouseEvent event) {

    }

    @FXML
    void box1507Clicked(MouseEvent event) {

    }

    @FXML
    void box1509Clicked(MouseEvent event) {

    }

    @FXML
    void box1511Clicked(MouseEvent event) {

    }

    @FXML
    void box1513Clicked(MouseEvent event) {

    }

    @FXML
    void box1515Clicked(MouseEvent event) {

    }

    @FXML
    void box1600Clicked(MouseEvent event) {

    }

    @FXML
    void box1602Clicked(MouseEvent event) {

    }

    @FXML
    void box1604Clicked(MouseEvent event) {

    }

    @FXML
    void box1606Clicked(MouseEvent event) {

    }

    @FXML
    void box1608Clicked(MouseEvent event) {

    }

    @FXML
    void box1610Clicked(MouseEvent event) {

    }

    @FXML
    void box1612Clicked(MouseEvent event) {

    }

    @FXML
    void box1614Clicked(MouseEvent event) {

    }

    @FXML
    void box1616Clicked(MouseEvent event) {

    }
}
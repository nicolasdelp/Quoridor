package be.nicolasdelp.quoridor.gui;

import be.nicolasdelp.quoridor.objects.*;
import be.nicolasdelp.quoridor.rules.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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

    final URL URLMurVert = getClass().getResource("../img/mur-vert-stockage.png");  //Image du mur vert
    final Image imageMurVert = new Image(URLMurVert.toExternalForm());
    final URL URLMurRouge = getClass().getResource("../img/mur-rouge-stockage.png");  //Image du mur rouge
    final Image imageMurRouge = new Image(URLMurRouge.toExternalForm());
    final URL URLMurJaune = getClass().getResource("../img/mur-jaune-stockage.png");  //Image du mur jaune
    final Image imageMurJaune = new Image(URLMurJaune.toExternalForm());
    final URL URLMurBleu = getClass().getResource("../img/mur-bleu-stockage.png");  //Image du mur bleu
    final Image imageMurBleu = new Image(URLMurBleu.toExternalForm());


    final URL URLMurBleuH1 = getClass().getResource("../img/mur-bleu-1-H.png");  //Image du mur bleu Horizontal 1
    final Image imageMurBleuH1 = new Image(URLMurBleuH1.toExternalForm());
    final URL URLMurBleuH2 = getClass().getResource("../img/mur-bleu-2-H.png");  //Image du mur bleu Horizontal 2
    final Image imageMurBleuH2 = new Image(URLMurBleuH2.toExternalForm());
    final URL URLMurBleuH3 = getClass().getResource("../img/mur-bleu-3-H.png");  //Image du mur bleu Horizontal 3
    final Image imageMurBleuH3 = new Image(URLMurBleuH3.toExternalForm());

    final URL URLMurRougeH1 = getClass().getResource("../img/mur-rouge-1-H.png");  //Image du mur rouge Horizontal 1
    final Image imageMurRougeH1 = new Image(URLMurRougeH1.toExternalForm());
    final URL URLMurRougeH2 = getClass().getResource("../img/mur-rouge-2-H.png");  //Image du mur rouge Horizontal 2
    final Image imageMurRougeH2 = new Image(URLMurRougeH2.toExternalForm());
    final URL URLMurRougeH3 = getClass().getResource("../img/mur-rouge-3-H.png");  //Image du mur rouge Horizontal 3
    final Image imageMurRougeH3 = new Image(URLMurRougeH3.toExternalForm());

    final URL URLMurJauneH1 = getClass().getResource("../img/mur-jaune-1-H.png");  //Image du mur jaune Horizontal 1
    final Image imageMurJauneH1 = new Image(URLMurJauneH1.toExternalForm());
    final URL URLMurJauneH2 = getClass().getResource("../img/mur-jaune-2-H.png");  //Image du mur jaune Horizontal 2
    final Image imageMurJauneH2 = new Image(URLMurJauneH2.toExternalForm());
    final URL URLMurJauneH3 = getClass().getResource("../img/mur-jaune-3-H.png");  //Image du mur jaune Horizontal 3
    final Image imageMurJauneH3 = new Image(URLMurJauneH3.toExternalForm());

    final URL URLMurVertH1 = getClass().getResource("../img/mur-vert-1-H.png");  //Image du mur vert Horizontal 1
    final Image imageMurVertH1 = new Image(URLMurVertH1.toExternalForm());
    final URL URLMurVertH2 = getClass().getResource("../img/mur-vert-2-H.png");  //Image du mur vert Horizontal 2
    final Image imageMurVertH2 = new Image(URLMurVertH2.toExternalForm());
    final URL URLMurVertH3 = getClass().getResource("../img/mur-vert-3-H.png");  //Image du mur vert Horizontal 3
    final Image imageMurVertH3 = new Image(URLMurVertH3.toExternalForm());

    final URL URLMurBleuV1 = getClass().getResource("../img/mur-bleu-1-V.png");  //Image du mur bleu Vertical 1
    final Image imageMurBleuV1 = new Image(URLMurBleuV1.toExternalForm());
    final URL URLMurBleuV2 = getClass().getResource("../img/mur-bleu-2-V.png");  //Image du mur bleu Vertical 2
    final Image imageMurBleuV2 = new Image(URLMurBleuV2.toExternalForm());
    final URL URLMurBleuV3 = getClass().getResource("../img/mur-bleu-3-V.png");  //Image du mur bleu Vertical 3
    final Image imageMurBleuV3 = new Image(URLMurBleuV3.toExternalForm());

    final URL URLMurRougeV1 = getClass().getResource("../img/mur-rouge-1-V.png");  //Image du mur rouge Vertical 1
    final Image imageMurRougeV1 = new Image(URLMurRougeV1.toExternalForm());
    final URL URLMurRougeV2 = getClass().getResource("../img/mur-rouge-2-V.png");  //Image du mur rouge Vertical 2
    final Image imageMurRougeV2 = new Image(URLMurRougeV2.toExternalForm());
    final URL URLMurRougeV3 = getClass().getResource("../img/mur-rouge-3-V.png");  //Image du mur rouge Vertical 3
    final Image imageMurRougeV3 = new Image(URLMurRougeH3.toExternalForm());

    final URL URLMurJauneV1 = getClass().getResource("../img/mur-jaune-1-V.png");  //Image du mur jaune Vertical 1
    final Image imageMurJauneV1 = new Image(URLMurJauneV1.toExternalForm());
    final URL URLMurJauneV2 = getClass().getResource("../img/mur-jaune-2-V.png");  //Image du mur jaune Vertical 2
    final Image imageMurJauneV2 = new Image(URLMurJauneV2.toExternalForm());
    final URL URLMurJauneV3 = getClass().getResource("../img/mur-jaune-3-V.png");  //Image du mur jaune Vertical 3
    final Image imageMurJauneV3 = new Image(URLMurJauneV3.toExternalForm());

    final URL URLMurVertV1 = getClass().getResource("../img/mur-vert-1-V.png");  //Image du mur vert Vertical 1
    final Image imageMurVertV1 = new Image(URLMurVertV1.toExternalForm());
    final URL URLMurVertV2 = getClass().getResource("../img/mur-vert-2-V.png");  //Image du mur vert Vertical 2
    final Image imageMurVertV2 = new Image(URLMurVertV2.toExternalForm());
    final URL URLMurVertV3 = getClass().getResource("../img/mur-vert-3-V.png");  //Image du mur vert Vertical 3
    final Image imageMurVertV3 = new Image(URLMurVertH3.toExternalForm());

    private Board board = FXMLControllerMenuPlayers.getBoard(); //Le plateau

    private ImageView[] oldImageView = new ImageView[4]; //Liste des dernières position de chaque pion


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(this.board.getPlayers().length == 2){ //Si on est à 2 joueurs
            box0008.setImage(getColorPawn(this.board.players[0]));
            oldImageView[0] = box0008;
            joueur1.setText(this.board.players[0].getUsername());
            stack01Player1.setImage(getColorWall(this.board.players[0])); //Les stocks de murs
            stack02Player1.setImage(getColorWall(this.board.players[0]));
            stack03Player1.setImage(getColorWall(this.board.players[0]));
            stack04Player1.setImage(getColorWall(this.board.players[0]));
            stack05Player1.setImage(getColorWall(this.board.players[0]));
            stack06Player1.setImage(getColorWall(this.board.players[0]));
            stack07Player1.setImage(getColorWall(this.board.players[0]));
            stack08Player1.setImage(getColorWall(this.board.players[0]));
            stack09Player1.setImage(getColorWall(this.board.players[0]));
            stack10Player1.setImage(getColorWall(this.board.players[0]));
            box1608.setImage(getColorPawn(this.board.players[1]));
            oldImageView[1] = box1608;
            joueur2.setText(this.board.players[1].getUsername());
            stack01Player2.setImage(getColorWall(this.board.players[1]));
            stack02Player2.setImage(getColorWall(this.board.players[1]));
            stack03Player2.setImage(getColorWall(this.board.players[1]));
            stack04Player2.setImage(getColorWall(this.board.players[1]));
            stack05Player2.setImage(getColorWall(this.board.players[1]));
            stack06Player2.setImage(getColorWall(this.board.players[1]));
            stack07Player2.setImage(getColorWall(this.board.players[1]));
            stack08Player2.setImage(getColorWall(this.board.players[1]));
            stack09Player2.setImage(getColorWall(this.board.players[1]));
            stack10Player2.setImage(getColorWall(this.board.players[1]));
        }
        if(this.board.getPlayers().length == 4){ //Si on est à 4 joueurs
            box0008.setImage(getColorPawn(this.board.players[0]));
            oldImageView[0] = box0008;
            box1608.setImage(getColorPawn(this.board.players[1]));
            oldImageView[1] = box1608;
            box0800.setImage(getColorPawn(this.board.players[2]));
            oldImageView[2] = box0800;
            box0816.setImage(getColorPawn(this.board.players[3]));
            oldImageView[3] = box0816;
        }
    }

    @FXML
    private GridPane grid;

    @FXML
    private Label joueur1, joueur2;

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
                      box0016, box0116, box0216, box0316, box0416, box0516, box0616, box0716, box0816, box0916, box1016, box1116, box1216, box1316, box1416, box1516, box1616,
                      stack01Player1, stack02Player1, stack03Player1, stack04Player1, stack05Player1, stack06Player1, stack07Player1, stack08Player1, stack09Player1, stack10Player1,
                      stack01Player2, stack02Player2, stack03Player2, stack04Player2, stack05Player2, stack06Player2, stack07Player2, stack08Player2, stack09Player2, stack10Player2;

    private Image getColorPawn(Player player){ //Récupérer la couleur du pion du joueur
        if(player.getColor() == Color.Vert){
            return imagePionVert;
        }if(player.getColor() == Color.Rouge){
            return imagePionRouge;
        }if(player.getColor() == Color.Bleu){
            return imagePionBleu;
        }if(player.getColor() == Color.Jaune){
            return imagePionJaune;
        }
        else{
            return null;
        }
    }

    private Image getColorWall(Player player){ //Récupérer la couleur du pion du joueur
        if(player.getColor() == Color.Vert){
            return imageMurVert;
        }if(player.getColor() == Color.Rouge){
            return imageMurRouge;
        }if(player.getColor() == Color.Bleu){
            return imageMurBleu;
        }if(player.getColor() == Color.Jaune){
            return imageMurJaune;
        }
        else{
            return null;
        }
    }

    private Image[] getWall(Player player, WallDirection wall){ //Récupérer la couleur du pion du joueur
        Image[] res = new Image[3];
        if(player.getColor() == Color.Bleu && wall == WallDirection.Horizontal){
            res[0] = imageMurBleuH1;
            res[1] = imageMurBleuH2;
            res[2] = imageMurBleuH3;
            return res;
        }
        if(player.getColor() == Color.Bleu && wall == WallDirection.Vertical){
            res[0] = imageMurBleuV1;
            res[1] = imageMurBleuV2;
            res[2] = imageMurBleuV3;
            return res;
        }
        if(player.getColor() == Color.Rouge && wall == WallDirection.Horizontal){
            res[0] = imageMurRougeH1;
            res[1] = imageMurRougeH2;
            res[2] = imageMurRougeH3;
            return res;
        }
        if(player.getColor() == Color.Rouge && wall == WallDirection.Vertical){
            res[0] = imageMurRougeV1;
            res[1] = imageMurRougeV2;
            res[2] = imageMurRougeV3;
            return res;
        }
        if(player.getColor() == Color.Vert && wall == WallDirection.Horizontal){
            res[0] = imageMurVertH1;
            res[1] = imageMurVertH2;
            res[2] = imageMurVertH3;
            return res;
        }
        if(player.getColor() == Color.Vert && wall == WallDirection.Vertical){
            res[0] = imageMurVertV1;
            res[1] = imageMurVertV2;
            res[2] = imageMurVertV3;
            return res;
        }
        if(player.getColor() == Color.Jaune && wall == WallDirection.Horizontal){
            res[0] = imageMurJauneH1;
            res[1] = imageMurJauneH2;
            res[2] = imageMurJauneH3;
            return res;
        }
        if(player.getColor() == Color.Jaune && wall == WallDirection.Vertical){
            res[0] = imageMurJauneV1;
            res[1] = imageMurJauneV2;
            res[2] = imageMurJauneV3;
            return res;
        }
        else{
            return null;
        }
    }

    @FXML
    void box0000Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0000.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0000; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0002Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0002.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0002; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0004Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0004.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0004; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0006Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0006.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0006; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0008Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0008.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0008; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0010Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0010.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0010; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0012Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0012.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0012; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0014Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0014.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0014; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0016Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(0, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0016.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0016; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0101Clicked(MouseEvent event) { //Case pour mur
        try {
            board.setWallOnBoard(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1], WallDirection.Vertical, new Position(1, 1)); //On vérifie le mouvement est possible 
            if(board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection() == WallDirection.Horizontal){
                box0001.setImage(getWall(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection())[0]);
                box0101.setImage(getWall(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection())[1]);   
                box0201.setImage(getWall(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection())[2]);
            }
            if(board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection() == WallDirection.Vertical){
                box0100.setImage(getWall(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection())[0]);
                box0101.setImage(getWall(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection())[1]);   
                box0102.setImage(getWall(board.players[board.getcurrentIDPlayer()], board.players[board.getcurrentIDPlayer()].getWalls()[board.players[board.getcurrentIDPlayer()].getWallIndex()-1].getWallDirection())[2]);
            }
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0103Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0105Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0107Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0109Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0111Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0113Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0115Clicked(MouseEvent event) {  //Case pour mur

    }

    @FXML
    void box0200Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0200.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0200; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0202Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0202.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0202; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0204Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0204.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0204; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0206Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0206.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0206; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0208Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0208.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0208; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0210Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0210.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0210; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0212Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0212.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0212; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0214Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0214.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0214; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0216Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(2, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0216.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0216; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0301Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0303Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0305Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0307Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0309Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0311Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0313Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0315Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0400Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0400.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0400; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0402Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0402.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0402; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0404Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0404.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0404; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0406Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0406.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0406; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0408Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0408.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0408; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0410Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0410.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0410; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0412Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0412.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0412; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0414Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0414.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0414; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0416Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(4, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0416.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0416; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0501Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0503Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0505Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0507Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0509Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0511Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0513Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0515Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0600Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0600.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0600; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0602Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0602.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0602; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0604Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0604.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0604; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0606Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0606.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0606; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0608Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0608.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0608; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0610Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0610.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0610; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0612Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0612.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0612; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0614Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0614.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0614; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0616Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(6, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0616.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0616; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0701Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0703Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0705Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0707Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0709Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0711Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0713Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0715Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0800Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0800.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0800; //On enregistre la case actuel pour la vider au prochain coup          
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0802Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0802.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0802; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0804Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0804.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0804; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0806Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0806.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0806; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0808Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0808.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0808; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0810Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0810.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0810; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0812Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0812.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0812; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0814Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0814.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0814; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0816Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(8, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box0816.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box0816; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box0901Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0903Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0905Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0907Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0909Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0911Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0913Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box0915Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1000Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1000.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1000; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1002Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1002.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1002; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1004Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1004.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1004; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1006Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1006.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1006; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1008Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1008.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1008; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1010Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1010.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1010; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1012Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1012.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1012; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1014Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1014.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1014; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1016Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(10, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1016.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1016; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1101Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1103Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1105Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1107Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1109Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1111Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1113Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1115Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1200Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1200.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1200; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1202Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1202.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1202; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1204Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1204.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1204; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1206Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1206.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1206; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1208Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1208.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1208; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1210Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1210.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1210; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1212Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1212.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1212; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1214Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1214.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1214; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1216Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(12, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1216.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1216; //On enregistre la case actuel pour la vider au prochain coup

            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1301Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1303Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1305Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1307Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1309Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1311Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1313Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1315Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1400Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1400.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1400; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1402Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1402.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1402; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1404Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1404.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1404; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1406Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1406.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1406; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1408Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1408.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1408; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1410Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1410.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1410; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1412Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1412.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1412; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1414Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1414.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1414; //On enregistre la case actuel pour la vider au prochain coup
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1416Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(14, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1416.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1416; //On enregistre la case actuel pour la vider au prochain coup

            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1501Clickec(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1503Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1505Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1507Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1509Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1511Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1513Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1515Clicked(MouseEvent event) { //Case pour mur

    }

    @FXML
    void box1600Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 0)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1600.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1600; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1602Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 2)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1602.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1602; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1604Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 4)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1604.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1604; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1606Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 6)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1606.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1606; //On enregistre la case actuel pour la vider au prochain coup
           
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1608Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 8)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1608.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1608; //On enregistre la case actuel pour la vider au prochain coup
               
            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1610Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 10)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1610.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1610; //On enregistre la case actuel pour la vider au prochain coup

            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1612Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 12)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1612.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1612; //On enregistre la case actuel pour la vider au prochain coup

            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1614Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 14)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1614.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1614; //On enregistre la case actuel pour la vider au prochain coup

            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void box1616Clicked(MouseEvent event) {
        try {
            board.movePawnOnBoard(board.players[board.getcurrentIDPlayer()], new Position(16, 16)); //On vérifie le mouvement est possible
            oldImageView[board.getcurrentIDPlayer()].setImage(imageCase); //On remet la case vide
            box1616.setImage(getColorPawn(board.players[board.getcurrentIDPlayer()])); //On met dans la case le pion selon la couleur du player
            oldImageView[board.getcurrentIDPlayer()] = box1616; //On enregistre la case actuel pour la vider au prochain coup

            board.nextPlayer();
        } catch (RuleViolated e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
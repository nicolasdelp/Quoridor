package be.nicolasdelp.quoridor.gui;

import be.nicolasdelp.quoridor.objects.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class FXMLControllerBoard implements Initializable{

    @FXML
    private GridPane grid, stackPlayer1, stackPlayer2;

    @FXML
    private Label joueur1, joueur2;

    @FXML
    private CheckBox Horizontal, Vertical;

    final URL URLCase = getClass().getResource("../img/case.png");  //Image d'une case vide
    final Image imageCase = new Image(URLCase.toExternalForm(), 55, 56, true, false);
    final URL URLPionVert = getClass().getResource("../img/pion-vert.png");  //Image du pion vert
    final Image imagePionVert = new Image(URLPionVert.toExternalForm(), 55, 56, true, false);
    final URL URLPionRouge = getClass().getResource("../img/pion-rouge.png");  //Image du pion rouge
    final Image imagePionRouge = new Image(URLPionRouge.toExternalForm(), 55, 56, true, false);
    final URL URLPionJaune = getClass().getResource("../img/pion-jaune.png");  //Image du pion jaune
    final Image imagePionJaune = new Image(URLPionJaune.toExternalForm(), 55, 56, true, false);
    final URL URLPionBleu = getClass().getResource("../img/pion-bleu.png");  //Image du pion bleu
    final Image imagePionBleu = new Image(URLPionBleu.toExternalForm(), 55, 56, true, false);
    final URL URLMurVert = getClass().getResource("../img/mur-vert-stockage.png");  //Image du mur vert stockage
    final Image imageMurVert = new Image(URLMurVert.toExternalForm(), 119, 34, true, false);
    final URL URLMurRouge = getClass().getResource("../img/mur-rouge-stockage.png");  //Image du mur rouge stockage
    final Image imageMurRouge = new Image(URLMurRouge.toExternalForm(), 119, 34, true, false);
    final URL URLMurJaune = getClass().getResource("../img/mur-jaune-stockage.png");  //Image du mur jaune stockage
    final Image imageMurJaune = new Image(URLMurJaune.toExternalForm(), 119, 34, true, false);
    final URL URLMurBleu = getClass().getResource("../img/mur-bleu-stockage.png");  //Image du mur bleu stockage
    final Image imageMurBleu = new Image(URLMurBleu.toExternalForm(), 119, 34, true, false);
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
    final Image imageMurRougeV3 = new Image(URLMurRougeV3.toExternalForm());
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
    final Image imageMurVertV3 = new Image(URLMurVertV3.toExternalForm());

    private Board board; //Le plateau

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.board = FXMLControllerMenuPlayers.getBoard();
        for (int i = 0; i < this.board.getLength(); i++) {
            for (int j = 0; j < this.board.getWidth(); j++) {
                if(this.board.getBoardBoxes()[i][j].getisPawnBox()){
                    ImageView img = new ImageView(imageCase);
                    img.setCursor(Cursor.HAND);
                    img.setOnMouseClicked(event -> game(GridPane.getColumnIndex(img), GridPane.getRowIndex(img)));
                    grid.add(img, i, j);
                }
                if(isImpair(i) && isImpair(j)){
                    ImageView img = new ImageView(imageMurVertV2);
                    img.setCursor(Cursor.CROSSHAIR);
                    img.setOnMouseClicked(event -> game(GridPane.getColumnIndex(img), GridPane.getRowIndex(img)));
                    grid.add(img, i, j);
                }
            }
        }
        joueur1.setText(this.board.players[0].getUsername());
        joueur2.setText(this.board.players[1].getUsername());
        for(int i=0; i < board.getPlayers().length; i++){ //On mets les pions des joueurs
            grid.add(new ImageView(getColorPawn(board.getPlayers()[i])), board.getPlayers()[i].getPawn().getPosition().getX(), board.getPlayers()[i].getPawn().getPosition().getY());
            oldPosition[i] = new Position(board.getPlayers()[i].getPawn().getPosition().getX(), board.getPlayers()[i].getPawn().getPosition().getY());
        }
        for(int i=0; i < board.getPlayers()[0].getWallIndex()+1; i++){ //On mets les stocks de murs aux joueurs
            stackPlayer1.add(new ImageView(getColorWall(board.getPlayers()[0])), 0, i);
            stackPlayer2.add(new ImageView(getColorWall(board.getPlayers()[1])), 0, i);
        }
    }

    @FXML
    void HorizontalCheckboxCheck(ActionEvent event) {
        if (Horizontal.isSelected()) {
            Vertical.setSelected(false);
        }
        if (!Horizontal.isSelected()) {
            Vertical.setSelected(true);
        }
    }

    @FXML
    void VerticalCheckboxCheck(ActionEvent event) {
        if (Vertical.isSelected()) {
            Horizontal.setSelected(false);
        }
        if (!Vertical.isSelected()) {
            Horizontal.setSelected(true);
        }
    }

    /**
     * Verifie si le nombre est impair
     * 
     * @param x un entier
     * @return true ou false
     */
    public static boolean isImpair(int x) {
        if (x % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
    
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

    private Position[] oldPosition = new Position[2]; //Liste de la dernière position de chaque pion

    public void game(int i, int j){
        System.out.println(i + "+" + j);
    }
}
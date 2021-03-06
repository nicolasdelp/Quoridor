package be.nicolasdelp.quoridor.gui;

import be.nicolasdelp.quoridor.graph.Graph;
import be.nicolasdelp.quoridor.objects.*;
import be.nicolasdelp.quoridor.rules.RuleViolated;
import be.nicolasdelp.quoridor.saveload.LoadGame;
import be.nicolasdelp.quoridor.saveload.SaveGame;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * La class FXMLControllerBoard est le controlleur de la fenetre du plateau de jeu
 *
 * @author Delplanque Nicolas
 */
public class FXMLControllerBoard implements Initializable{

    @FXML
    private GridPane grid, stackPlayer1, stackPlayer2;

    @FXML
    private Label joueur1, joueur2;

    @FXML
    private CheckBox Horizontal, Vertical;

    @FXML
    private Button saveTheGame, backToMenu;

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
    final URL URLMurBlanc = getClass().getResource("../img/mur-blanc-milieu.png");  //Image du mur blanc milieu
    final Image imageMurBlanc = new Image(URLMurBlanc.toExternalForm());

    private Board board; //Le plateau

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(FXMLControllerMenu.resumeParty == true){
            this.board = LoadGame.getBoard();
        } else {
            this.board = FXMLControllerMenuPlayers.getBoard();
        }
        for (int i = 0; i < this.board.getLength(); i++) {
            for (int j = 0; j < this.board.getWidth(); j++) {
                if(this.board.getBoardBoxes()[i][j].getisPawnBox()){
                    ImageView img = new ImageView(imageCase);
                    img.setCursor(Cursor.HAND);
                    img.setOnMouseClicked(event -> handleClickOnBox(GridPane.getColumnIndex(img), GridPane.getRowIndex(img)));
                    grid.add(img, i, j);
                }
                if(isImpair(i) && isImpair(j)){
                    ImageView img = new ImageView(imageMurBlanc);
                    img.setCursor(Cursor.CROSSHAIR);
                    img.setOnMouseClicked(event -> wall(GridPane.getColumnIndex(img), GridPane.getRowIndex(img)));
                    grid.add(img, i, j);
                } else {
                    ImageView img = new ImageView();
                    grid.add(img, i, j);
                }
            }
        }
        if(FXMLControllerMenu.resumeParty == true){
            for (int i = 0; i < this.board.getPlayers().length; i++) {
                for (int j = 0; j < this.board.getPlayers()[i].getStockOfWalls().length; j++) {
                    if(this.board.getPlayers()[i].getStockOfWalls()[j].getWallDirection() == WallDirection.Horizontal){
                        ImageView wall1 = new ImageView(getWall(board.getPlayers()[this.board.getPlayers()[i].getID()], WallDirection.Horizontal)[0]);
                        ImageView wall2 = new ImageView(getWall(board.getPlayers()[this.board.getPlayers()[i].getID()], WallDirection.Horizontal)[1]);
                        ImageView wall3 = new ImageView(getWall(board.getPlayers()[this.board.getPlayers()[i].getID()], WallDirection.Horizontal)[2]);
                        grid.add(wall1, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getX()-1, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getY());
                        grid.add(wall2, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getX(), this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getY());
                        grid.add(wall3, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getX()+1, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getY());
                    }
                    if(this.board.getPlayers()[i].getStockOfWalls()[j].getWallDirection() == WallDirection.Vertical){
                        ImageView wall1 = new ImageView(getWall(board.getPlayers()[this.board.getPlayers()[i].getID()], WallDirection.Vertical)[0]);
                        ImageView wall2 = new ImageView(getWall(board.getPlayers()[this.board.getPlayers()[i].getID()], WallDirection.Vertical)[1]);
                        ImageView wall3 = new ImageView(getWall(board.getPlayers()[this.board.getPlayers()[i].getID()], WallDirection.Vertical)[2]);
                        grid.add(wall1, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getX(), this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getY()-1);
                        grid.add(wall2, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getX(), this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getY());
                        grid.add(wall3, this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getX(), this.board.getPlayers()[i].getStockOfWalls()[j].getPosition().getY()+1);
                    }
                }
            }
        }
        joueur1.setText(this.board.getPlayers()[0].getUsername().toUpperCase());
        joueur1.setTextFill(Color.web("#4cd137"));
        joueur1.setStyle("-fx-font-weight: bold");
        joueur2.setText(this.board.getPlayers()[1].getUsername().toUpperCase());
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
    void backToMenuClicked(ActionEvent event) {
        if(this.board.getWin() == true){
            File f = new File("board.dat");
            if(f.exists()){
                f.delete();
            }
            FXMLControllerMenu.resumeParty = false;
        } else{
            SaveGame.saveBoard(this.board);
            FXMLControllerMenu.resumeParty = true;
        }
        try{
            FXMLLoader fxmloader = new FXMLLoader(getClass().getResource("../fxml/quoridorMenu.fxml"));
            Parent root = (Parent) fxmloader.load();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(root, 650, 400));
            secondStage.setResizable(false);
            secondStage.setTitle("QUORIDOR");
            secondStage.centerOnScreen();
            grid.getScene().getWindow().hide();
            secondStage.show();
        } catch(Exception exception){
            System.out.println(exception);
        }
    }

    @FXML
    void saveTheGameClicked(ActionEvent event) {
        File f = new File("board.dat");
        if(f.exists()){
            f.delete();
        }
        FXMLControllerMenu.resumeParty = false;
        
        if(this.board.getWin() == false){
            SaveGame.saveBoard(this.board);
            FXMLControllerMenu.resumeParty = true;
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
    
    /**
     * Recupere une image de pion selon la couleur du joueur
     * 
     * @param player un joueur
     * @return une image de pion
     */
    private Image getColorPawn(Player player){
        if(player.getColor() == ColorPawn.Vert){
            return imagePionVert;
        }if(player.getColor() == ColorPawn.Rouge){
            return imagePionRouge;
        }if(player.getColor() == ColorPawn.Bleu){
            return imagePionBleu;
        }if(player.getColor() == ColorPawn.Jaune){
            return imagePionJaune;
        }
        else{
            return null;
        }
    }

    /**
     * Recupere une image de mur selon la couleur du joueur
     * 
     * @param player un joueur
     * @return une image de mur a stocker
     */
    private Image getColorWall(Player player){
        if(player.getColor() == ColorPawn.Vert){
            return imageMurVert;
        }if(player.getColor() == ColorPawn.Rouge){
            return imageMurRouge;
        }if(player.getColor() == ColorPawn.Bleu){
            return imageMurBleu;
        }if(player.getColor() == ColorPawn.Jaune){
            return imageMurJaune;
        }
        else{
            return null;
        }
    }

    /**
     * Recupere une liste d'images de mur selon la couleur du joueur
     * 
     * @param player un joueur
     * @return une liste d'image de mur
     */
    private Image[] getWall(Player player, WallDirection wall){
        Image[] res = new Image[3];
        if(player.getColor() == ColorPawn.Bleu && wall == WallDirection.Horizontal){
            res[0] = imageMurBleuH1;
            res[1] = imageMurBleuH2;
            res[2] = imageMurBleuH3;
            return res;
        }
        if(player.getColor() == ColorPawn.Bleu && wall == WallDirection.Vertical){
            res[0] = imageMurBleuV1;
            res[1] = imageMurBleuV2;
            res[2] = imageMurBleuV3;
            return res;
        }
        if(player.getColor() == ColorPawn.Rouge && wall == WallDirection.Horizontal){
            res[0] = imageMurRougeH1;
            res[1] = imageMurRougeH2;
            res[2] = imageMurRougeH3;
            return res;
        }
        if(player.getColor() == ColorPawn.Rouge && wall == WallDirection.Vertical){
            res[0] = imageMurRougeV1;
            res[1] = imageMurRougeV2;
            res[2] = imageMurRougeV3;
            return res;
        }
        if(player.getColor() == ColorPawn.Vert && wall == WallDirection.Horizontal){
            res[0] = imageMurVertH1;
            res[1] = imageMurVertH2;
            res[2] = imageMurVertH3;
            return res;
        }
        if(player.getColor() == ColorPawn.Vert && wall == WallDirection.Vertical){
            res[0] = imageMurVertV1;
            res[1] = imageMurVertV2;
            res[2] = imageMurVertV3;
            return res;
        }
        if(player.getColor() == ColorPawn.Jaune && wall == WallDirection.Horizontal){
            res[0] = imageMurJauneH1;
            res[1] = imageMurJauneH2;
            res[2] = imageMurJauneH3;
            return res;
        }
        if(player.getColor() == ColorPawn.Jaune && wall == WallDirection.Vertical){
            res[0] = imageMurJauneV1;
            res[1] = imageMurJauneV2;
            res[2] = imageMurJauneV3;
            return res;
        }
        else{
            return null;
        }
    }

    /**
     * Change la couleur du pseudo
     * 
     */
    private void changeLabelColor(){
        if(board.getcurrentIDPlayer() == 0){
            joueur1.setTextFill(Color.web("#4cd137"));
            joueur1.setStyle("-fx-font-weight: bold");
            joueur2.setTextFill(Color.BLACK);
            joueur2.setStyle("-fx-font-weight: regular");
        } else if(board.getcurrentIDPlayer() == 1){
            joueur2.setTextFill(Color.web("#4cd137"));
            joueur2.setStyle("-fx-font-weight: bold");
            joueur1.setTextFill(Color.BLACK);
            joueur1.setStyle("-fx-font-weight: regular");
        }
    }

    private Position[] oldPosition = new Position[2]; //Liste de la derniere position de chaque pion

    /**
     * Essaie de placer le pion et si cela ne fonctionne pas, attrape la RuleViolation et affiche un popup
     * 
     * @param i un abscisse
     * @param j une ordonnee
     */
    public void handleClickOnBox(int i, int j){
        try{
            pawn(i, j);
        }
        catch(RuleViolated e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Deplace le pion dans l'objet board et met a jour l'interface graphique
     * 
     * @param i un abscisse
     * @param j une ordonnee
     * @throws RuleViolated les regles de jeu
     */
    public void pawn(int i, int j) throws RuleViolated{
        board.movePawnOnBoard(board.getPlayers()[board.getcurrentIDPlayer()], new Position(i, j)); //On verifie le mouvement est possible
        ImageView caseVide = new ImageView(imageCase);
        caseVide.setCursor(Cursor.HAND);
        caseVide.setOnMouseClicked(event -> handleClickOnBox(GridPane.getColumnIndex(caseVide), GridPane.getRowIndex(caseVide)));
        grid.add(caseVide, oldPosition[board.getcurrentIDPlayer()].getX(), oldPosition[board.getcurrentIDPlayer()].getY());
        ImageView casePawn = new ImageView(getColorPawn(board.getPlayers()[board.getcurrentIDPlayer()]));
        grid.add(casePawn, i, j);
        oldPosition[board.getcurrentIDPlayer()] = new Position(i, j); //On enregistre la case actuel pour la vider au prochain coup
        if(this.board.getWin()){
            File f = new File("board.dat");
            if(f.exists()){
                f.delete();
            }
            FXMLControllerMenu.resumeParty = false;
            grid.setDisable(true);
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("BRAVO " + this.board.getWinner().toUpperCase() + ", VOUS AVEZ GAGNE LA PARTIE !");
            alert.showAndWait();
        }else{
            board.nextPlayer();
            changeLabelColor();
            if(this.board.getPlayers()[0].getType() == "Ordinateur"){
                if(this.board.getPlayers()[0].getIALevel() == "Facile"){
                    if(board.getcurrentIDPlayer() == 0){
                        if(!board.getWin()){
                            IAEasy(this.board.getPlayers()[0]);
                        }
                    }
                }
                if(this.board.getPlayers()[0].getIALevel() == "Difficile"){
                    if(board.getcurrentIDPlayer() == 0){
                        if(!board.getWin()){
                            IAHard(this.board.getPlayers()[0]);
                        }
                    }
                }
            }
            if(this.board.getPlayers()[1].getType() == "Ordinateur"){
                if(this.board.getPlayers()[1].getIALevel() == "Facile"){
                    if(board.getcurrentIDPlayer() == 1){
                        if(!board.getWin()){
                            IAEasy(this.board.getPlayers()[1]);
                        }
                    }
                }
                if(this.board.getPlayers()[1].getIALevel() == "Difficile"){
                    if(board.getcurrentIDPlayer() == 1){
                        if(!board.getWin()){
                            IAHard(this.board.getPlayers()[1]);
                        }
                    }
                }
            }
        }
    }

    /**
     * Pose un mur dans l'objet board et met a jour l'interface graphique
     * 
     * @param i un abscisse
     * @param j une ordonnee
     */
    public void wall(int i, int j){
        if(Horizontal.isSelected()){
            try {
                board.setWallOnBoard(board.getPlayers()[board.getcurrentIDPlayer()], board.getPlayers()[board.getcurrentIDPlayer()].getCurrentWall(), WallDirection.Horizontal, new Position(i, j)); //On verifie le mouvement est possible 
                ImageView wall1 = new ImageView(getWall(board.getPlayers()[board.getcurrentIDPlayer()], WallDirection.Horizontal)[0]);
                ImageView wall2 = new ImageView(getWall(board.getPlayers()[board.getcurrentIDPlayer()], WallDirection.Horizontal)[1]);
                ImageView wall3 = new ImageView(getWall(board.getPlayers()[board.getcurrentIDPlayer()], WallDirection.Horizontal)[2]);
                grid.add(wall1, i-1, j);
                grid.add(wall2, i, j);
                grid.add(wall3, i+1, j);
                if(board.getcurrentIDPlayer() == 0){
                    stackPlayer1.getChildren().remove(0);
                }
                if(board.getcurrentIDPlayer() == 1){
                    stackPlayer2.getChildren().remove(0);
                }
                board.nextPlayer();
                changeLabelColor();
                if(this.board.getPlayers()[0].getType() == "Ordinateur"){
                    if(this.board.getPlayers()[0].getIALevel() == "Facile"){
                        if(board.getcurrentIDPlayer() == 0){
                            if(!board.getWin()){
                                IAEasy(this.board.getPlayers()[0]);
                            }
                        }
                    }
                    if(this.board.getPlayers()[0].getIALevel() == "Difficile"){
                        if(board.getcurrentIDPlayer() == 0){
                            if(!board.getWin()){
                                IAHard(this.board.getPlayers()[0]);
                            }
                        }
                    }
                }
                if(this.board.getPlayers()[1].getType() == "Ordinateur"){
                    if(this.board.getPlayers()[1].getIALevel() == "Facile"){
                        if(board.getcurrentIDPlayer() == 1){
                            if(!board.getWin()){
                                IAEasy(this.board.getPlayers()[1]);
                            }
                        }
                    }
                    if(this.board.getPlayers()[1].getIALevel() == "Difficile"){
                        if(board.getcurrentIDPlayer() == 1){
                            if(!board.getWin()){
                                IAHard(this.board.getPlayers()[1]);
                            }
                        }
                    }
                }
            } catch (RuleViolated e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
        if(Vertical.isSelected()){
            try {
                board.setWallOnBoard(board.getPlayers()[board.getcurrentIDPlayer()], board.getPlayers()[board.getcurrentIDPlayer()].getCurrentWall(), WallDirection.Vertical, new Position(i, j)); //On verifie le mouvement est possible 
                ImageView wall1 = new ImageView(getWall(board.getPlayers()[board.getcurrentIDPlayer()], WallDirection.Vertical)[0]);
                ImageView wall2 = new ImageView(getWall(board.getPlayers()[board.getcurrentIDPlayer()], WallDirection.Vertical)[1]);
                ImageView wall3 = new ImageView(getWall(board.getPlayers()[board.getcurrentIDPlayer()], WallDirection.Vertical)[2]);
                grid.add(wall1, i, j-1);
                grid.add(wall2, i, j);
                grid.add(wall3, i, j+1);
                if(board.getcurrentIDPlayer() == 0){
                    stackPlayer1.getChildren().remove(0);
                }
                if(board.getcurrentIDPlayer() == 1){
                    stackPlayer2.getChildren().remove(0);
                }
                board.nextPlayer();
                changeLabelColor();
                if(this.board.getPlayers()[0].getType() == "Ordinateur"){
                    if(this.board.getPlayers()[0].getIALevel() == "Facile"){
                        if(board.getcurrentIDPlayer() == 0){
                            if(!board.getWin()){
                                IAEasy(this.board.getPlayers()[0]);
                            }
                        }
                    }
                    if(this.board.getPlayers()[0].getIALevel() == "Difficile"){
                        if(board.getcurrentIDPlayer() == 0){
                            if(!board.getWin()){
                                IAHard(this.board.getPlayers()[0]);
                            }
                        }
                    }
                }
                if(this.board.getPlayers()[1].getType() == "Ordinateur"){
                    if(this.board.getPlayers()[1].getIALevel() == "Facile"){
                        if(board.getcurrentIDPlayer() == 1){
                            if(!board.getWin()){
                                IAEasy(this.board.getPlayers()[1]);
                            }
                        }
                    }
                    if(this.board.getPlayers()[1].getIALevel() == "Difficile"){
                        if(board.getcurrentIDPlayer() == 1){
                            if(!board.getWin()){
                                IAHard(this.board.getPlayers()[1]);
                            }
                        }
                    }
                }
            } catch (RuleViolated e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    /**
     * Une IA aleatoire
     * 
     * @param player un joueur ordinateur
     */
    public void IAEasy(Player player){
        ArrayList<Position> positionsToTry = new ArrayList<Position>(); // On cree et initialise les positions que l'on va essayer.
        for(int i = player.getPawn().getPosition().getX()-2; i<=player.getPawn().getPosition().getX()+2; i+=2){
            for(int j = player.getPawn().getPosition().getY()-2; j<=player.getPawn().getPosition().getY()+2; j+=2){
                if (!(i == player.getPawn().getPosition().getX() && j == player.getPawn().getPosition().getY())){ //On ne peut pas se deplacer sur la position actuelle du pion
                    positionsToTry.add(new Position(i, j));
                }
            }
        }
        Collections.shuffle(positionsToTry); // On melange les positions disponibles.
        
        boolean continueToTry = true;
        while(continueToTry){
            Position currentPositionToTry = positionsToTry.remove(0); //Mets dans la variable avant de la supprimer
            try{
                continueToTry = false;
                pawn(currentPositionToTry.getX(), currentPositionToTry.getY());
            } catch(RuleViolated e){
                continueToTry = true;
            }
        }
    }

    /**
     * Une IA suivant le chemin donne par le pathfinding
     * 
     * @param player un joueur ordinateur
     */
    public void IAHard(Player player){
        Graph g = new Graph(this.board, this.board.getPlayers()[1]);
        if(player.getID() == this.board.getPlayers()[1].getID()){
            g = new Graph(this.board, this.board.getPlayers()[0]);
        }
        g.pathForIA();

        int[] allPathSize = new int[9];
        for(int i = 0; i < player.getFinishPosition().length; i++){
            if(g.pathFinding(player.getPawn().getPosition(), player.getFinishPosition()[i])){
                g.pathFinding(player.getPawn().getPosition(), player.getFinishPosition()[i]);
                allPathSize[i] = g.getPath().size();
            }
            else{
                allPathSize[i] = 100;
            }
        }
        int res = 100;
        for(int i = 0; i < allPathSize.length; i++){
            if(allPathSize[i] < res){
                res = i;
            }
        }

        g.pathFinding(player.getPawn().getPosition(), player.getFinishPosition()[res]);
        handleClickOnBox(g.getPath().get(0).getNodePosition().getX(), g.getPath().get(0).getNodePosition().getY());
    }
}
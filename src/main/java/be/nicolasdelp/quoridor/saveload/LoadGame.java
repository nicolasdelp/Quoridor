package be.nicolasdelp.quoridor.saveload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import be.nicolasdelp.quoridor.objects.Board;

/**
 * La class LoadGame est la classe qui permet de charger une partie
 * 
 * @author Delplanque Nicolas
 */
public class LoadGame {

    private static Board loadBoard = null;

    public static void loadGame() {

        ObjectInputStream ois = null;

        try {
            FileInputStream fichier = new FileInputStream("board.dat");
            ois = new ObjectInputStream(fichier);
            Board board = (Board) ois.readObject();
            loadBoard = board;
        } catch (java.io.IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } finally {
        try {
            if (ois != null) {
            ois.close();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        }
    }

    /**
     * Accesseur du plateau cree selon ce que les joueurs ont choisit
     *
     * @return vraie ou faux
     */
    public static Board getBoard(){
        return loadBoard;
    }
}
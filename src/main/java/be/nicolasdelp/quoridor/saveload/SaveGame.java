package be.nicolasdelp.quoridor.saveload;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import be.nicolasdelp.quoridor.objects.Board;

public class SaveGame {

    public static void saveBoard(Board board){
    
        ObjectOutputStream oos = null;

        try {
            final FileOutputStream fichier = new FileOutputStream("board.dat");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(board);
            oos.flush();
        } catch (java.io.IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (oos != null) {
                oos.flush();
                oos.close();
                }
            } catch (java.io.IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
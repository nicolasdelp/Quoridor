package be.nicolasdelp.quoridor;

import be.nicolasdelp.quoridor.objects.*;

public class MainStat {

    public static void main(String[] args){
        int round = Integer.parseInt(args[0]);
        String firstPlayerLevel = args[1];
        String secondPlayerLevel = args[2];

        Board b = new Board();
        Player[] p = {new Player("Ordinateur", "Joueur 1", 0, ColorPawn.Bleu, new Pawn()), new Player("Ordinateur", "Joueur 2", 1, ColorPawn.Rouge, new Pawn())};
        p[0].setIALevel(firstPlayerLevel);
        p[1].setIALevel(secondPlayerLevel);
        b.setPlayer(p);
        b.createBoard();

        System.out.println(p[0].getIALevel());
    }
}
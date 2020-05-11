package be.nicolasdelp.quoridor;

import java.util.ArrayList;
import java.util.Collections;

import be.nicolasdelp.quoridor.graph.Graph;
import be.nicolasdelp.quoridor.objects.*;
import be.nicolasdelp.quoridor.rules.RuleViolated;

public class MainStat {

    public static void IAEasy(Board board, Player player) throws RuleViolated{
        ArrayList<Position> positionsToTry = new ArrayList<Position>(); // On cree et initialise les positions que l'on va essayer.
        for (int i = player.getPawn().getPosition().getX() - 2; i <= player.getPawn().getPosition().getX()+ 2; i += 2) {
            for (int j = player.getPawn().getPosition().getY() - 2; j <= player.getPawn().getPosition().getY()+ 2; j += 2) {
                if (!(i == player.getPawn().getPosition().getX() && j == player.getPawn().getPosition().getY())) { // On ne peut pas se déplacer sur la position actuelle du pion
                    positionsToTry.add(new Position(i, j));
                }
            }
        }
        Collections.shuffle(positionsToTry); // On melange les positions disponibles.

        boolean continueToTry = true;
        while (continueToTry) {
            Position currentPositionToTry = positionsToTry.remove(0); // Mets dans la variable avant de la supprimer
            try {
                continueToTry = false;
                board.movePawnOnBoard(player, new Position(currentPositionToTry.getX(), currentPositionToTry.getY()));
                board.nextPlayer();
            } catch (RuleViolated e) {
                continueToTry = true;
            }
        }
    }

    public static void IAHard(Board board, Player player) throws RuleViolated {
        Graph g = null;
        if(player == board.getAPlayer(0)){
            g = new Graph(board, board.getPlayers()[1]);
        }else if(player == board.getAPlayer(1)){
            g = new Graph(board, board.getPlayers()[0]);
        }
        g.pathForIA();

        int[] allPathSize = new int[9];
        for (int i = 0; i < player.getFinishPosition().length; i++) {
            if (g.pathFinding(player.getPawn().getPosition(), player.getFinishPosition()[i])) {
                // g.pathFinding(player.getPawn().getPosition(), player.getFinishPosition()[i]);
                allPathSize[i] = g.getPath().size();
            } else {
                allPathSize[i] = -1;
            }
        }
        int res = 100;
        for (int i = 0; i < allPathSize.length; i++) {
            if(allPathSize[i] != -1){
                if (allPathSize[i] < res) {
                    res = i;
                }
            }
        }
        if(res != 100 && res != -1){
            g.pathFinding(player.getPawn().getPosition(), player.getFinishPosition()[res]);
            board.movePawnOnBoard(player, new Position(g.getPath().get(0).getNodePosition().getX(), g.getPath().get(0).getNodePosition().getY()));
        }
        board.nextPlayer();
    }

    public static void main(String[] args) throws RuleViolated{
        int numberOfParty = 1000;
        String firstPlayerLevel = "Facile";
        String secondPlayerLevel = "Facile";

        int player1Win = 0;
        int player2Win = 0;

        int go = 0;
        while(go != numberOfParty){
            if(numberOfParty%2 == 0){
                Board b1 = new Board();
                Player[] p = { new Player("Ordinateur", "Joueur 1", 0, ColorPawn.Bleu, new Pawn()),
                                new Player("Ordinateur", "Joueur 2", 1, ColorPawn.Rouge, new Pawn()) };
                p[0].setIALevel(firstPlayerLevel);
                p[1].setIALevel(secondPlayerLevel);
                b1.setPlayer(p);
                b1.createBoard();
                
                while(!b1.getWin()){
                    if(b1.getcurrentIDPlayer() == 0){
                        if (b1.getAPlayer(0).getIALevel() == "Facile") {
                            IAEasy(b1, b1.getPlayers()[0]);
                        } else if(b1.getAPlayer(0).getIALevel() == "Difficile"){
                            IAHard(b1, b1.getPlayers()[0]);
                        }
                    } else if(b1.getcurrentIDPlayer() == 1){
                        if (b1.getAPlayer(1).getIALevel() == "Facile") {
                            IAEasy(b1, b1.getPlayers()[1]);
                        } else if(b1.getAPlayer(1).getIALevel() == "Difficile"){
                            IAHard(b1, b1.getPlayers()[1]);
                        }
                    }
                }
                if(b1.getWinnerPlayer().getID() == 0){
                    player1Win++;
                    System.out.println("L'IA " + b1.getAPlayer(0).getUsername() +  " a gagnée la partie " + go);
                } else if(b1.getWinnerPlayer().getID() == 1){
                    player2Win++;
                    System.out.println("L'IA " + b1.getAPlayer(1).getUsername() +  " a gagnée la partie " + go);
                }
            }
            if(numberOfParty%2 == 1){
                Board b2 = new Board();
                Player[] p = { new Player("Ordinateur", "Joueur 1", 0, ColorPawn.Bleu, new Pawn()),
                                new Player("Ordinateur", "Joueur 2", 1, ColorPawn.Rouge, new Pawn()) };
                p[1].setIALevel(firstPlayerLevel);
                p[0].setIALevel(secondPlayerLevel);
                b2.setPlayer(p);
                b2.createBoard();
                
                while(!b2.getWin()){
                    if(b2.getcurrentIDPlayer() == 0){
                        if (b2.getAPlayer(0).getIALevel() == "Facile") {
                            IAEasy(b2, b2.getPlayers()[0]);
                        } else if(b2.getAPlayer(0).getIALevel() == "Difficile"){
                            IAHard(b2, b2.getPlayers()[0]);
                        }
                    } else if(b2.getcurrentIDPlayer() == 1){
                        if (b2.getAPlayer(1).getIALevel() == "Facile") {
                            IAEasy(b2, b2.getPlayers()[1]);
                        } else if(b2.getAPlayer(1).getIALevel() == "Difficile"){
                            IAHard(b2, b2.getPlayers()[1]);
                        }
                    }
                }
                if(b2.getWinnerPlayer().getID() == 0){
                    player2Win++;
                    System.out.println("L'IA " + b2.getAPlayer(0).getUsername() + " a gagnée la partie " + go);
                } else if(b2.getWinnerPlayer().getID() == 1){
                    player1Win++;
                    System.out.println("L'IA " + b2.getAPlayer(1).getUsername() +  " a gagnée la partie " + go);
                }
            }
            go++;
        }
        System.out.println("\u001B[32m" + "------------------------------------------" + "\u001B[0m");
        System.out.println(numberOfParty + " parties ont été joués");
        System.out.println("L'IA " + firstPlayerLevel + " (Joueur 1) a gagnée " + player1Win + " parties sur " + numberOfParty);
        System.out.println("L'IA " + secondPlayerLevel + " (Joueur 2) a gagnée " + player2Win + " parties sur " + numberOfParty);
        System.out.println("\u001B[32m" + "------------------------------------------" + "\u001B[0m");
    }
}
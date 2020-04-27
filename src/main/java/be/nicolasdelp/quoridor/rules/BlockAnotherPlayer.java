package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class BlockAnotherPlayer implements WallRule {

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        player.moveWall(position); //On change le sens et la position du mur dans l'inventaire du joueur
        if(wall.getWallDirection() == WallDirection.Horizontal){ //Si il est horizontal on remplie les case a sa droite et a sa gauche
            board.getBoardBoxes()[position.getX()][position.getY()].setObject(wall);
            board.getBoardBoxes()[position.getX()+1][position.getY()].setObject(wall);
            board.getBoardBoxes()[position.getX()-1][position.getY()].setObject(wall);
            boolean[] ok1 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 1
            boolean[] ok2 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 2
            for (int i= 0; i < 9; i++){
                Graph g1 = new Graph(board, board.getPlayers()[1]);
                ok1[i] = g1.pathFinding(board.getPlayers()[0].getPawn().getPosition(), board.getPlayers()[0].getFinishPosition()[i]);
                Graph g2 = new Graph(board, board.getPlayers()[0]);
                ok2[i] = g2.pathFinding(board.getPlayers()[1].getPawn().getPosition(), board.getPlayers()[1].getFinishPosition()[i]);
            }
            int res1 = 0;
            for (int i= 0; i < ok1.length; i++){
                if(ok1[i] == false){
                    res1++;
                }
            }
            int res2 = 0;
            for (int i= 0; i < ok2.length; i++){
                if(ok2[i] == false){
                    res2++;
                }
            }
            if(res1 == 9 || res2 == 9){ //Si il n'y a eu aucun chemin
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur la, vous bloquez un joueur !");
            }
            board.getBoardBoxes()[position.getX()][position.getY()].setObject(null);
            board.getBoardBoxes()[position.getX()+1][position.getY()].setObject(null);
            board.getBoardBoxes()[position.getX()-1][position.getY()].setObject(null);
        }else if(wall.getWallDirection() == WallDirection.Vertical){ //Si il est vertical on remplie les case au dessus et en dessous
            board.getBoardBoxes()[position.getX()][position.getY()].setObject(wall);
            board.getBoardBoxes()[position.getX()][position.getY()+1].setObject(wall);
            board.getBoardBoxes()[position.getX()][position.getY()-1].setObject(wall);
            boolean[] ok1 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 1
            boolean[] ok2 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 2
            for (int i= 0; i < 9; i++){
                Graph g1 = new Graph(board, board.getPlayers()[1]);
                ok1[i] = g1.pathFinding(board.getPlayers()[0].getPawn().getPosition(), board.getPlayers()[0].getFinishPosition()[i]);
                Graph g2 = new Graph(board, board.getPlayers()[0]);
                ok2[i] = g2.pathFinding(board.getPlayers()[1].getPawn().getPosition(), board.getPlayers()[1].getFinishPosition()[i]);
            }
            int res1 = 0;
            for (int i= 0; i < ok1.length; i++){
                if(ok1[i] == false){
                    res1++;
                }
            }
            int res2 = 0;
            for (int i= 0; i < ok2.length; i++){
                if(ok2[i] == false){
                    res2++;
                }
            }
            if(res1 == 9 || res2 == 9){ //Si il n'y a eu aucun chemin
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur la, vous bloquez un joueur !");
            }
            board.getBoardBoxes()[position.getX()][position.getY()].setObject(null);
            board.getBoardBoxes()[position.getX()][position.getY()+1].setObject(null);
            board.getBoardBoxes()[position.getX()][position.getY()-1].setObject(null);
        }
    }
}
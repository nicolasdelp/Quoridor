package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.graph.Graph;
import be.nicolasdelp.quoridor.objects.*;

public class BlockAnotherPlayer implements WallRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        int res1 = 0;
        int res2 = 0;
        for (int i= 0; i < 9; i++){
            Graph g1 = new Graph(board, board.getPlayers()[1]);
            g1.setWall(wall.getWallDirection(), position);
            if(g1.pathFinding(board.getPlayers()[0].getPawn().getPosition(), board.getPlayers()[0].getFinishPosition()[i]) == false){
                res1++;
            }
            Graph g2 = new Graph(board, board.getPlayers()[0]);
            g2.setWall(wall.getWallDirection(), position);
            if(g2.pathFinding(board.getPlayers()[1].getPawn().getPosition(), board.getPlayers()[1].getFinishPosition()[i]) == false){
                res2++;
            }
        }
        if(res1 == 9){ //Si il n'y a eu aucun chemin
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur la, vous bloquez un joueur !");
        }
        if(res2 == 9){ //Si il n'y a eu aucun chemin
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur la, vous bloquez un joueur !");
        }
    }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//         Board newBoard = new Board();
//         Player[] p = {new Player(board.players[0].getType(), board.players[0].getUsername(), board.players[0].getID(), board.players[0].getColor(), board.players[0].getPawn()),
//                         new Player(board.players[1].getType(), board.players[1].getUsername(), board.players[1].getID(), board.players[1].getColor(), board.players[1].getPawn())};
//         newBoard.setPlayer(p);
//         newBoard.createBoard();
//         newBoard.getPlayers()[0].getPawn().setPosition(new Position(board.getPlayers()[0].getPawn().getPosition().getX(), board.getPlayers()[0].getPawn().getPosition().getY()));
//         newBoard.getPlayers()[1].getPawn().setPosition(new Position(board.getPlayers()[1].getPawn().getPosition().getX(), board.getPlayers()[0].getPawn().getPosition().getY()));

//         for (int i= 0; i < board.getBoardBoxes().length; i++){
//             System.arraycopy(board.getBoardBoxes()[i], 0, newBoard.getBoardBoxes()[i], 0, board.getBoardBoxes()[i].length);
//         }

//         if(wall.getWallDirection() == WallDirection.Horizontal){ //Si il est horizontal on remplie les case a sa droite et a sa gauche
//             newBoard.getBoardBoxes()[position.getX()][position.getY()].setObject(wall);
//             newBoard.getBoardBoxes()[position.getX()+1][position.getY()].setObject(wall);
//             newBoard.getBoardBoxes()[position.getX()-1][position.getY()].setObject(wall);
//             boolean[] ok1 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 1
//             boolean[] ok2 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 2
//             for (int i= 0; i < 9; i++){
//                 Graph g1 = new Graph(newBoard, newBoard.getPlayers()[1]);
//                 ok1[i] = g1.pathFinding(newBoard.getPlayers()[0].getPawn().getPosition(), newBoard.getPlayers()[0].getFinishPosition()[i]);
//                 Graph g2 = new Graph(newBoard, newBoard.getPlayers()[0]);
//                 ok2[i] = g2.pathFinding(newBoard.getPlayers()[1].getPawn().getPosition(), newBoard.getPlayers()[1].getFinishPosition()[i]);
//             }
//             int res1 = 0;
//             for (int i= 0; i < ok1.length; i++){
//                 if(ok1[i] == false){
//                     res1++;
//                 }
//             }
//             int res2 = 0;
//             for (int i= 0; i < ok2.length; i++){
//                 if(ok2[i] == false){
//                     res2++;
//                 }
//             }
//             if(res1 == 9 || res2 == 9){ //Si il n'y a eu aucun chemin
//                 throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur la, vous bloquez un joueur !");
//             }
//             newBoard.getBoardBoxes()[position.getX()][position.getY()].setObject(null);
//             newBoard.getBoardBoxes()[position.getX()+1][position.getY()].setObject(null);
//             newBoard.getBoardBoxes()[position.getX()-1][position.getY()].setObject(null);

//         }else if(wall.getWallDirection() == WallDirection.Vertical){ //Si il est vertical on remplie les case au dessus et en dessous
//             newBoard.getBoardBoxes()[position.getX()][position.getY()].setObject(wall);
//             newBoard.getBoardBoxes()[position.getX()][position.getY()+1].setObject(wall);
//             newBoard.getBoardBoxes()[position.getX()][position.getY()-1].setObject(wall);
//             boolean[] ok1 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 1
//             boolean[] ok2 = new boolean[9]; //Les 9 possiblilités d'arrivée du joueur 2
//             for (int i= 0; i < 9; i++){
//                 Graph g1 = new Graph(newBoard, newBoard.getPlayers()[1]);
//                 ok1[i] = g1.pathFinding(newBoard.getPlayers()[0].getPawn().getPosition(), newBoard.getPlayers()[0].getFinishPosition()[i]);
//                 Graph g2 = new Graph(newBoard, newBoard.getPlayers()[0]);
//                 ok2[i] = g2.pathFinding(newBoard.getPlayers()[1].getPawn().getPosition(), newBoard.getPlayers()[1].getFinishPosition()[i]);
//             }
//             int res1 = 0;
//             for (int i= 0; i < ok1.length; i++){
//                 if(ok1[i] == false){
//                     res1++;
//                 }
//             }
//             int res2 = 0;
//             for (int i= 0; i < ok2.length; i++){
//                 if(ok2[i] == false){
//                     res2++;
//                 }
//             }
//             if(res1 == 9 || res2 == 9){ //Si il n'y a eu aucun chemin
//                 throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur la, vous bloquez un joueur !");
//             }
//             newBoard.getBoardBoxes()[position.getX()][position.getY()].setObject(null);
//             newBoard.getBoardBoxes()[position.getX()][position.getY()+1].setObject(null);
//             newBoard.getBoardBoxes()[position.getX()][position.getY()-1].setObject(null);
//         }
//     }
// }
package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.graph.Graph;
import be.nicolasdelp.quoridor.objects.*;

/**
 * La class BlockAnotherPlayer est la regle qui empeche de bloquer l'adversaire avec un mur
 *
 * @author Delplanque Nicolas
 */
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
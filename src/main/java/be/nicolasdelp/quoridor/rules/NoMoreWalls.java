package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class NoMoreWalls est la regle qui empeche de poser un mur lorsque le joueur n'en a plus
 *
 * @author Delplanque Nicolas
 */
public class NoMoreWalls implements WallRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if(player.getOutOfWalls() == true){
            throw new RuleViolated(player, position, board, "Vous n'avez plus de murs !");
        }
    }
}
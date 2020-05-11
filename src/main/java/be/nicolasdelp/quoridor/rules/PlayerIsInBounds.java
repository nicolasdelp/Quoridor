package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class PlayerIsInBounds est la regle qui empeche de se deplacer en dehors du plateau
 *
 * @author Delplanque Nicolas
 */
public class PlayerIsInBounds implements PlayerRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if((position.getX() > 16) || (position.getX() < 0) || (position.getY() > 16) || (position.getY() < 0)){
            throw new RuleViolated(player, position, board, "Vous êtes en dehors des limites du plateau !");
        }
    }
}
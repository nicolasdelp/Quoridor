package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

public class WallIsInBounds implements WallRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if((position.getX() >= board.getLength()) || (position.getX() < 0) || (position.getY() >= board.getWidth() || (position.getY() < 0))){
            throw new RuleViolated(player, position, board, "Vous êtes en dehors des limites du plateau !");
        }
    }
}
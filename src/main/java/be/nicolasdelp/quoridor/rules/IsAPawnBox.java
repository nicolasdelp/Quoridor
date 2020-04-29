package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

public class IsAPawnBox implements WallRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if(board.getBoardBoxes()[position.getX()][position.getY()].getisPawnBox()){ //Si on essaye de bouger dans une case pour pion
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer un mur dans une case pour pion !");
        }
    }
}
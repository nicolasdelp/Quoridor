package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class IsAWallBox est la regle qui empeche de deplacer un pion dans une case pour mur
 *
 * @author Delplanque Nicolas
 */
public class IsAWallBox implements PlayerRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(board.getBoardBoxes()[position.getX()][position.getY()].getisWallBox()){ //Si on essaye de bouger dans une case pour mur
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancer dans une case pour mur !");
        }
    }
}
package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

public class PawnAlreadyHere implements PlayerRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped()){ //Verifie si la case à gauche n'est pas occupée
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
        }
    }
}
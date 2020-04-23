package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IsAWallBox implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(board.getBoardBoxes()[position.getX()][position.getY()].getisPawnBox() == false){ //Si on essaye de bouger dans une case pour mur
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancer dans une case pour mur !");
        }
    }
}
package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IsAPawnBox implements WallRule {

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if(board.getBoardBoxes()[position.getX()][position.getY()].getisWallBox() == false){ //Si on essaye de bouger dans une case pour pion
            throw new RuleViolated(player, position, board, "Vous ne pouvez pas placer de mur dans une case pour pion !");
        }
    }
}
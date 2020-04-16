package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class PlayerIsInBounds implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if((position.getX() >= board.getLength()) || (position.getX() < 0) || (position.getY() >= board.getWidth() || (position.getY() < 0))){
            throw new RuleViolated(player, position, board, "Vous êtes en dehors des limites du plateau !");
        }
    }
}
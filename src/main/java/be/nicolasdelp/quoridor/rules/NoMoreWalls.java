package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class NoMoreWalls implements WallRule {

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if(player.getWallIndex() < 0){
            throw new RuleViolated(player, position, board, "Vous n'avez plus de murs !");
        }
    }
}
package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class PlayerWin implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(player.getID() == 0){
            if(position.getX() == 16){
                throw new RuleViolated(player, position, board, "Vous avez gagne !!!");
            }
        }
        if(player.getID() == 1){
            if(position.getX() == 0){
                throw new RuleViolated(player, position, board, "Vous avez gagne !!!");
            }
        }
        if(player.getID() == 2){
            if(position.getY() == 16){
                throw new RuleViolated(player, position, board, "Vous avez gagne !!!");
            }
        }
        if(player.getID() == 3){
            if(position.getY() == 0){
                throw new RuleViolated(player, position, board, "Vous avez gagne !!!");
            }
        }
    }
}
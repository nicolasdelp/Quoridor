package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class OneBoxByStep implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(position.getX() > player.getPawn().getPosition().getX()+2){ //Si on essaye de bouger de plus de 1 case vers la droite avec le pion
            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
        }
        if(position.getX() < player.getPawn().getPosition().getX()-2){ //Si on essaye de bouger de plus de 1 case vers la gauche avec le pion
            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
        }
        if(position.getY() > player.getPawn().getPosition().getY()+2){ //Si on essaye de bouger de plus de 1 case vers le haut avec le pion 
            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
        }
        if(position.getY() < player.getPawn().getPosition().getY()-2){ //Si on essaye de bouger de plus de 1 case vers le bas avec le pion
            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
        }
    }
}
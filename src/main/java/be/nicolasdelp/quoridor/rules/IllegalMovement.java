package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IllegalMovement implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()-4){ //On va en haut en passant au-dessus d'un pion
            if(!board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getY() < player.getPawn().getPosition().getY()-2){ //On va en haut top loin
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()+4){ //On va en bas en passant au-dessus d'un pion
            if(!board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getY() > player.getPawn().getPosition().getY()+2){ //On va en bas trop loin
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-4 && position.getY() == player.getPawn().getPosition().getY()){ //On va a gauche en passant au-dessus d'un pion
            if(!board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getX() < player.getPawn().getPosition().getX()-2){ //On va a gauche trop loin
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+4 && position.getY() == player.getPawn().getPosition().getY()){ //On va a droite en passant au-dessus d'un pion
            if(!board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getX() > player.getPawn().getPosition().getX()+2){ //On va a droite trop loin
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2){ //On va en bas a droite
            if(!board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped()){ //Si il y a un pion
                if(!board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped()){ //Si il y a un pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2){ //On va en bas a gauche
            if(!board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped()){ //Si il y a un pion
                if(!board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped()){ //Si il y a un pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2){ //On va en haut a gauche
            if(!board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped()){ //Si il y a un pion
                if(!board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped()){ //Si il y a un pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2){ //On va en haut a droite
            if(!board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped()){ //Si il y a un pion
                if(!board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped()){ //Si il y a un pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
        }
    }
}
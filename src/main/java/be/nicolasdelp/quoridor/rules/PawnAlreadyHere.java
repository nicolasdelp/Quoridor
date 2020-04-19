package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class PawnAlreadyHere implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()){ //Si le joueur veut aller à gauche
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-2][player.getPawn().getPosition().getY()].getisOccuped()){ //Verifie si la case à gauche n'est pas occupée
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()){ //Si le joueur veut aller à droite
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+2][player.getPawn().getPosition().getY()].getisOccuped()){ //Verifie si la case à droite n'est pas occupée
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()+2){ //Si le joueur veut aller en bas
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+2].getisOccuped()){ //Verifie si la case du dessous n'est pas occupée
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()-2){ //Si le joueur veut aller en haut
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-2].getisOccuped()){ //Verifie si la case du dessus n'est pas occupée
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2){ //On va en bas a droite
            if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2){ //On va en bas a gauche
            if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2){ //On va en haut a gauche
            if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2){ //On va en haut a droite
            if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped()){ //Si il y a un pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas aller dans cette case, il y a deja un pion !");
            }
        }
    }
}
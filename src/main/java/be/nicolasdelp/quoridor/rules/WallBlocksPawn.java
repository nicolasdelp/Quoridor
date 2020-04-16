package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class WallBlocksPawn implements WallRule {

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if(player.getPawn().getPosition().getX()-1 > 0){ //Verifie si on est toujours dans le plateau si on bouge à gauche
            if(board.getBoardBox(new Position(player.getPawn().getPosition().getX()-1, player.getPawn().getPosition().getY())).getisOccuped()){ //Verifie si la case à gauche n'est pas occupée
                if(player.getPawn().getPosition().getX()-2 == position.getX()){ //Si le joueur veut aller à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(player.getPawn().getPosition().getX()+1 < board.getLength()){ //Verifie si on est toujours dans le plateau si on bouge à droite
            if(board.getBoardBox(new Position(player.getPawn().getPosition().getX()+1, player.getPawn().getPosition().getY())).getisOccuped()){ //Verifie si la case à droite n'est pas occupée
                if(player.getPawn().getPosition().getX()+2 == position.getX()){ //Si le joueur veut aller à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(player.getPawn().getPosition().getY()-1 > 0){ //Verifie si on est toujours dans le plateau si on bouge en bas
            if(board.getBoardBox(new Position(player.getPawn().getPosition().getX(), player.getPawn().getPosition().getY()-1)).getisOccuped()){ //Verifie si la case du dessous n'est pas occupée
                if(player.getPawn().getPosition().getY()-2 == position.getY()){ //Si le joueur veut aller en bas
                    throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(player.getPawn().getPosition().getY()+1 < board.getWidth()){ //Verifie si on est toujours dans le plateau si on bouge en haut
            if(board.getBoardBox(new Position(player.getPawn().getPosition().getX(), player.getPawn().getPosition().getY()+1)).getisOccuped()){ //Verifie si la case du dessus n'est pas occupée
                if(player.getPawn().getPosition().getY()+2 == position.getY()){ //Si le joueur veut aller en haut
                    throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
    }
}
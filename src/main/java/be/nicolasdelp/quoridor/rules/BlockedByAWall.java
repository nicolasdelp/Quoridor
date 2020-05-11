package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class BlockByAWall est la regle qui empeche de passer au dessus d'un mur
 *
 * @author Delplanque Nicolas
 */
public class BlockedByAWall implements PlayerRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        int x = Math.abs(position.getX() - player.getPawn().getPosition().getX());
        int y = Math.abs(position.getY() - player.getPawn().getPosition().getY());

        if(position.getX() - player.getPawn().getPosition().getX() > 0){ //Si on va a droite
            for(int i = 0; i < x; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+i][player.getPawn().getPosition().getY()].getisWallBox() //On regarde si la case est une case pour mur
                    && board.getBoardBoxes()[player.getPawn().getPosition().getX()+i][player.getPawn().getPosition().getY()].getisOccuped()){ //On regarde si la case est occupee
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(position.getX() - player.getPawn().getPosition().getX() < 0){ //Si on va a gauche
            for(int i = 0; i < x; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-i][player.getPawn().getPosition().getY()].getisWallBox() //On regarde si la case est une case pour mur
                    && board.getBoardBoxes()[player.getPawn().getPosition().getX()-i][player.getPawn().getPosition().getY()].getisOccuped()){ //On regarde si la case est occupee
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(position.getY() - player.getPawn().getPosition().getY() > 0){ //Si on va en bas
            for(int i = 1; i < y; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+i].getisWallBox() //On regarde si la case est une case pour mur
                    && board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+i].getisOccuped()){ //On regarde si la case est occupee
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(position.getY() - player.getPawn().getPosition().getY() < 0){ //Si on va en haut
            for(int i = 0; i < y; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-i].getisWallBox()){ //On regarde si la case est une case pour mur
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-i].getisOccuped()){ //On regarde si la case est occupee
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                    }
                }
            }
        }
    }
}
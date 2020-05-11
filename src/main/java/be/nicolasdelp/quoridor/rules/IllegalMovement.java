package be.nicolasdelp.quoridor.rules;

import java.io.Serializable;

import be.nicolasdelp.quoridor.objects.*;

/**
 * La class IllegalMovement est la regle qui empeche les deplacement interdits
 *
 * @author Delplanque Nicolas
 */
public class IllegalMovement implements PlayerRule, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()){ //Si on se deplace dans la case ou l'on se trouve deja
            throw new RuleViolated(player, position, board, "Vous devez soit changer de case, soit poser un mur !");
        }

        if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Si on va en haut a gauche
            if(position.getX() == 0 && position.getY() == 0){ //Si on arrive en (0,0)
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false) 
                    && board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else if(position.getX() == 0){ //Si on arrive en (0,..)
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()-1].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else if(position.getY() == 0){ //Si on arrive en (..,0)
                if((board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()+2].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else{ //Si on arrive autre part sur le plateau (..,..)
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()+2].getisOccuped() == false)
                    && (board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()-1].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
        }
        if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Si on va en haut a droite
            if(position.getX() == 16 && position.getY() == 0){ //Si on arrive en (16,0)
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false) 
                    && board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else if(position.getX() == 16){ //Si on arrive en (16,..)
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()-1].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else if(position.getY() == 0){ //Si on arrive en (..,0)
                if((board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()+2].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else { //Si on arrive autre part sur le plateau (..,..)
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()+2].getisOccuped() == false)
                    && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()-1].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
        }
        if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Si on va en bas a droite
            if(position.getX() == 16 && position.getY() == 16){ //Si on arrive en (16,16)
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false) 
                    && board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }else if(position.getX() == 16){ //Si on arrive en (16,..)
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }else if(position.getY() == 16){ //Si on arrive en (..,16)
                if((board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else { //Si on arrive autre part sur le plateau (..,..)
                if((board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
        }
        if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Si on va en bas a gauche
            if(position.getX() == 0 && position.getY() == 16){ //Si on arrive en (0,16)
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false) 
                    && board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }else if(position.getX() == 0){ //Si on arrive en (0,..)
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()+1].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }else if(position.getY() == 16){ //Si on arrive en (..,16)
                if((board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()-2].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            } else { //Si on arrive autre part sur le plateau (..,..)
                if((board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()+1].getisOccuped() == false) 
                    && (board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()-2].getisOccuped() == false)){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()-4){ //Si on va vers le haut de 2 cases
            if(!board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        } else if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()+4){ //Si on va vers le bas de 2 cases
            if(!board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        } else if(position.getX() == player.getPawn().getPosition().getX()-4 && position.getY() == player.getPawn().getPosition().getY()){ //Si on va vers la gauche de 2 cases
            if(!board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        } else if(position.getX() == player.getPawn().getPosition().getX()+4 && position.getY() == player.getPawn().getPosition().getY()){ //Si on va vers la droite de 2 cases
                if(!board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
                }
        } else {
            if(position.getX() > player.getPawn().getPosition().getX()+3 || position.getX() < player.getPawn().getPosition().getX()-3
                || position.getY() > player.getPawn().getPosition().getY()+3 || position.getY() < player.getPawn().getPosition().getY()-3){ //Si on deplace de plus de 2 cases
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
    }
}
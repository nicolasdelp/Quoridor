package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IllegalMovement implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()){ //Si on se déplace dans la case où l'on se trouve déjà
            throw new RuleViolated(player, position, board, "Vous devez soit changer de case, soit poser un mur !");
        }

        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()-4){ //Si on va vers le haut de 2 cases
            if(!board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getY() < player.getPawn().getPosition().getY()-2){ //Si on va vers le haut de plus de 2 cases
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }

        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()+4){ //Si on va vers le bas de 2 cases
            if(!board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getY() > player.getPawn().getPosition().getY()+2){ //Si on va vers le bas de plus de 2 cases
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }

        if(position.getX() == player.getPawn().getPosition().getX()-4 && position.getY() == player.getPawn().getPosition().getY()){ //Si on va vers la gauche de 2 cases
            if(!board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getX() < player.getPawn().getPosition().getX()-2){ //Si on va vers la gauche de plus de 2 cases
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }

        if(position.getX() == player.getPawn().getPosition().getX()+4 && position.getY() == player.getPawn().getPosition().getY()){ //Si on va vers la droite de 2 cases
            if(!board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped()){ //S'il n'y a pas de pion entre-deux
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }
        else {
            if(position.getX() > player.getPawn().getPosition().getX()+2){ //Si on va vers la droite de plus de 2 cases
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de 1 case a la fois !");
            }
        }

        if(position.getX() == 0){ //Gauche
            if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Haut gauche
                if(position.getY() == 0){ //(0,0)
                    if(board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false && board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                } else { //(0,..)
                    if(board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false && (board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()-1].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
            if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas gauche
                if(position.getY() == 16){ //(0,16)
                    if(board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false && board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                } else { //(0,..)
                    if((board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()+1].getisOccuped() == false) && board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
        }else if(position.getX() == 16){ //Droite
            if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Haut droite
                if(position.getY() == 0){ //(16,0)
                    if(board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false && board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                } else { //(16,..)
                    if(board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()-1].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
            if(position.getY() == 16){ //(16,16)
                if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas droite
                    if(board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false  && board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            } else { //(16,..)
                if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas droite
                    if(board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
        }else if(position.getY() == 0){ //Haut
            if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Haut droite
                if(position.getX() == 16){ //(16,0)
                    if(board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false && board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                } else { //(..,0)
                    if(board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false && (board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()+2].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
            if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Haut gauche
                if(position.getX() == 0){ //(0,0)
                    if(board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false && board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                } else { //(..,0)
                    if(board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false && (board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()+2].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
        }else if(position.getY() == 16){ //Bas
            if(position.getX() == 16){ //(16,16)
                if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas droite
                    if(board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false && board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            } else { //(..,16)
                if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas droite
                    if(board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false && (board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }
            if(position.getX() == 0){ //(0,16)
                if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas gauche
                    if(board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false && board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            } else { //(..,16)
                if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas gauche
                    if(board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false && (board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()-2].getisOccuped() == false)){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                    }
                }
            }   
        }else {
            if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Haut droite
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() == false) //Mur ou pion = false
                    && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()-1].getisOccuped() == false)){ //Mur ou pion = false
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
            if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()-2)){ //Haut gauche
                if((board.getBoardBoxes()[position.getX()][position.getY()+2].getisOccuped() == false ||  board.getBoardBoxes()[position.getX()-1][position.getY()+2].getisOccuped() == false) //Mur ou pion = false
                    && (board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()-1].getisOccuped() == false)){ //Mur ou pion = false
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
            if((position.getX() == player.getPawn().getPosition().getX()+2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas droite
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() == false) //Mur ou pion = false
                    && (board.getBoardBoxes()[position.getX()-2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped() == false)){ //Mur ou pion = false
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
            if((position.getX() == player.getPawn().getPosition().getX()-2) && (position.getY() == player.getPawn().getPosition().getY()+2)){ //Bas gauche
                if((board.getBoardBoxes()[position.getX()][position.getY()-2].getisOccuped() == false || board.getBoardBoxes()[position.getX()-1][position.getY()-2].getisOccuped() == false) //Mur ou pion = false
                    && (board.getBoardBoxes()[position.getX()+2][position.getY()].getisOccuped() == false || board.getBoardBoxes()[position.getX()+2][position.getY()+1].getisOccuped() == false)){ //Mur ou pion = false
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'etes pas bloque !");
                }
            }
        }
    }
}
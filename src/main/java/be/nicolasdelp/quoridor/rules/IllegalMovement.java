package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IllegalMovement implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()-4){ //On va en haut
            if(!board.getBoardBoxes()[position.getX()][position.getY()+1].getisOccuped()){ //Si il y a un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()][position.getY()-1].getisOccuped()){ //Si il y a un mur on ne peut pas avancer de plus de 1 case
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2){ //On va en-haut a droite
            if(!board.getBoardBoxes()[position.getX()-2][position.getY()-1].getisOccuped() || !board.getBoardBoxes()[position.getX()+1][position.getY()+2].getisOccuped()){ //Si il y avait un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()-2][position.getY()-1].getisOccuped() || board.getBoardBoxes()[position.getX()+1][position.getY()+2].getisOccuped()){
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+4 && position.getY() == player.getPawn().getPosition().getY()){ //On va a droite
            if(!board.getBoardBoxes()[position.getX()-1][position.getY()].getisOccuped()){ //Si il n'y a pas de mur alors on peut paut pas utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()-1][position.getY()].getisOccuped()){ //Si il y a u mur on ne peut pas passer au dessus du pion
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2){ //On va en-bas a droite
            if(!board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() || !board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped()){ //Si il y avait un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()+1][position.getY()-2].getisOccuped() || board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped()){
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX() && position.getY() == player.getPawn().getPosition().getY()+4){ //On va en-bas
            if(!board.getBoardBoxes()[position.getX()][position.getY()-1].getisOccuped()){ //Si il y avait un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()][position.getY()-1].getisOccuped()){
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2){ //On va en-bas a gauche
            if(!board.getBoardBoxes()[position.getX()-1][position.getY()-2].getisOccuped() || !board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped()){ //Si il y avait un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()-1][position.getY()-2].getisOccuped() || board.getBoardBoxes()[position.getX()-2][position.getY()+1].getisOccuped()){
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-4 && position.getY() == player.getPawn().getPosition().getY()){ //On va a gauche
            if(!board.getBoardBoxes()[position.getX()+1][position.getY()].getisOccuped()){ //Si il y avait un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()+1][position.getY()].getisOccuped()){
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }
        if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2){ //On va en-haut a gauche
            if(!board.getBoardBoxes()[position.getX()-1][position.getY()+2].getisOccuped() || !board.getBoardBoxes()[position.getX()+2][position.getY()-1].getisOccuped()){ //Si il y avait un mur alors on peut utiliser la diagonale
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 //Si on utilise les diagonale
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2
                    || position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2
                    || position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
                }
            }
            if(board.getBoardBoxes()[position.getX()-1][position.getY()+2].getisOccuped() || board.getBoardBoxes()[position.getX()+2][position.getY()-1].getisOccuped()){
                if(position.getX() > player.getPawn().getPosition().getX()+2 //Si on va trop loin
                    || position.getX() < player.getPawn().getPosition().getX()-2
                    || position.getY() > player.getPawn().getPosition().getY()+2
                    || position.getY() < player.getPawn().getPosition().getY()-2){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
                }
            }
        }else {
            if(position.getX() > player.getPawn().getPosition().getX()+2){ //Si on essaye de bouger de plus de 1 case vers la droite avec le pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
            }
            if(position.getX() < player.getPawn().getPosition().getX()-2){ //Si on essaye de bouger de plus de 1 case vers la gauche avec le pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
            }
            if(position.getY() > player.getPawn().getPosition().getY()+2){ //Si on essaye de bouger de plus de 1 case vers le haut avec le pion 
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
            }
            if(position.getY() < player.getPawn().getPosition().getY()-2){ //Si on essaye de bouger de plus de 1 case vers le bas avec le pion
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case a la fois !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut a droite
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut a gauche
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas a droite
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas a gauche
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n etes pas bloque !");
            }
        }
    }
}
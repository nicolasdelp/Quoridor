package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IllegalMovement implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+2].getisOccuped()){ //Si la case en haut est occupé par un pion
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+3].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Posibilité
                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()-2){
                        if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){
                                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                }
                            }
                        }
                    }
                }
            }
            else{ //Si il n'y a pas de mur derriere le pion adverse
                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-4){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getX() < player.getPawn().getPosition().getX()-2){ //Si on essaye de bouger de plus de 1 case vers la gauche avec le pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getY() > player.getPawn().getPosition().getY()+2){ //Si on essaye de bouger de plus de 1 case vers le haut avec le pion 
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getY() < player.getPawn().getPosition().getY()-4){ //Si on essaye de bouger de plus de 1 case vers le bas avec le pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
            }
        }
        if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-2].getisOccuped()){ //Si la case en bas est occupé par un pion
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-3].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Les 5 cases possibles
                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()+2){
                        if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){
                                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                }
                            }
                        }
                    }
                }
            }
            else{ //Si il n'y a pas de mur derriere le pion adverse
                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+4){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getX() < player.getPawn().getPosition().getX()-2){ //Si on essaye de bouger de plus de 1 case vers la gauche avec le pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getY() > player.getPawn().getPosition().getY()+4){ //Si on essaye de bouger de plus de 1 case vers le haut avec le pion 
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getY() < player.getPawn().getPosition().getY()-2){ //Si on essaye de bouger de plus de 1 case vers le bas avec le pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
            }
        }
        if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+2][player.getPawn().getPosition().getY()].getisOccuped()){ //Si la case à droite est occupé par un pion
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+3][player.getPawn().getPosition().getY()].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Les 5 cases possibles
                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()-2){
                        if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){
                                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                }
                            }
                        }
                    }
                }
            }
            else{ //Si il n'y a pas de mur derriere le pion adverse
                if(position.getX() != player.getPawn().getPosition().getX()+4 && position.getY() != player.getPawn().getPosition().getY()){
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
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
            }
        }
        if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-2][player.getPawn().getPosition().getY()].getisOccuped()){ //Si la case à gauche est occupé par un pion
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-3][player.getPawn().getPosition().getY()].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Les 5 cases possibles
                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){
                        if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()-2){
                                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                }
                            }
                        }
                    }
                }
            }
            else{ //Si il n'y a pas de mur derriere le pion adverse
                if(position.getX() != player.getPawn().getPosition().getX()-4 && position.getY() != player.getPawn().getPosition().getY()){
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getX() < player.getPawn().getPosition().getX()-4){ //Si on essaye de bouger de plus de 2 case vers la gauche avec le pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getY() > player.getPawn().getPosition().getY()+2){ //Si on essaye de bouger de plus de 1 case vers le haut avec le pion 
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getY() < player.getPawn().getPosition().getY()-2){ //Si on essaye de bouger de plus de 1 case vers le bas avec le pion
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que de une case à la fois !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à droite
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
                if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à gauche
                    throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
                }
            }
        }
        else{
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
            if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à droite
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()+2 ){ //Si le joueur veut aller en diagonal en haut à gauche
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()+2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à droite
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
            }
            if(position.getX() == player.getPawn().getPosition().getX()-2 && position.getY() == player.getPawn().getPosition().getY()-2 ){ //Si le joueur veut aller en diagonal en bas à gauche
                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que vers le haut, le bas, la droite et la gauche si vous n'êtes pas bloqué !");
            }
        }
    }
}
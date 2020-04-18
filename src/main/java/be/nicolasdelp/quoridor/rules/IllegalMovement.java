package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class IllegalMovement implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        if(player.getPawn().getPosition().getY() >= 2){
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-2].getisOccuped()){ //Si la case en haut est occupé par un pion
                if(player.getPawn().getPosition().getY()-4 >= 0){ //Vérifie si il y a une case deriere le pion adverse
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-3].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getX() == 0){ //Si le pion est à la limite du plateau à gauche
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à droite
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getX() == 16){ //Si le pion est à la limite du plateau à droite
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à gauche
                                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes du plateau
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à gauche
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à droite
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } 
                    else{ //Si il n'y a pas un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getX() == 0){ //Si le pion est à la limite du plateau à gauche
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-4){ //Vers le haut (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getX() == 16){ //Si le pion est à la limite du plateau à droite
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-4){ //Vers le haut (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-4){ //Vers le haut (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{ //Les autres cas si aucun pion ne bloque
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
//--------------------------------------------------
//--------------------------------------------------
//--------------------------------------------------
//--------------------------------------------------
        if(player.getPawn().getPosition().getY() <= 14){
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+2].getisOccuped()){ //Si la case en bas est occupé par un pion
                if(player.getPawn().getPosition().getY()+4 <= 16){ //Vérifie si il y a une case deriere le pion adverse
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+3].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getX() == 0){ //Si le pion est à la limite du plateau à gauche
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à droite
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getX() == 16){ //Si le pion est à la limite du plateau à droite
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à gauche
                                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes du plateau
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à gauche
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à droite
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } 
                    else{ //Si il n'y a pas un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getX() == 0){ //Si le pion est à la limite du plateau à gauche
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+4){ //Vers le bas (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getX() == 16){ //Si le pion est à la limite du plateau à droite
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+4){ //Vers le bas (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                    if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes
                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+4){ //Vers le bas (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{ //Les autres cas si aucun pion ne bloque
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
//--------------------------------------------------
//--------------------------------------------------
//--------------------------------------------------
//--------------------------------------------------
        if(player.getPawn().getPosition().getX() >= 2){
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-2][player.getPawn().getPosition().getY()].getisOccuped()){ //Si la case à gauche est occupé par un pion
                if(player.getPawn().getPosition().getX()-4 <= 16){ //Vérifie si il y a une case deriere le pion adverse
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-3][player.getPawn().getPosition().getY()].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getY() == 0){ //Si le pion est à la limite du plateau en haut
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à gauche
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getY() == 16){ //Si le pion est à la limite du plateau en bas
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à gauche
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes du plateau
                            if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à gauche
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à gauche
                                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } 
                    else{ //Si il n'y a pas un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getY() == 0){ //Si le pion est à la limite du plateau en haut
                            if(position.getX() != player.getPawn().getPosition().getX()-4 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getY() == 16){ //Si le pion est à la limite du plateau en bas
                            if(position.getX() != player.getPawn().getPosition().getX()-4 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes
                            if(position.getX() != player.getPawn().getPosition().getX()-4 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite
                                        if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{ //Les autres cas si aucun pion ne bloque
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
//--------------------------------------------------
//--------------------------------------------------
//--------------------------------------------------
//--------------------------------------------------
        if(player.getPawn().getPosition().getX() <= 14){
            if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+2][player.getPawn().getPosition().getY()].getisOccuped()){ //Si la case à doite est occupé par un pion
                if(player.getPawn().getPosition().getX()+4 <= 16){ //Vérifie si il y a une case deriere le pion adverse
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+3][player.getPawn().getPosition().getY()].getisOccuped()){ //Si il y a un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getY() == 0){ //Si le pion est à la limite du plateau en haut
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à droite
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getY() == 16){ //Si le pion est à la limite du plateau en bas
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à droite
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes du plateau
                            if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut à droite
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        if(position.getX() != player.getPawn().getPosition().getX()+2 && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas à droite
                                            if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                                throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } 
                    else{ //Si il n'y a pas un mur derriere l'adversaire
                        if(player.getPawn().getPosition().getY() == 0){ //Si le pion est à la limite du plateau en haut
                            if(position.getX() != player.getPawn().getPosition().getX()+4 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        if(player.getPawn().getPosition().getY() == 16){ //Si le pion est à la limite du plateau en bas
                            if(position.getX() != player.getPawn().getPosition().getX()+4 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                    }
                                }
                            }
                        }
                        else{ //Si il n'est pas sur les cotes
                            if(position.getX() != player.getPawn().getPosition().getX()+4 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la droite (passer au dessus du pion adverses)
                                if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()-2){ //Vers le haut
                                    if(position.getX() != player.getPawn().getPosition().getX()-2 && position.getY() != player.getPawn().getPosition().getY()){ //Vers la gauche
                                        if(position.getX() != player.getPawn().getPosition().getX() && position.getY() != player.getPawn().getPosition().getY()+2){ //Vers le bas
                                            throw new RuleViolated(player, position, board, "Vous ne pouvez avancer que dans les cases à côté de votre adversaire !");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{ //Les autres cas si aucun pion ne bloque
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
}
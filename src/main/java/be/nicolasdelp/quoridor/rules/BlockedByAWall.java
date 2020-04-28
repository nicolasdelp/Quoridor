package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class BlockedByAWall implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        int x = Math.abs(position.getX() - player.getPawn().getPosition().getX());
        int y = Math.abs(position.getY() - player.getPawn().getPosition().getY());

        if(position.getX() - player.getPawn().getPosition().getX() > 0){ //Si on va à droite
            for(int i = 0; i < x; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+i][player.getPawn().getPosition().getY()].getisWallBox() //On regarde si la case est une case pour mur
                    && board.getBoardBoxes()[player.getPawn().getPosition().getX()+i][player.getPawn().getPosition().getY()].getisOccuped()){ //On regarde si la case est occupée
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(position.getX() - player.getPawn().getPosition().getX() < 0){ //Si on va à gauche
            for(int i = 0; i < x; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-i][player.getPawn().getPosition().getY()].getisWallBox() //On regarde si la case est une case pour mur
                    && board.getBoardBoxes()[player.getPawn().getPosition().getX()-i][player.getPawn().getPosition().getY()].getisOccuped()){ //On regarde si la case est occupée
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(position.getY() - player.getPawn().getPosition().getY() > 0){ //Si on va en bas
            for(int i = 1; i < y; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+i].getisWallBox() //On regarde si la case est une case pour mur
                    && board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+i].getisOccuped()){ //On regarde si la case est occupée
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                }
            }
        }
        if(position.getY() - player.getPawn().getPosition().getY() < 0){ //Si on va en haut
            for(int i = 0; i < y; i++){ //On regarde chaque case entre le pion et sa future position
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-i].getisWallBox()){ //On regarde si la case est une case pour mur
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-i].getisOccuped()){ //On regarde si la case est occupée
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                    }
                }
            }
        }
    }
}


//ANCIEN CODE

// if(position.getX() < player.getPawn().getPosition().getX()){ //Si on change de collone (en allant à gauche)
//     if(x == player.getPawn().getPosition().getX()){ //Si on arrive dans la collone 0 (car x - 0 = x)
//         if(board.getBoardBoxes()[position.getX()+1][position.getY()].getisOccuped()){ //Si il y a un mur dans la case de la collone 1
//             throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
//         }
//     }
// }

// if(position.getY() != player.getPawn().getPosition().getY()){ //Si on change de ligne (en allant en haut)
//     if(y == player.getPawn().getPosition().getY()){ //Si on arrive dans la ligne 0 (car y - 0 = y)
//         if(board.getBoardBoxes()[position.getX()][position.getY()+1].getisOccuped()){ //Si il y a un mur dans la case de la ligne 1
//             throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
//         }
//     }
// }
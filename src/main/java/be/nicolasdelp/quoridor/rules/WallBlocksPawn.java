package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class WallBlocksPawn implements PlayerRule {

    @Override
    public void verify(Board board, Player player, Position position) throws RuleViolated{
        int x = Math.abs(position.getX() - player.getPawn().getPosition().getX());
        int y = Math.abs(position.getY() - player.getPawn().getPosition().getY());
        if(position.getX() - player.getPawn().getPosition().getX() > 0){
            for(int i = 0; i< x; i++){
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+i][player.getPawn().getPosition().getY()].getisWallBox()){
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()+i][player.getPawn().getPosition().getY()].getisOccuped()){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                    }
                }
            }
        }
        if(position.getX() - player.getPawn().getPosition().getX() < 0){
            for(int i = 0; i< x; i++){
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-i][player.getPawn().getPosition().getY()].getisWallBox()){
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()-i][player.getPawn().getPosition().getY()].getisOccuped()){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                    }
                }
            }
        }
        if(x == player.getPawn().getPosition().getX()){ //Pour la première colone
            if(board.getBoardBoxes()[position.getX()+1][position.getY()].getisOccuped()){
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
            }
        }
        if(position.getY() - player.getPawn().getPosition().getY() > 0){
            for(int i = 0; i< y; i++){
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+i].getisWallBox()){
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()+i].getisOccuped()){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                    }
                }
            }
        }
        if(position.getY() - player.getPawn().getPosition().getY() < 0){
            for(int i = 0; i< y; i++){
                if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-i].getisWallBox()){
                    if(board.getBoardBoxes()[player.getPawn().getPosition().getX()][player.getPawn().getPosition().getY()-i].getisOccuped()){
                        throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
                    }
                }
            }
        }
        if(y == player.getPawn().getPosition().getY()){ //Pour la première ligne
            if(board.getBoardBoxes()[position.getX()][position.getY()+1].getisOccuped()){
                throw new RuleViolated(player, position, board, "Vous ne pouvez pas avancez, il y a un mur !");
            }
        }
    }
}
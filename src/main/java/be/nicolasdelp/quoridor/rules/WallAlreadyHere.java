package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class WallAlreadyHere implements WallRule {

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        if(wall.getWallDirection() == WallDirection.Horizontal){
            if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped() || board.getBoardBoxes()[position.getX()+1][position.getY()].getisOccuped() || board.getBoardBoxes()[position.getX()-1][position.getY()].getisOccuped()){
                throw new RuleViolated(player, position, board, "Il y a deja un mur a cet emplacement, changez le sens de votre mur ou changez d'emplacement !");
            }
        }
        if(wall.getWallDirection() == WallDirection.Vertical){
            if(board.getBoardBoxes()[position.getX()][position.getY()].getisOccuped() || board.getBoardBoxes()[position.getX()][position.getY()+1].getisOccuped() || board.getBoardBoxes()[position.getX()][position.getY()-1].getisOccuped()){
                throw new RuleViolated(player, position, board, "Il y a deja un mur a cet emplacement, changez le sens de votre mur ou changez d'emplacement !");
            }
        }
    }
}
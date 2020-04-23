package be.nicolasdelp.quoridor.rules;

import be.nicolasdelp.quoridor.objects.*;

public class BlockAnotherPlayer implements WallRule {

    @Override
    public void verify(Board board, Player player, Wall wall, Position position) throws RuleViolated{
        Board newBoard = board;
        boolean Stop = false;
        for(int i = 0; i < newBoard.players.length; i++){
            if(newBoard.players[i] == newBoard.players[0]){
                Position source = newBoard.players[0].getPawn().getPosition();
                int xDestination = 16;
                Position[] aExplorer = new Position[4];
                Position[] dejaExplorer = new Position[81]; //81 = 9*9
                dejaExplorer[0] = newBoard.players[0].getPawn().getPosition();
                for(int x = 0; x < aExplorer.length; x++){
                    for(int y = 0; y < aExplorer.length; y++){
                        if(aExplorer[x].getX() == xDestination){
                            Stop = true;
                        }
                    }
                }
                while(!Stop){
                    
                }
            }
        }
    }
}
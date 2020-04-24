package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.rules.RuleViolated;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGraph(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,1));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,3));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(1,9));
            b.setWallOnBoard(b.players[1], new Wall(), WallDirection.Horizontal, new Position(1,11));
            b.setWallOnBoard(b.players[1], new Wall(), WallDirection.Horizontal, new Position(1,13));
            b.setWallOnBoard(b.players[1], new Wall(), WallDirection.Horizontal, new Position(1,15));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b);
        assertEquals(g.getListOfLinks().get(0).getFromNode().getNodePosition().getX(), 4);
        assertEquals(g.getListOfLinks().get(0).getFromNode().getNodePosition().getY(), 0);
        assertEquals(g.getListOfLinks().get(0).getToNode().getNodePosition().getX(), 4);
        assertEquals(g.getListOfLinks().get(0).getToNode().getNodePosition().getY(), 2);
    }
}
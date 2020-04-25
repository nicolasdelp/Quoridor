package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.rules.RuleViolated;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGraph(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,1));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,13));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(3,15));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b, b.players[1]);
        assertEquals(g.dijkstra(b.players[0].getPawn().getPosition(), new Position(16,4)), false);
    }
}
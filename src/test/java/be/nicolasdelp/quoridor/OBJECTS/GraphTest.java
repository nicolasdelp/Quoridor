package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.rules.RuleViolated;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGraph1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,1));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,13));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b, b.players[1]);
        g.setWall(WallDirection.Vertical, new Position(3,15));
        assertEquals(g.pathFinding(b.players[0].getPawn().getPosition(), new Position(16,6)), true);
    }

    @Test
    public void testGraph2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(1,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Horizontal, new Position(3,5));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b, b.players[1]);
        g.setWall(WallDirection.Horizontal, new Position(3,9));
        assertEquals(g.pathFinding(b.players[0].getPawn().getPosition(), new Position(16,6)), false);
    }

    @Test
    public void testGraph3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,1));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,13));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,15));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,11));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,3));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b, b.players[1]);
        g.setWall(WallDirection.Vertical, new Position(9,1));
        assertEquals(g.pathFinding(b.players[0].getPawn().getPosition(), new Position(16,6)), true);
    }

    @Test
    public void testGraph4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.players[0], new Position(2, 8));
            b.movePawnOnBoard(b.players[0], new Position(4, 8));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,1));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,5));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,9));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(5,13));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,15));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,11));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,7));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(7,3));
            b.setWallOnBoard(b.players[0], new Wall(), WallDirection.Vertical, new Position(9,1));
        } catch (RuleViolated e) {
            System.out.println(e);
        }
        Graph g = new Graph(b, b.players[1]);
        g.setWall(WallDirection.Horizontal, new Position(9,3));
        assertEquals(g.pathFinding(b.players[0].getPawn().getPosition(), new Position(16,6)), false);
    }
}
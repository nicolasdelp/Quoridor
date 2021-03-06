package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testCreateBoard1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getPlayers()[0].getWallIndex(), 9);
    }

    @Test
    public void testCreateBoard2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getBoardBoxes()[10][4].getisPawnBox(), true);
        assertEquals(b.getBoardBoxes()[3][5].getisPawnBox(), false);
        assertEquals(b.getBoardBoxes()[16][16].getisPawnBox(), true);
        assertEquals(b.getBoardBoxes()[0][0].getisPawnBox(), true);
    }

    @Test
    public void testCreateBoard3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getPlayers()[0].getPawn().getPosition().getX(), 0);
        assertEquals(b.getPlayers()[0].getPawn().getPosition().getY(), 8);
    }

    @Test
    public void testCreateBoard4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getPlayers()[1].getPawn().getPosition().getX(), 16);
        assertEquals(b.getPlayers()[1].getPawn().getPosition().getY(), 8);
    }

    @Test
    public void testMovePawnOnBoard1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.getPlayers()[0], new Position(2, 8));
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(b.getPlayers()[0].getPawn().getPosition().getX(), 2);
        assertEquals(b.getPlayers()[0].getPawn().getPosition().getY(), 8);
    }

    @Test
    public void testMovePawnOnBoard2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.movePawnOnBoard(b.getPlayers()[0], new Position(2, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(4, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(6, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(8, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(10, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(12, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(14, 8));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(14, 10));
            b.movePawnOnBoard(b.getPlayers()[0], new Position(16, 10));
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(b.getPlayers()[0].getPawn().getPosition().getX(), 16);
        assertEquals(b.getPlayers()[0].getPawn().getPosition().getY(), 10);
    }

    @Test
    public void testSetWallOnBoard1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.getPlayers()[0], new Wall(), WallDirection.Horizontal, new Position(5, 3));
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(b.getBoardBoxes()[4][3].getisOccuped(), true);
        assertEquals(b.getBoardBoxes()[5][3].getisOccuped(), true);
        assertEquals(b.getBoardBoxes()[6][3].getisOccuped(), true);
        assertEquals(b.getBoardBoxes()[4][3].getisWallBox(), true);
        assertEquals(b.getBoardBoxes()[5][3].getisWallBox(), true);
        assertEquals(b.getBoardBoxes()[6][3].getisWallBox(), true);
    }

    @Test
    public void testSetWallOnBoard2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        try {
            b.setWallOnBoard(b.getPlayers()[0], new Wall(), WallDirection.Vertical, new Position(5, 3));
        } catch (Exception e) {
            System.out.println(e);
        }
        assertEquals(b.getBoardBoxes()[5][2].getisOccuped(), true);
        assertEquals(b.getBoardBoxes()[5][3].getisOccuped(), true);
        assertEquals(b.getBoardBoxes()[5][4].getisOccuped(), true);
        assertEquals(b.getBoardBoxes()[5][2].getisWallBox(), true);
        assertEquals(b.getBoardBoxes()[5][3].getisWallBox(), true);
        assertEquals(b.getBoardBoxes()[5][4].getisWallBox(), true);
    }
}
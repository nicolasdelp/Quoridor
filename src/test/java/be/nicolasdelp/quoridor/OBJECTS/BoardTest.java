package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testCreateBoard1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[0].getWalls().length, 10);
    }

    @Test
    public void testCreateBoard2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getBoardBoxes()[10][4].getisPawnBox(), true);
    }

    @Test
    public void testCreateBoard3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getBoardBoxes()[3][5].getisPawnBox(), false);
    }

    @Test
    public void testCreateBoard4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getBoardBoxes()[16][16].getisPawnBox(), true);
    }

    @Test
    public void testCreateBoard5(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.getBoardBoxes()[0][0].getisPawnBox(), true);
    }

    @Test
    public void testCreateBoard6(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[0].getPawn().getPosition().getX(), 0);
    }

    @Test
    public void testCreateBoard7(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[0].getPawn().getPosition().getY(), 8);
    }

    @Test
    public void testCreateBoard8(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[1].getPawn().getPosition().getX(), 16);
    }

    @Test
    public void testCreateBoard9(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[1].getPawn().getPosition().getY(), 8);
    }

    @Test
    public void testCreateBoard10(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[2].getWalls().length, 5);
    }

    @Test
    public void testCreateBoard11(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[3].getPawn().getPosition().getX(), 8);
    }

    @Test
    public void testCreateBoard12(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[3].getPawn().getPosition().getY(), 16);
    }

    @Test
    public void testCreateBoard13(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[2].getPawn().getPosition().getX(), 8);
    }

    @Test
    public void testCreateBoard14(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        assertEquals(b.players[2].getPawn().getPosition().getY(), 0);
    }
}
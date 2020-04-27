package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class WallIsInBoundsTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new WallIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(1, 17));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new WallIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(17, 1));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new WallIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(-1, -1));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        WallRule wallRule = new WallIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {wallRule.verify(b, b.players[0], new Wall(), new Position(17, 17));});
    }
}
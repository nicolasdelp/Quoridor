package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class PlayerIsInBoundsTest {

    @Test
    public void testVerify(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, p[0], new Position(0, -1));
          });
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, p[0], new Position(-1, 0));
          });
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, p[0], new Position(18, 2));
          });
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, p[0], new Position(2, 18));
          });
    }
}
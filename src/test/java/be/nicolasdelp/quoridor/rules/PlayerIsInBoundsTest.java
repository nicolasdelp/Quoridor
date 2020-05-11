package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class PlayerIsInBoundsTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.getPlayers()[0], new Position(0, -2));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.getPlayers()[0], new Position(-2, 0));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.getPlayers()[0], new Position(18, 2));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.getPlayers()[0], new Position(2, 18));});
    }

    @Test
    public void testVerify5(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.getPlayers()[0], new Position(18, 18));});
    }

    @Test
    public void testVerify6(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new PlayerIsInBounds();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.getPlayers()[0], new Position(-2, -2));});
    }
}
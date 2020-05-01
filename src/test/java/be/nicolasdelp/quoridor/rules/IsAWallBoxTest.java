package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class IsAWallBoxTest {

    @Test
    public void testVerify1(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new IsAWallBox();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(1, 8));});
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new IsAWallBox();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 7));});
    }

    @Test
    public void testVerify3(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new IsAWallBox();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[0], new Position(0, 9));});
    }

    @Test
    public void testVerify4(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, ColorPawn.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, ColorPawn.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        PlayerRule playerRule = new IsAWallBox();
        Assertions.assertThrows(RuleViolated.class, () -> {playerRule.verify(b, b.players[1], new Position(15, 8));});
    }
}
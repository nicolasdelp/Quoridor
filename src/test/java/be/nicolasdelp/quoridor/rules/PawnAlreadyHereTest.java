package be.nicolasdelp.quoridor.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import be.nicolasdelp.quoridor.objects.*;

public class PawnAlreadyHereTest {

    @Test
    public void testVerify(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        b.players[0].movePawn(new Position(8, 8));
        b.getBoardBoxes()[6][8].setisOccuped(true);
        b.players[1].movePawn(new Position(6, 8));
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(6, 8));
          });
    }

    @Test
    public void testVerify2(){
        Board b = new Board();
        Player[] p = {new Player("Humain", "Nico", 0, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi1", 1, Color.Rouge, new Pawn()), new Player("Humain", "Alex", 2, Color.Rouge, new Pawn()), new Player("Ordinateur", "Ordi2", 3, Color.Rouge, new Pawn())};
        b.setPlayer(p);
        b.createBoard();
        b.movePawnOnBoard(b.players[0], new Position(8, 8));
        b.movePawnOnBoard(b.players[1], new Position(6, 8));
        PlayerRule playerRule = new PawnAlreadyHere();
        Assertions.assertThrows(RuleViolated.class, () -> {
            playerRule.verify(b, b.players[0], new Position(6, 8));
          });
    }
}
package be.nicolasdelp.quoridor.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testMovePawn(){
        Player x = new Player("Ordinateur", "Ordi1", 0, Color.Rouge, new Pawn());
        x.movePawn(new Position(7,8));
        assertEquals(x.getPawn().getPosition().getX(), 7);
        assertEquals(x.getPawn().getPosition().getY(), 8);
    }
}
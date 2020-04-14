package be.nicolasdelp.quoridor.OBJECTS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoxTest {
    
    @Test
    public void testIsPawnBox1(){
        Box b = new Box(new Position(6,3));
        b.isPawnBox();
        assertEquals(b.getisPawnBox(), false);
    }

    @Test
    public void testIsPawnBox2(){
        Box b = new Box(new Position(4,16));
        b.isPawnBox();
        assertEquals(b.getisPawnBox(), true);
    }

    @Test
    public void testIsPawnBox3(){
        Box b = new Box(new Position(14,8));
        b.isPawnBox();
        assertEquals(b.getisPawnBox(), true);
    }

    @Test
    public void testIsWallBox1(){
        Box b = new Box(new Position(6,3));
        b.isWallBox();
        assertEquals(b.getisWallBox(), true);
    }

    @Test
    public void testIsWallBox2(){
        Box b = new Box(new Position(6,4));
        b.isWallBox();
        assertEquals(b.getisWallBox(), false);
    }

    @Test
    public void testIsWallBox3(){
        Box b = new Box(new Position(11,11));
        b.isWallBox();
        assertEquals(b.getisWallBox(), true);
    }
}
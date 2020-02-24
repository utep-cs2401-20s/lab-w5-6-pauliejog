import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    /*
     * findTailExhaustive:
     * Test case 1:
     * findTailExhaustive() → exp
     */
    @Test
    public void testFindTailExh1() {
        boolean[][] a = {{true,true,true},
                        {true,false,true},
                        {false,false,true}};
        int[] exp = {1,0,6};
        SnakeGame sg = new SnakeGame(a,2,2);
        assertArrayEquals(exp,sg.findTailExhaustive());
    }

    /*
     * findTailExhaustive:
     * Test case 2:
     * findTailExhaustive() → exp
     */
    @Test
    public void testFindTailExh2() {
        boolean[][] a = {{false,true,true,false},
                        {false,false,true,false},
                        {false,true,true,false},
                        {false,true,false,false}};
        int[] exp = {3,1,6};
        SnakeGame sg = new SnakeGame(a,0,1);
        assertArrayEquals(exp,sg.findTailExhaustive());
    }
}

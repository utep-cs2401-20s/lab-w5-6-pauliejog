import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {
    @Test
    public void testFindTailExh1() {
        boolean[][] a = {{true,true,true},
                        {true,false,true},
                        {false,false,true}};
        int[] exp = {1,0,6};
        SnakeGame sg = new SnakeGame(a,2,2);
        assertArrayEquals(exp,sg.findTailExhaustive());
    }
}

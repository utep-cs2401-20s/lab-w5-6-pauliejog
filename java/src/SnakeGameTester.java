/*
 * Paulie Jo Gonzalez
 * lab w5-6
 * MW 1:30 pm
 */

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {
    /*********************************************findTailExhaustive***************************************************/
    /*
     * findTailExhaustive:
     * Test case 1: This case tests a small 3x3 array to ensure the method works for n x n 2D boolean arrays.
     * findTailExhaustive() → exp
     * PASSED
     */
    @Test
    public void testFindTailExh1() {
        boolean[][] a = {{true,true,true},
                        {true,false,true},
                        {false,false,true}};
        int[] exp = {1,0,6};
        SnakeGame sg = new SnakeGame(a,2,2);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        assertEquals(4,sg.getExhaustiveChecks());//checks exhaustiveChecks
    }

    /*
     * findTailExhaustive:
     * Test case 2: This test case is supposed to check that the method works for an
     *              n x m 2D boolean array where the head and tail share a 'y' coordinate.
     * findTailExhaustive() → exp
     * PASSED (failed the first time which is how I figured out that my initial conditions did not work)
     */
    @Test
    public void testFindTailExh2() {
        boolean[][] a = {{false,true,true,false},
                        {false,false,true,false},
                        {false,true,true,false},
                        {false,true,false,false},
                        {false,true,false,false}};
        int[] exp = {4,1,7};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        assertEquals(18,sg.getExhaustiveChecks());//checks exhaustiveChecks
    }

    /*
     * findTailExhaustive:
     * Test case 3: This test case checks that the method continues passed the head position
     *              if the hP comes before the tail (checks that the condition statements work).
     * findTailExhaustive() → exp
     * PASSED
     */
    @Test
    public void testFindTailExh3() {
        boolean[][] a = {{false,true,false},{false,true,false},{false,true,true}};
        int[] exp = {2,2,4};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        assertEquals(9,sg.getExhaustiveChecks());//checks exhaustiveChecks
    }

    /*
     * findTailExhaustive:
     * Test case 4: This test case checks that the method continues to traverse through the 2D boolean array to count
     *              the snake length even if the tail is found in the first row.
     * findTailExhaustive() → exp
     * PASSED
     */
    @Test
    public void testFindTailExh4() {
        boolean[][] a = {{true,false,true,false},
                {true,false,true,true},
                {true,false,false,true},
                {true,true,true,true}};
        int[] exp = {0,2,11};
        SnakeGame sg = new SnakeGame(a,0,0);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        assertEquals(3,sg.getExhaustiveChecks());//checks exhaustiveChecks
    }

    /*
     * findTailExhaustive:
     * Test case 5: Similar to the last test case, this one checks that the exhaustiveChecks counter works
     *              (exhChecks stops counting after tail is found, but snakeLen continues).
     * findTailExhaustive() → exp
     * PASSED
     */
    @Test
    public void testFindTailExh5() {
        boolean[][] a = {{true,true,true,true},
                {true,false,false,false},
                {true,false,true,false},
                {true,true,true,false}};
        int[] exp = {2,2,10};
        SnakeGame sg = new SnakeGame(a,0,3);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        assertEquals(11,sg.getExhaustiveChecks());//checks exhaustiveChecks
    }
    /*********************************************findTailRecursive****************************************************/
    /*
     * findTailRecursive:
     * Test case 1: This test case corresponds with testFindTailExh5(), but utilizes the recursive methods instead.
     * findTailRecursive() → exp
     * PASSED
     */
    @Test
    public void testFindTailRec1() {
        boolean[][] a = {{true,true,true,true},
                {true,false,false,false},
                {true,false,true,false},
                {true,true,true,false}};
        int[] exp = {2,2,10};
        SnakeGame sg = new SnakeGame(a,0,3);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        assertEquals(exp[2],sg.getRecursiveChecks());//snakeLen should equal recursiveChecks
    }

    /*
     * findTailRecursive:
     * Test case 2: This test case corresponds with testFindTailExh4(), but utilizes the recursive methods instead.
     * findTailRecursive() → exp
     * PASSED
     */
    @Test
    public void testFindTailRec2() {
        boolean[][] a = {{true,false,true,false},
                {true,false,true,true},
                {true,false,false,true},
                {true,true,true,true}};
        int[] exp = {0,2,11};
        SnakeGame sg = new SnakeGame(a,0,0);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        assertEquals(exp[2],sg.getRecursiveChecks());//snakeLen should equal recursiveChecks
    }

    /*
     * findTailRecursive:
     * Test case 3: This test case corresponds with testFindTailExh3(), but utilizes the recursive methods instead.
     * findTailRecursive() → exp
     * PASSED
     */
    @Test
    public void testFindTailRec3() {
        boolean[][] a = {{false,true,false},{false,true,false},{false,true,true}};
        int[] exp = {2,2,4};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        assertEquals(exp[2],sg.getRecursiveChecks());//snakeLen should equal recursiveChecks
    }

    /*
     * findTailRecursive:
     * Test case 4: This test case corresponds with testFindTailExh2(), but utilizes the recursive methods instead.
     * findTailRecursive() → exp
     * PASSED
     */
    @Test
    public void testFindTailRec4() {
        boolean[][] a = {{false,true,true,false},
                {false,false,true,false},
                {false,true,true,false},
                {false,true,false,false},
                {false,true,false,false}};
        int[] exp = {4,1,7};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        assertEquals(exp[2],sg.getRecursiveChecks());//snakeLen should equal recursiveChecks
    }

    /*
     * findTailRecursive:
     * Test case 5: This test case corresponds with testFindTailExh1(), but utilizes the recursive methods instead.
     * findTailRecursive() → exp
     */
    @Test
    public void testFindTailRec5() {
        boolean[][] a = {{true,true,true},
                        {true,false,true},
                        {false,false,true}};
        int[] exp = {1,0,6};
        SnakeGame sg = new SnakeGame(a,2,2);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        assertEquals(exp[2],sg.getRecursiveChecks());//snakeLen should equal recursiveChecks
    }
}//end class

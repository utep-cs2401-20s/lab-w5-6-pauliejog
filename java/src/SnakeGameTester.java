import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {
    /*********************************************findTailExhaustive***************************************************/
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
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        System.out.println(sg.getExhaustiveChecks());
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
                        {false,true,false,false},
                        {false,true,false,false}};
        int[] exp = {4,1,7};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        System.out.println(sg.getExhaustiveChecks());//checks that exhaustiveChecks works
    }

    /*
     * findTailExhaustive:
     * Test case 3:
     * findTailExhaustive() → exp
     */
    @Test
    public void testFindTailExh3() {
        boolean[][] a = {{false,true,false},{false,true,false},{false,true,true}};
        int[] exp = {2,2,4};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailExhaustive());
        System.out.println(sg.getExhaustiveChecks());
    }

    /*
     * findTailExhaustive:
     * Test case 4:
     * findTailExhaustive() → exp
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
        System.out.println(sg.getExhaustiveChecks());
    }

    /*
     * findTailExhaustive:
     * Test case 5:
     * findTailExhaustive() → exp
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
        System.out.println(sg.getExhaustiveChecks());
    }
    /*********************************************findTailRecursive****************************************************/
    /*
     * findTailRecursive:
     * Test case 1:
     * findTailRecursive() → exp
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
        sg.findTailRecursive();
        //System.out.println(sg.getRecursiveChecks());
    }

    /*
     * findTailRecursive:
     * Test case 2:
     * findTailRecursive() → exp
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
        //System.out.println(sg.getRecursiveChecks());
    }

    /*
     * findTailRecursive:
     * Test case 3:
     * findTailRecursive() → exp
     */
    @Test
    public void testFindTailRec3() {
        boolean[][] a = {{false,true,false},{false,true,false},{false,true,true}};
        int[] exp = {2,2,4};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        System.out.println(sg.getRecursiveChecks());
    }

    /*
     * findTailRecursive:
     * Test case 4:
     * findTailRecursive() → exp
     */
    @Test
    public void testFindTailRec4() {//CHANGE THIS
        boolean[][] a = {{false,true,false},{false,true,false},{false,true,true}};
        int[] exp = {2,2,4};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        System.out.println(sg.getRecursiveChecks());
    }

    /*
     * findTailRecursive:
     * Test case 5:
     * findTailRecursive() → exp
     */
    @Test
    public void testFindTailRec5() {//CHANGE THIS
        boolean[][] a = {{false,true,false},{false,true,false},{false,true,true}};
        int[] exp = {2,2,4};
        SnakeGame sg = new SnakeGame(a,0,1);
        sg.printBoard();
        assertArrayEquals(exp,sg.findTailRecursive());
        System.out.println(sg.getRecursiveChecks());
    }
}//end class

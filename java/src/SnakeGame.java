public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        this.game = new boolean[1][1];
    }//default constructor

    public SnakeGame(boolean[][] arr, int a, int b) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++)
                this.game[i][j] = arr[i][j];
        }
        this.headPosition[0] = a;
        this.headPosition[1] = b;
    }//constructor



    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }//exhaustiveChecks getter

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }//recursiveChecks getter
}//end class

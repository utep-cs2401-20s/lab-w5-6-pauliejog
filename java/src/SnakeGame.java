public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        this.game = new boolean[1][1];
    }//default constructor

    public SnakeGame(boolean[][] arr, int x, int y) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++)
                this.game[i][j] = arr[i][j];
        }
        this.headPosition = new int[2];
        this.headPosition[0] = x;
        this.headPosition[1] = y;
    }//constructor

    public int[] findTailExhaustive() {
        resetCounters();
        int[] result = new int[3];
        int snakeLen = 0;//increment every time it is true
        for(int i = 0; i < this.game.length; i++) {
            for(int j = 0; j < this.game[i].length; j++) {
                int n = neighbors(i,j);
                this.exhaustiveChecks++;
                if(!game[i][j]) continue;//next iteration
                else {
                    snakeLen++;
                    if(n != 1) continue;
                    else if(n == 1 && i != headPosition[0] && j != headPosition[1]) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        result[2] = snakeLen;
        return result;
    }//end findTailEx

    public int[] findTailRecursive() {
        return new int[]{1};
    }//end findTailRec
    public int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        return new int[]{1};
    }//end findTailRec

    private void resetCounters() {
        this.exhaustiveChecks = 0;
        this.recursiveChecks = 0;
    }//end resetCounters


    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }//exhaustiveChecks getter

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }//recursiveChecks getter

    public int neighbors(int r, int c) {//counts neighbors
        int count = 0;
        int up = r - 1;
        int down = r + 1;
        int left = c - 1;
        int right = c + 1;

        if(up > -1) {
            if(game[up][c])        count++;
        }
        if(left > -1) {
            if(game[r][left])      count++;
        }
        if(right < game[0].length) {
            if(game[r][right])     count++;
        }
        if(down < game.length) {
            if(game[down][c])      count++;
        }
        return count;
    }//end neighbors
}//end class

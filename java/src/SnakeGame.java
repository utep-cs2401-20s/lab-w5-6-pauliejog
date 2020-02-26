public class SnakeGame {
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    public SnakeGame() {
        this.game = new boolean[1][1];
    }//default constructor

    public SnakeGame(boolean[][] arr, int x, int y) {
        this.game = new boolean[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                this.game[i][j] = arr[i][j];
            }
        }
        this.headPosition = new int[2];
        this.headPosition[0] = x;
        this.headPosition[1] = y;
    }//constructor

    public int[] findTailExhaustive() {
        resetCounters();
        boolean tailFound = false;
        int[] result = new int[3];
        int snakeLen = 0;//increment every time it is true
        for(int i = 0; i < this.game.length; i++) {
            for(int j = 0; j < this.game[i].length; j++) {
                boolean checkCell = game[i][j];
                if(!tailFound)
                    this.exhaustiveChecks++;
                if(checkCell) {
                    snakeLen++;
                    int n = neighbors(i,j);
                    if(n == 1 && !(i == this.headPosition[0] && j == this.headPosition[1])) {
                        result[0] = i;
                        result[1] = j;
                        tailFound = true;
                    }
                }
            }
        }
        result[2] = snakeLen;
        return result;
    }//end findTailEx

    public int[] findTailRecursive() {
        resetCounters();
        return findTailRecursive(headPosition,headPosition);
    }//end findTailRec

    public int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
        int[] result = new int[3];//x,y,snakeLen
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

    public void printBoard() {
        for(int r = 0; r < game.length; r++) {
            for(int c = 0; c < game[r].length; c++) {
                if(game[r][c])
                    System.out.print("x" + " ");
                else
                    System.out.print("-" + " ");
            }
            System.out.println();
        }
    }//end printBoard
}//end class
